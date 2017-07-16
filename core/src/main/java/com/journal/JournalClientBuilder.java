package com.journal;

import com.google.common.base.Preconditions;
import com.intuit.journal.api.AtomicBatch;
import com.intuit.journal.api.LogRecord;
import com.intuit.journal.api.Token;

/**
 * Created by rsingh13 on 5/30/17.
 */
public final class JournalClientBuilder {

    private String _name = null;
    private String _clientId = null;

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
     * Build JournalClient client.
     * @return JournalClient client.
     */
    public JournalClientImpl build() {
        return buildClient();
    }

    JournalClientImpl buildClient() {
        return null;
    }

    private class JournalClientImpl {
        public JournalClientImpl(String name, String clientId) {
        }
    }
}
