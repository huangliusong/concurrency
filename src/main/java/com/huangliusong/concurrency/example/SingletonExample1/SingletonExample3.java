package com.huangliusong.concurrency.example.SingletonExample1;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉-双重同步锁
 *
 * @author huangliusong
 * @since 2019/12/15
 * {@link }
 */
@Slf4j
public class SingletonExample3 {

    private static SingletonExample3 instance = null;

    private SingletonExample3() {

    }

    public static SingletonExample3 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample3.class) {
                instance = new SingletonExample3();
            }
        }
        return instance;
    }
}