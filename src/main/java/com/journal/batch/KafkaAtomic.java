package com.journal.batch;

import com.journal.AtomicBatch;
import com.journal.LogRecord;
import com.journal.Token;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Composite class for AtomicBatch .
 * It creates multiple json based Batches to be pushed to Kafka
 *
 * Created by rsingh13
 */
public class KafkaAtomic<T> implements AtomicBatch<T> {

    private Token id = Token.getTimeBased();

    //TODO : Check if we can just used HashMap , since this will be a single threaded application
    private final ConcurrentHashMap<String ,List<T>> batch;
    private AtomicInteger size;

    public KafkaAtomic() {
        batch = new ConcurrentHashMap<String,List<T>();
    }

    @Override
    public Token Id() {
        return id;
    }

    /**
     * Its not a o(1) operation , its o(n) operation
     * @return size of the batch
     */
    @Override
    public int size() {
        return size.get();
    }

    /**
     * O(1) operation
     * @return
     */
    @Override
    public boolean isEmpty() {
        return batch.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return batch.contains( o );
    }

    @Override
    public Iterator<T> iterator() {
        return batch.iterator();
    }

    @Override
    public boolean add(T logRecord) {
        return batch.add(logRecord);
    }

    @Override
    public LogRecord remove(T logRecord) {
        return null;
    }

    /**
     * TODO:Need to implement a visitor pattern here.
     */
    @Override
    public void serialize() {
        serializer.serialize( this );
    }
}
