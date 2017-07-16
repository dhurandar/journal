package com.intuit.journal.api;

import java.util.Iterator;

/**
 * Created by rsingh13
 */
public interface AtomicBatch {
    Token Id();

    int size();

    boolean isEmpty();

    boolean contains(LogRecord o);

    Iterator<LogRecord> iterator();

    void add(LogRecord logRecord);

    LogRecord remove(LogRecord logRecord);
}
