package com.huangliusong.concurrency.example.syn;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author huangliusong
 * @since 2019/12/16
 * {@link }
 */
@Slf4j
public class CopyOnWriteArrayListExample {
    private static int clientTotal = 5000;
    private static int threadTotal = 200;

    private static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exceptio000 ", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", list.size());
    }

    private static void update(int i) {
        list.add(i);
    }
}
