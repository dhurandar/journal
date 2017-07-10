package com.intuit.journal.api;

import java.util.Iterator;

/**
 * Created by rsingh13
 */
public interface AtomicBatch<T> {
    Token Id();

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<T> iterator();

    boolean add(T logRecord);

    LogRecord remove(T logRecord);

    void serialize();
}