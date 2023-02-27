package com.pt.javalib.algorithm;

import com.pt.javalib.JavalibApplicationTests;
import com.pt.javalib.algorithm.cache.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : PT
 * @date : create in 2022/10/24 13:49
 * <p></p>
 **/
public class AlgorithmTest extends JavalibApplicationTests {

    public class Student {
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public class StudentCom implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    @Test
    public void heapTest() {

        Student li = new Student(20, "li");
        Student wang = new Student(29, "wang");
        Student zhang = new Student(10, "zhang");
        Student lv = new Student(19, "lv");

        MyHeap<Student> studentMyHeap = new MyHeap<Student>(new StudentCom());
        studentMyHeap.push(li);
        studentMyHeap.push(wang);
        studentMyHeap.push(zhang);
        studentMyHeap.push(lv);
        while (!studentMyHeap.isEmpty()) {
            System.out.println(studentMyHeap.pop());
        }
        System.out.println("===============");
        studentMyHeap.push(li);
        studentMyHeap.push(wang);
        studentMyHeap.push(zhang);
        studentMyHeap.push(lv);
        lv.age = 100;
        studentMyHeap.resign(lv);
        while (!studentMyHeap.isEmpty()) {
            System.out.println(studentMyHeap.pop());
        }
    }

    @Test
    public void stackTest() {
        IncDecStack incDecStack = new IncDecStack();
        int[] arr = new int[]{1, 3, 4, 5, 6};
        int[][] generate = incDecStack.generate(arr);
        showArr(generate);

        int[] arr1 = new int[]{4, 3, 4, 5, 6};
        int[][] generate1 = incDecStack.generate(arr1);
        showArr(generate1);

        int[] arr2 = new int[]{1, 3, 4, 8, 6};
        int[][] generate2 = incDecStack.generate(arr2);
        showArr(generate2);

        int[] arr3 = new int[]{1, 3, 2, 2, 6, 2, 3, 4};
        int[][] generate3 = incDecStack.generate(arr3);
        showArr(generate3);
    }

    private void showArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "     ");
            }
            System.out.println();
        }
        System.out.println("==============");
    }

    @Test
    public void QueenTest() {
        NQueen nQueen = new NQueen();
        int result = nQueen.culNQueen(5);
        System.out.println(result);
    }

    @Test
    public void dpTest() {
        DP dp = new DP();
        List<String> list = dp.strAllExplian("abc");
        list.stream().forEach(System.out::println);
    }

    @Test
    public void demo() {
        UnionSet<Integer> unionSet = new UnionSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(unionSet.isSameSet(2, 3));

        unionSet.union(1,2);
        unionSet.union(3,2);

        System.out.println(unionSet.isSameSet(1, 3));

    }

    @Test
    public void manacherDemo(){
        Manacher manacher = new Manacher();
        String babad = manacher.longestPalindrome("bfewafewafagregsrbad");
        System.out.println(babad);
    }

    @Test
    public void demo11(){
        int[][] roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        minimumFuelCost(roads,2);
    }




    class Node{
        List<Node> nodes;
        int index;
        boolean pass;
        public Node(int index){
            this.index = index;
            this.pass = false;
            nodes = new ArrayList<Node>();
        }
    }

    private Map<Integer, Node> map = new HashMap<>();

    public long minimumFuelCost(int[][] roads, int seats) {

        for(int i = 0; i < roads.length; i++){
            Node node1 = map.getOrDefault(roads[i][0], new Node(roads[i][0]));
            map.put(roads[i][0], node1);
            Node node2 = map.getOrDefault(roads[i][1], new Node(roads[i][1]));
            map.put(roads[i][1], node2);

            node1.nodes.add(node2);
            node2.nodes.add(node1);
        }
        long res = 0;
        map.get(0).pass = true;
        for(Node node : map.get(0).nodes){
            res += calculate(node, seats).oil;
        }

        return res;
    }
    class Info{
        long oil;
        int num;
        public Info( long oil, int num){
            this.oil = oil;
            this.num = num;
        }
    }

    private Info calculate(Node node, int seats) {
        List<Node> nodes = node.nodes;
        if (nodes.size() == 0) {
            return new Info(1, 1);
        }
        long oil = 0;
        int num = 1;
        for (Node temp : nodes) {
            if (temp.pass) {
                continue;
            }
            temp.pass = true;
            Info info = calculate(temp, seats);
            oil += info.oil;
            num += info.num;
        }
        return new Info(
                (num % seats == 0 ? num / seats : num / seats + 1) + oil, num);
    }


    }
