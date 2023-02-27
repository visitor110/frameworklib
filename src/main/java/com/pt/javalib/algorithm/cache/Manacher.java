package com.pt.javalib.algorithm.cache;

/**
 * @author : PT
 * @date : create in 2023/01/01 14:25
 * <p></p>
 **/
public class Manacher {
    public String longestPalindrome(String s) {

        char[] str = generateChar(s);
        int[] arr = new int[str.length];
        int C = -1, R = -1;
        int maxR = Integer.MIN_VALUE;
        int maxC = -1;
        for(int i = 0 ; i < str.length; i++){
            arr[i] = R > i ? Math.min(R - i, arr[2 * C - i]) : 1;
            while(i + arr[i] < str.length && i - arr[i] >= 0){
                if(str[i + arr[i]] == str[i - arr[i]]){
                    arr[i]++;
                }else{
                    break;
                }
            }
            if(arr[i] > R){
                R = arr[i];
                C = i;
            }
            if(maxR < R){
                maxR = R;
                maxC = C;
            }
        }
        int startIndex = (maxC - (maxR - 1)) / 2;
        int endIndex = startIndex + (2 * maxR - 1) / 2;

        return s.substring(startIndex, endIndex);

    }

    private char[] generateChar(String s){
        char[] str = s.toCharArray();
        char[] result = new char[str.length * 2 + 1];
        result[0] = '#';
        for(int i = 0 ; i < str.length; i++){
            result[i * 2 + 1] = str[i];
            result[i * 2 + 2] = '#';
        }
        return result;
    }
}
