package com.git.wuqf.common;

public class ReverseInter {
    public static void main(String[] args) {
        int resul=reverse(-123);
    }

    public static int reverse(int x) {
        if(x>=0){
            return reversePositiveInt(x);
        }
        return -reversePositiveInt(-x);
    }

    public static int reversePositiveInt(int x) {
        try {

            StringBuilder sb = new StringBuilder(String.valueOf(x)).reverse();
            int result = Integer.valueOf(sb.toString());
            return result;

        } catch (Exception e) {
            return 0;
        }
    }
}
