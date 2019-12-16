package com.huangliusong.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * @author huangliusong
 * @since 2019/12/15
 * {@link }
 */
public class ImmutableExample1 {
    private final static ImmutableList list = ImmutableList.of(1, 2, 3, 4);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    private final static ImmutableMap<Integer,Integer> map=ImmutableMap.of(1,2,3,4);
    public static void main(String[] args) {
        System.out.println(map.get(1));
    }

}
