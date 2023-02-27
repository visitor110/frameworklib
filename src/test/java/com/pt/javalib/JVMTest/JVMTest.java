package com.pt.javalib.JVMTest;

import com.pt.javalib.JavalibApplicationTests;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author : PT
 * @date : create in 2022/09/10 22:02
 * <p></p>
 **/
public class JVMTest extends JavalibApplicationTests {

    static class OMMObj{

    }

    @Test
    public void OOMTest(){

        ArrayList<OMMObj> ommObjs = new ArrayList<>();
        while (true){
            ommObjs.add(new OMMObj());
        }

    }

    class Num{
        int value;
        public Num(int value){
            this.value = value;
        }
    }

    @Test
    public void test(){
        int[] nums = new int[]{-5769,-7887,-5709,4600,-7919,9807,1303,-2644,1144,-6410,-7159,-2041,9059,-663,4612,-257,2870,-6646,8161,3380,6823,1871,-4030,-1758,4834,-5317,6218,-4105,6869,8595,8718,-4141,-3893,-4259,-3440,-5426,9766,-5396,-7824,-3941,4600,-1485,-1486,-4530,-1636,-2088,-5295,-5383,5786,-9489,3180,-4575,-7043,-2153,1123,1750,-1347,-4299,-4401,-7772,5872,6144,-4953,-9934,8507,951,-8828,-5942,-3499,-174,7629,5877,3338,8899,4223,-8068,3775,7954,8740,4567,6280,-7687,-4811,-8094,2209,-4476,-8328,2385,-2156,7028,-3864,7272,-1199,-1397,1581,-9635,9087,-6262,-3061,-6083,-2825,-8574,5534,4006,-2691,6699,7558,-453,3492,3416,2218,7537,8854,-3321,-5489,-945,1302,-7176,-9201,-9588,-140,1369,3322,-7320,-8426,-8446,-2475,8243,-3324,8993,8315,2863,-7580,-7949,4400};
        Solution solution = new Solution();
        int[] ints = solution.maxSlidingWindow(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(k == 1) return nums;
            int[] result = new int[nums.length - k + 1];
            int left = 0, right = k - 1;
            List<Num> numList = Arrays.stream(nums).boxed().map(item -> new Num(item)).collect(Collectors.toList());

            MaxHeap<Num> queue = new MaxHeap<>(new NumComparator());
            for(int i = 0; i < right; i++){
                queue.offer(numList.get(i));
            }
            while(right < nums.length){
                queue.offer(numList.get(right));
                result[left] = queue.peek().value;
                queue.remove(numList.get(left));
                left++;
                right++;

            }
            return result;
        }

        class Num{
            int value;
            Num(int value){
                this.value = value;
            }
        }

        class NumComparator implements Comparator<Num> {
            public int compare(Num o1 , Num o2){
                return o2.value - o1.value;
            }
        }


        class MaxHeap<T>{
            private ArrayList<T> heap;
            private HashMap<T, Integer> indexMap;
            private Comparator<? super T> comparator;
            private int heapSize;

            public MaxHeap(Comparator com){
                this.comparator = com;
                heapSize = 0;
                heap = new ArrayList<>();
                indexMap = new HashMap<>();
            }

            public void offer(T element){
                heap.add(element);
                indexMap.put(element, heapSize);
                heapInsert(heapSize++);
            }

            public boolean remove(T element){
                Integer index = indexMap.get(element);
                if(index == null)return false;
                int end = heapSize - 1;
                swap(index, end);
                heap.remove(end);
                indexMap.remove(element);
                heapSize--;
                heapify(index);
                return true;
            }

            public T peek(){
                return heap.get(0);
            }

            private void heapify(int index){
                int left = index * 2 + 1;
                while(left < heapSize){
                    int largest = (left + 1 < heapSize) && (comparator.compare(heap.get(left + 1), heap.get(left)) < 0) ?
                            left + 1 : left;
                    largest = comparator.compare(heap.get(index), heap.get(largest)) < 0 ? index : largest;
                    if(index == largest)return ;
                    swap(index, largest);
                    index = largest;
                    left = index * 2 + 1;
                }
            }

            private void heapInsert(int index){
                while(comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0){
                    swap(index, (index - 1) / 2);
                    index = (index - 1) / 2;
                }
            }

            private void swap(int index1, int index2){
                T o1 = heap.get(index1);
                T o2 = heap.get(index2);
                heap.set(index1, o2);
                heap.set(index2, o1);
                indexMap.put(o1, index2);
                indexMap.put(o2, index1);
            }


        }


    }
}
