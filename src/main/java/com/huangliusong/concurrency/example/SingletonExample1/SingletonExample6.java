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
public class SingletonExample6 {


    private volatile static SingletonExample6 instance = null;

    private SingletonExample6() {

    }

    public static SingletonExample6 getInstance() {

        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample6 singletonExample6;

        /**
         * jvm保证整个方法只调用一次
         */
        Singleton() {
            singletonExample6 = new SingletonExample6();
        }

        public SingletonExample6 getInstance() {
            return singletonExample6;
        }
    }

}