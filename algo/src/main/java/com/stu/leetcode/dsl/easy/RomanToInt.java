package com.stu.leetcode.dsl.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * @desc: 罗马数字由 I,V,X,L,C,D,M 构成；
 * 当小值在大值的左边，则减小值，如 IV=5-1=4；
 * 当小值在大值的右边，则加小值，如 VI=5+1=6；
 * 右值永远为正，因此最后一位必然为正。
 *
 */
public class RomanToInt {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int toInt = romanToInt(s);
        System.out.println(toInt);
    }

    public static int romanToInt(String s) {
        long begin = System.currentTimeMillis();

        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        long end = System.currentTimeMillis();
        System.out.println("测试1耗时："+ String.valueOf(end-begin));
        return sum;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
