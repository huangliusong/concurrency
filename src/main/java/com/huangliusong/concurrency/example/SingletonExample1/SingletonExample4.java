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
public class SingletonExample4 {

    private static SingletonExample4 instance = null;


    static {
        instance = new SingletonExample4();
    }

    private SingletonExample4() {

    }

    public static SingletonExample4 getInstance() {

        return instance;
    }
}