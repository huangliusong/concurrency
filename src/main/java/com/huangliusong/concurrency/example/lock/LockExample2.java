package com.huangliusong.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author huangliusong
 * @since 2019/12/16
 * {@link }
 */
@Slf4j
public class LockExample2 {

    private final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<String, Data> map = new TreeMap<String, Data>();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public static void main(String[] args) {

    }

    public Data get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getALlKey() {
        writeLock.lock();
        try {
            return map.keySet();
        } finally {
            writeLock.unlock();
        }
    }

    public Data put(String key, Data value) {
        writeLock.lock();
        try {
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    class Data {

    }
}
