package com.huangliusong.concurrency.example.SingletonExample1;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉
 *
 * @author huangliusong
 * @since 2019/12/15
 * {@link }
 */
@Slf4j
public class SingletonExample2 {

    private static SingletonExample2 instance = new SingletonExample2();

    private SingletonExample2() {

    }

    public static SingletonExample2 getInstance() {

        return instance;
    }
}