package com.intuit.journal;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by rsingh13 on 6/20/17.
 * <i>LogReader</i> is a `synchronous` reader reading records from a DL log.
 *
 * <h3>Lifecycle of a Reader</h3>
 *
 * A reader is a <i>sequential</i> reader that read records from a Kafka Partition log starting
 * from a given position. The position could be a <i>last committed offset</i>
 * or a <i>Token</i>
 *
 * Closing the reader (via {@link #close()} will release all the resources occupied
 * by this reader instance. Typically these resources will be Kafka resources .
 *
 * Example TODO write actual Kafka code:
 * <pre>
 * LogReader reader = journalClient.getInputStream();
 * KafkaAtomic batch = new KafkaAtomic();
 *
 * while (true) { // keep reading & processing records
 *     KafkaAtomic batch;
 *     try {
 *         batch = readNext();
 *         }catch
 *         // handle the exception
 *     }
 * }
 * </pre>
 */

public interface Reader extends Closeable {
    /**
     * Read the next <i>KafkaAtomic</i> log records from the stream
     *
     * @param nonBlocking should the read make blocking calls to the backend or rely on the
     * readAhead cache
     * @return an operation from the stream or empty list if at end of stream
     * @throws IOException if there is an error reading from the stream
     */
    public AtomicBatch<LogRecord> readBatch(boolean nonBlocking) throws IOException;
}
