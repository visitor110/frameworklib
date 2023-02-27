package com.pt.javalib.algorithm.cache;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author : PT
 * @date : create in 2022/10/24 14:41
 * <p></p>
 **/
public class MyHeapDemo<T> {

    private ArrayList<T> heap;
    private int heapSize;
    private HashMap<T, Integer> indexMap;
    private Comparator<? super T> comparator;

    public MyHeapDemo(Comparator<? super T> comparator){
        this.comparator = comparator;
        heapSize = 0;
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    public boolean contains(T element){
        return indexMap.containsKey(element);
    }

    public T pop(){
        T result = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(result);
        heap.remove(heapSize - 1);
        heapSize--;
        heapify(0);
        return result;
    }

    public boolean push(T element){
        heap.add(element);
        indexMap.put(element, heapSize);
        heapInsert(heapSize++);
        return true;
    }

    private void heapInsert(int index){
        while(comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0){
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    private void heapify(int index){
        int left = index << 1 + 1;
        while(left < heapSize){
            int largest = left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0 ?
                    left + 1 : left;
            largest = comparator.compare(heap.get(index), heap.get(largest)) < 0 ? index : largest;
            if(index == largest)break;
            swap(largest, index);
            index = largest;
            left = index << 1 + 1;
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
