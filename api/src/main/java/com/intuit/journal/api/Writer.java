package com.intuit.journal.api;

import java.io.Closeable;
import java.util.concurrent.Future;

/**
 * Created by rsingh13
 * Writer interface to write to Journal
 */
public interface Writer extends Closeable{
    public Future<AtomicBatchMetadata> write(AtomicBatch payload);
}
