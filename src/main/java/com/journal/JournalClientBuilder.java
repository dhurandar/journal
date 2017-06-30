package com.journal;

import com.google.common.base.Preconditions;

/**
 * Created by rsingh13 on 5/30/17.
 */
public final class JournalClientBuilder {

    private String _name = null;
    private String _clientId = null;
    private Partitioner _partitioner = null;

    /**
     * Create a client builder
     *
     * @return client builder
     */
    public static JournalClientBuilder newBuilder() {
        return new JournalClientBuilder();
    }

    public static JournalClientBuilder newBuilder(JournalClientBuilder builder) {
        JournalClientBuilder newBuilder = new JournalClientBuilder();
        newBuilder._name = builder._name;
        newBuilder._clientId = builder._clientId;
        newBuilder._partitioner = builder._partitioner;
        return newBuilder;
    }

    // private constructor
    private JournalClientBuilder() {}

    /**
     * Client Name.
     *
     * @param name
     *          client name
     * @return client builder.
     */
    public JournalClientBuilder name(String name) {
        JournalClientBuilder newBuilder = newBuilder(this);
        newBuilder._name = name;
        return newBuilder;
    }

    /**
     * Client ID.
     *
     * @param clientId
     *          client id
     * @return client builder.
     */
    public JournalClientBuilder clientId(String clientId) {
        JournalClientBuilder newBuilder = newBuilder(this);
        newBuilder._clientId = clientId;
        return newBuilder;
    }

    /**
     * Partitioner to decide on how to partition the Keys.
     * If none supplied default partition is used to partition the
     * Data.
     *
     * @param partitioner
     *
     * @return client builder
     */
    public JournalClientBuilder partitioner(Partitioner partitioner) {
        JournalClientBuilder newBuilder = newBuilder(this);
        newBuilder._partitioner = partitioner;
        return newBuilder;
    }

    /**
     * Build JournalClient client.
     *
     * @return JournalClient client.
     */
    public JournalClientImpl build() {
        return buildClient();
    }

    JournalClientImpl buildClient() {
        Preconditions.checkNotNull(_name, "No name provided.");
        Preconditions.checkNotNull(_clientId, "No client id provided.");
        JournalClientImpl clientImpl =
                new JournalClientImpl(
                        _name, _clientId);
        return clientImpl;
    }

    private class JournalClientImpl implements JournalClient {
        public JournalClientImpl(String name, String clientId) {

        }

        public Token write(AtomicBatch<LogRecord> LogRecord) {
            return null;
        }

        @Override
        public AtomicBatch read() {
            return null;
        }

        public String name() {
            return null;
        }

        public void close() {

        }

    }
}
