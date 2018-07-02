package com.lucky.utils;

/**
 * @author 600006
 * @version 1.0
 */
public class BaseUtil {

    public static void change(String a,String b,char[] ch){
        a = "abc";
        b = "bcd";
        ch[0] = '1';
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "345";
        char[] ch = {'a','b','c','d','e'};

        change(a,b,ch);

        System.out.println(a);
        System.out.println(b);
        System.out.println(ch);

    }



}
