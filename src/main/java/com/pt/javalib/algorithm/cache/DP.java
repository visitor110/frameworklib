package com.pt.javalib.algorithm.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : PT
 * @date : create in 2022/12/04 18:59
 * <p></p>
 **/
public class DP {

    public List<String> strAllExplian(String str) {
        char[] chars = str.toCharArray();
        List<String> result = new ArrayList<>();

        call(result, chars, 0);
        return result;

    }

    private void call(List<String> result, char[] chars, int index) {

        if (index == chars.length) {
            result.add(String.valueOf(chars));
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            call(result, chars, index + 1);
            swap(chars, i, index);
        }


    }

    private void swap(char[] chars, int pos1, int pos2) {
        char temp = chars[pos1];
        chars[pos1] = chars[pos2];
        chars[pos2] = temp;
    }


}
