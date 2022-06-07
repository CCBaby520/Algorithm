package com.stu.leetcode.dsl.easy;

import java.util.Collections;
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

    public static Map<String,String> map = new HashMap<>();
    static {
       map.put("IV","a");
       map.put("IX","b");
       map.put("XL","c");
       map.put("XC","d");
       map.put("CD","e");
       map.put("CM","f");
    }
    public static void main(String[] args) {
        String s = "MV";
        int toInt = romanToInt(s);
        System.out.println(toInt);
    }

    public static int romanToInt(String s) {
        long begin = System.currentTimeMillis();

        String s1 = map.get(s);
        if(null != s1){
            s=s1;
        }
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += which(s.charAt(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("测试1耗时："+ String.valueOf(end-begin));
        return result;
    }

    public static int which(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }
}
