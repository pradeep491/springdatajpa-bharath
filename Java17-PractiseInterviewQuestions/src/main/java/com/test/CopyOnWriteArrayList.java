package com.test;

import java.util.ArrayList;
import java.util.List;


public class CopyOnWriteArrayList {
    public static void main(String[] args) {
        //List<Integer> list = new java.util.concurrent.CopyOnWriteArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        for(Integer i : list){
            list.add(30);
            System.out.println(i);
        }
    }
}
