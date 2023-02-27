package com.pt.javalib.algorithm.cache;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author : PT
 * @date : create in 2022/10/24 13:14
 * <p>自定义大根堆</p>
 * 1. heapInsert 从当前节点开始与父节点比较，大的交换  logN
 **/
public class MyHeap<T> {
    private int size;
    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;
    private Comparator<? super T> comparator;

    public MyHeap(Comparator com) {
        this.comparator = com;
        this.size = 0;
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 1. 堆顶与最后位置交换，删除最后一个
     * 2. 从0位置heapify
     */
    public T pop() {
        T result = heap.get(0);
        int end = size - 1;
        swap(0, end);
        indexMap.remove(result);
        heap.remove(end);
        size--;
        heapify(0);
        return result;
    }

    public void push(T element) {
        heap.add(element);
        indexMap.put(element, this.size);
        heapInsert(this.size++);
    }

    public void resign(T element){
        Integer index = indexMap.get(element);
        heapInsert(index);
        heapify(index);
    }

    private void heapInsert(int index) {
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && (comparator.compare(heap.get(left + 1), heap.get(left)) < 0 ) ?
                    left + 1 : left;
            largest = comparator.compare(heap.get(largest), heap.get(index)) < 0 ? largest : index;
            if (largest == index) break;
            swap(index, largest);
            index = largest;
            left = index * 2 + 1;
        }

    }

    private void swap(int index1, int index2) {
        T t1 = heap.get(index1);
        T t2 = heap.get(index2);
        heap.set(index1, t2);
        heap.set(index2, t1);
        indexMap.put(t1, index2);
        indexMap.put(t2, index1);
    }
}
