package com.intuit.journal.api;

import java.util.Map;

/**
 * Created by rsingh13.
 * The metadata for a record that has been acknowledged by the server
 */
public final class AtomicBatchMetadata {

    private final Map<String,Long> offset;
    private final long timestamp;
    private final Token token;

    private AtomicBatchMetadata(Map<String,Long> offset, long timestamp, Token
            token) {
        super();
        this.offset = offset;
        this.timestamp = timestamp;
        this.token = token;
    }

    /**
     * The offset of the AtomicBatch in the topic/partition.
     */
    public Map<String,Long> offset() {
        return this.offset;
    }

    /**
     * The timestamp of the record in the topic/partition.
     */
    public long timestamp() {
        return timestamp;
    }

    /**
     * The token for this AtomicBatch.
     */
    public Token token() {
        return this.token;
    }
}
