package com.txz.two.hundred.and.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taxz on 2019/2/1/001.
 * GitHub:https://github.com/Taxz
 */
public class Solution {

    //自己写的 通过将字符串序列转换成数字，判断是否相等 耗时80ms...伤不起
    /*public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        return coutChar(s,t);
    }*/

    private boolean coutChar(String tmp,String tmp2) {
        int res =0;
        int res2 =0;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < tmp.length(); i++) {
            if (map.containsKey(tmp.charAt(i) + "")) {
                res = (map.get(tmp.charAt(i)+"") +1) + res * 10;
            } else {
                res = res * 10 + (i + 1);
                map.put(tmp.charAt(i) + "", i);
            }
            if (map2.containsKey(tmp2.charAt(i) + "")) {
                res2 = (map2.get(tmp2.charAt(i)+"") +1) + res2 * 10;
            } else {
                res2 = res2 * 10 + (i + 1);
                map2.put(tmp2.charAt(i) + "", i);
            }
            if (res != res2) {
                return false;
            }
        }
        return true;
    }
    // 大神所做 使用map实现
    /*public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sE = s.charAt(i);
            char tE = t.charAt(i);
            Character sVal = sMap.get(sE);
            if (sVal == null) {
                if (tMap.containsKey(tE)) {
                    return false;
                }
                sMap.put(sE, tE);
                tMap.put(tE, sE);
                continue;
            }
            //若s中存在，则判断映射的值是否相等
            if (sVal != tE) {
                return false;
            }
        }
        return true;
    }*/

    // 大神所做 通过偏移量，在同一个数组进行比较
   public boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] map = new int[512];
        for (int i = sc.length-1;i >= 0;i--) {

            if (map[sc[i]] != map[tc[i]+256]) {
                return false;
            }
            map[sc[i]] = map[tc[i] + 256] = i;
        }
        return true;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ad";
        String t = "aa";
        System.out.println(solution.isIsomorphic(s,t));
    }
}
