package com.huangliusong.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangliusong
 * @since 2019/12/16
 * {@link }
 */
@Slf4j
public class ThreadPoolExample2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task:{}", index);
                }
            });
        }
        executorService.shutdown();
    }
}
