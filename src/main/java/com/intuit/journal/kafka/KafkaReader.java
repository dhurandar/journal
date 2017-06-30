package com.intuit.journal.kafka;

import com.intuit.journal.LogRecord;
import com.intuit.journal.Reader;
import com.intuit.journal.AtomicBatch;

import java.io.IOException;

/**
 * Created by rsingh13
 */
public class KafkaReader implements Reader{
    /**
     * Read the next <i>KafkaAtomic</i> log records from the stream
     *
     * @param nonBlocking should the read make blocking calls to the backend or rely on the
     *                    readAhead cache
     * @return an operation from the stream or empty list if at end of stream
     * @throws IOException if there is an error reading from the stream
     */
    public AtomicBatch<LogRecord> readBatch(boolean nonBlocking) throws IOException {
        return null;
    }

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     * <p>
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     *
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException {

    }
}
