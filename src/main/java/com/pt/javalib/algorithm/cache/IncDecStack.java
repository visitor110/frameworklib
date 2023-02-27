package com.pt.javalib.algorithm.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : PT
 * @date : create in 2022/11/22 17:20
 * <p>单调栈(有重复值),求离自己最近的小于自己的值的位置</p>
 **/
public class IncDecStack {

    // 栈底到栈顶 从小到大
    public int[][] generate(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]){
                List<Integer> list = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer index : list) {
                    res[index][0] = left;
                    res[index][1] = i;
                }
            }
            if(!stack.isEmpty() && arr[i] == arr[stack.peek().get(0)]){
                stack.peek().add(Integer.valueOf(i));
            }else{
                ArrayList<Integer> list = new ArrayList<>(1);
                list.add(Integer.valueOf(i));
                stack.push(list);
            }
        }

        while(!stack.isEmpty()){
            List<Integer> list = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer index : list) {
                res[index][0] = left;
                res[index][1] = -1;
            }
        }
        return  res;
    }

}
