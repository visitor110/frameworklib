package com.pt.javalib.algorithm.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : PT
 * @date : create in 2022/12/25 10:59
 * <p></p>
 **/
public class UnionSet<V> {

    private class Element<V> {
        private V value;

        Element(V value) {
            this.value = value;
        }
    }

    private Map<V, Element<V>> eMap = new HashMap<>();
    private Map<Element<V>, Element<V>> fMap = new HashMap<>();
    private Map<Element<V>, Integer> sizeMap = new HashMap<>();

    public UnionSet() {
    }

    public UnionSet(List<V> list) {
        for (V v : list) {
            Element<V> e = new Element<>(v);
            eMap.put(v, e);
            fMap.put(e, e);
            sizeMap.put(e, 1);
        }
    }

    public boolean isSameSet(V v1, V v2) {
        if (eMap.containsKey(v1) && eMap.containsKey(v2)) {
            return getFather(eMap.get(v1)) == getFather(eMap.get(v2));
        }
        return false;
    }

    private Element getFather(Element e) {
        Stack<Element> stack = new Stack<>();
        while (e != fMap.get(e)) {
            e = fMap.get(e);
            stack.add(e);
        }
        while (!stack.isEmpty()) {
            Element pop = stack.pop();
            fMap.put(pop, e);
        }
        return e;
    }
    public void union(V v1, V v2){
        ReentrantLock reentrantLock = new ReentrantLock();
        if(eMap.containsKey(v1) && eMap.containsKey(v2)){
            Element<V> f1 = fMap.get(eMap.get(v1));
            Element<V> f2 = fMap.get(eMap.get(v2));
            if(f1 != f2){
                Element<V> big = sizeMap.get(f1) > sizeMap.get(f2) ? f1 : f2;
                Element<V> small = f1 == big ? f2 : f1;
                fMap.put(small, big);
                sizeMap.put(big, sizeMap.get(f1) + sizeMap.get(f2));
                sizeMap.remove(small);
            }
        }
    }
}
