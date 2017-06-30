package com.intuit.journal;

/**
 * com.intuit.journal.Partitioner
 * Created by rsingh13
 * If 1 wants to partition journal writes based on source keys
 *
 */
public interface Partitioner<KEY> {
    int partition(KEY key, int totalPartitions);
}

