package com.huangliusong.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangliusong
 * @since 2019/12/15
 * {@link }
 */
@Slf4j
public class SynchronizedExample2 {

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }

    //修饰代码块
    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1-------{}      {}", i,j);
            }
        }
    }

    //修饰代码块
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.error("test2-{}    {}", i,j);
        }
    }
}
