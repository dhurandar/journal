package com.intuit.journal;

import com.intuit.journal.LogRecord;
import com.intuit.journal.Token;

import java.util.Iterator;

/**
 * Created by rsingh13 on 6/28/17.
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
