package com.pt.javalib.algorithm.cache;

import java.util.*;

/**
 * @author : PT
 * @date : create in 2022/09/22 22:00
 * <p></p>
 **/
public class LRUCache {

    private Map<Integer, CacheNode<Integer>> cacheMap;
    private Integer cacheMapSize;
    private Deque<CacheNode<Integer>> deque;
    private CacheNode<Integer> tail, head;

    private class CacheNode<T> {

        private CacheNode next;
        private CacheNode pre;
        private T value;

        CacheNode(T value){
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public CacheNode getNext() {
            return next;
        }

        public void setNext(CacheNode next) {
            this.next = next;
        }

        public CacheNode getPre() {
            return pre;
        }

        public void setPre(CacheNode pre) {
            this.pre = pre;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.cacheMapSize = capacity;
        this.cacheMap = new HashMap(this.cacheMapSize);
        this.deque = new LinkedList<>();
    }

    public int get(int key) {
        if (this.cacheMap.get(key) == null) {
            return -1;
        } else {
            return this.cacheMap.get(key).getValue();
            // refresh
        }
    }

    public void put(int key, int value) {
        if (this.cacheMap.containsKey(key)){

        }else{
            if (this.cacheMap.size() >= this.cacheMapSize) {

            } else {
                CacheNode<Integer> node = new CacheNode<>(value);
            }
        }
    }
}
