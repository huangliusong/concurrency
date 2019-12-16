package com.huangliusong.concurrency.example.SingletonExample1;

import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉
 *
 * @author huangliusong
 * @since 2019/12/15
 * {@link }
 */
@Slf4j
public class SingletonExample1 {

    private static SingletonExample1 instance = null;

    private SingletonExample1() {

    }

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}