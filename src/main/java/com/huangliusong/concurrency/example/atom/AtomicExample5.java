package com.huangliusong.concurrency.example.atom;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author huangliusong
 * @since 2019/12/15
 * {@link }
 */
@Slf4j
public class AtomicExample5 {
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");
    private static AtomicExample5 example5 = new AtomicExample5();
    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success={}", example5.getCount());
        }
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success={}", example5.getCount());
        }
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success={}", example5.getCount());
        } else {
            log.error("update failed={}", example5.getCount());
        }

    }
}
