package com.journal;

import java.io.Closeable;
import java.util.concurrent.Future;

/**
 * Created by rsingh13 on 6/9/17.
 */
public interface Writer<V> extends Closeable{
    public Future<V> write(V v);
}
