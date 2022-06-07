package com.stu.leetcode.dsl.easy;

import java.util.*;

/**
 * 找出数组中所有的重复数和重复次数
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        int[] nums = new int[10000];
        for (int i=0; i<10000;i++){
            nums[i] =  (int)(Math.random()*10000+1);
        }
        long begin = System.currentTimeMillis();

        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer num = map.get(i);
            if(num == null){
                map.put(i,1);
            }else {
                map.put(i,map.get(i)+1);
            }
        }

        Map<Integer,Integer> rsMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            Integer value = en.getValue();
            if(value > 1){
                rsMap.put(en.getKey(),value);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("测试1耗时："+ String.valueOf(end-begin));
        System.out.println(rsMap);
    }



}
