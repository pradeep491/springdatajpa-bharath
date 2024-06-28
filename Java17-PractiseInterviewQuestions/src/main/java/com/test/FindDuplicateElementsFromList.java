package com.test;

import java.util.Arrays;
import java.util.List;

public class FindDuplicateElementsFromList {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(5,6,7,8,9);
        List<Integer> list3 = list1.stream().filter(list2::contains).toList();
        list3.forEach(System.out::println);
    }
}
