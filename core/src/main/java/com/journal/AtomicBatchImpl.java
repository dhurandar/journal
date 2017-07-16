package com.journal;

import com.google.common.base.Preconditions;
import com.intuit.journal.api.AtomicBatch;
import com.intuit.journal.api.LogRecord;
import com.intuit.journal.api.Token;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rsingh13.
 */
public class AtomicBatchImpl implements AtomicBatch{

    private Map<String,LogRecord> batch = new ConcurrentHashMap<>(  );

    @Override
    public Token Id() {
        return null;
    }

    @Override
    public int size() {
        return batch.size();
    }

    @Override
    public boolean isEmpty() {
        return batch.isEmpty();
    }

    @Override
    public boolean contains(LogRecord o) {
        Preconditions.checkNotNull( o);
        return batch.containsKey( o.getId() );
    }

    @Override
    public Iterator<LogRecord> iterator() {
        return batch.values().iterator();
    }

    @Override
    public void add(LogRecord logRecord) {
        Preconditions.checkNotNull( logRecord );
        batch.put(logRecord.getId(),logRecord );
    }

    @Override
    public LogRecord remove(LogRecord logRecord) {
        return batch.remove( logRecord.getId() );
    }
}
