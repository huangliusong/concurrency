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
public class SingletonExample5 {

    private volatile static SingletonExample5 instance = null;

    private SingletonExample5() {

    }

    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                instance = new SingletonExample5();
            }
        }
        return instance;
    }
}