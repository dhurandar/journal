package com.journal.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;



/**
 * Created by rsingh13 on 5/31/17.
 */
public class UUIDs {

    private static final long CLOCK_SEQ_AND_NODE = makeClockSeqAndNode();


    /**
     * Creates a new time-based (version 1) UUID.
     * <p>
     * UUID generated by this method are suitable for use with the
     * {@code timeuuid} Cassandra type. In particular the generated UUID
     * includes the timestamp of its generation.
     *
     * @return a new time-based UUID.
     */
    public static UUID timeBased() {
        return new UUID(makeMSB(System.nanoTime()), CLOCK_SEQ_AND_NODE);
    }


    // Package visible for testing
    static long makeMSB(long timestamp) {
        long msb = 0L;
        msb |= (0x00000000ffffffffL & timestamp) << 32;
        msb |= (0x0000ffff00000000L & timestamp) >>> 16;
        msb |= (0x0fff000000000000L & timestamp) >>> 48;
        msb |= 0x0000000000001000L; // sets the version to 1.
        return msb;
    }

    private static long makeClockSeqAndNode() {
        long clock = new Random(System.currentTimeMillis()).nextLong();
        long node = makeNode();

        long lsb = 0;
        lsb |= (clock & 0x0000000000003FFFL) << 48;
        lsb |= 0x8000000000000000L;
        lsb |= node;
        return lsb;
    }

    private static long makeNode() {

        /*
         * We don't have access to the MAC address (in pure JAVA at least) but
         * need to generate a node part that identify this host as uniquely as
         * possible.
         * The spec says that one option is to take as many source that
         * identify this node as possible and hash them together. That's what
         * we do here by gathering all the ip of this host as well as a few
         * other sources.
         */
        try {

            MessageDigest digest = MessageDigest.getInstance("MD5");
            for (String address : getAllLocalAddresses())
                update(digest, address);

            Properties props = System.getProperties();
            update(digest, props.getProperty("java.vendor"));
            update(digest, props.getProperty("java.vendor.url"));
            update(digest, props.getProperty("java.version"));
            update(digest, props.getProperty("os.arch"));
            update(digest, props.getProperty("os.name"));
            update(digest, props.getProperty("os.version"));

            byte[] hash = digest.digest();

            long node = 0;
            for (int i = 0; i < 6; i++)
                node |= (0x00000000000000ffL & (long)hash[i]) << (i*8);
            // Since we don't use the mac address, the spec says that multicast
            // bit (least significant bit of the first byte of the node ID) must be 1.
            return node | 0x0000010000000000L;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static void update(MessageDigest digest, String value) {
        if (value != null)
            digest.update(value.getBytes( StandardCharsets.UTF_8));
    }

    private static Set<String> getAllLocalAddresses() {
        Set<String> allIps = new HashSet<String>();
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            allIps.add(localhost.toString());
            // Also return the hostname if available, it won't hurt (this does a dns lookup, it's only done once at startup)
            allIps.add(localhost.getCanonicalHostName());
            InetAddress[] allMyIps = InetAddress.getAllByName(localhost.getCanonicalHostName());
            if (allMyIps != null) {
                for (int i = 0; i < allMyIps.length; i++)
                    allIps.add(allMyIps[i].toString());
            }
        } catch (UnknownHostException e) {
            // Ignore, we'll try the network interfaces anyway
        }

        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            if (en != null) {
                while (en.hasMoreElements()) {
                    Enumeration<InetAddress> enumIpAddr = en.nextElement().getInetAddresses();
                    while (enumIpAddr.hasMoreElements())
                        allIps.add(enumIpAddr.nextElement().toString());
                }
            }
        } catch (SocketException e) {
            // Ignore, if we've really got nothing so far, we'll throw an exception
        }

        return allIps;
    }
}