package com.huangliusong.concurrency.example.threadlocal;

/**
 * @author huangliusong
 * @since 2019/12/16
 * {@link }
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolad=new ThreadLocal<>();
}
