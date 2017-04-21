package com.test;

/**
 * Created by Kaijia Wei on 2017/4/7.
 */
public class StringReverseTest {
    public String reverseString1(String s) {
        StringBuilder result = new StringBuilder();
        if (null == s || "".equals(s.trim())){
            return result.toString();
        }
        for (int i = s.length()-1; i>=0 ; i--){
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public String reverseString2(String s) {
        if (null == s ){
            return "";
        }
        char[] chars = s.toCharArray();
        int i = 0,j=chars.length-1;
        char temp;
        while (i<j){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
