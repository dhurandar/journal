package com.intuit.journal.api;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by rsingh13
 * <i>LogReader</i> is a `synchronous` reader reading records from a DL log.
 * <pre>
 * while (true) {
 * // keep reading & processing records
 *  LogRecord record;
 *  try {
 *  record = reader.readNext(false);
 *  nextTxId = record.getTransactionId();
 * process the record
 * } catch (IOException ioe) {
 * </pre>
 */

public interface Reader<V> extends Closeable {
    public V readBatch(boolean nonBlocking) throws IOException;
}
