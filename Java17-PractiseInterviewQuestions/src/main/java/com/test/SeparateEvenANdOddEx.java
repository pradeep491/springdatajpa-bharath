package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.Map.*;
import java.util.Set;
import java.util.stream.Collectors;

public class SeparateEvenANdOddEx {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 97);

        Map<Boolean, List<Integer>> oddEvenMap = list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        Set<Entry<Boolean, List<Integer>>> entrySet = oddEvenMap.entrySet();
        System.out.println(oddEvenMap);
        for (Entry<Boolean, List<Integer>> entry : entrySet) {
            System.out.println("--------------------------");
            if (entry.getKey()) {
                System.out.println("Even Numbers");
            } else {
                System.out.println("Odd Numbers");
            }
            System.out.println("---------------------------");
            List<Integer> list1 = entry.getValue();
            list1.forEach(System.out::println);
        }
    }
}
