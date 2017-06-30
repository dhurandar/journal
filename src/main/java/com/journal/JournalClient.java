package com.journal;

import java.io.Closeable;
import java.io.Serializable;

/**
 * Created by rsingh13
 */
public interface JournalClient extends Closeable,Serializable{

    /**
     * Write <i>LogRecord</i> in batch to current <i>journal</i>. Return a
     * Future with transactionID, one for each submitted record.
     *
     * If there is 1 LogRecord to write , pass Set with size 1.
     *
     * In the event of a partial
     * failure--ex. some specific record write fails, all subsequent writes
     * will also fail.
     *
     * @param LogRecord
     *          LogRecord to write.
     * @return a list of futures, one for each submitted record.
     */
    Token write(AtomicBatch<LogRecord> LogRecord);


    AtomicBatch read();

    /**
     * @return name of the current Journal.
     */
    String name();

    /**
     * Close the client.
     */
    void close();
}

