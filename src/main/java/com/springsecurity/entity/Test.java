package com.springsecurity.entity;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 5, 3, 2, 3);

        Set<Integer> duplicate = new HashSet<>();

        List<Integer> collect = numbers.stream().filter(f -> !duplicate.add(f)).collect(Collectors.toList());
//        collect.forEach(f -> System.out.println(f));

        String str = "PrimeMinister";
        Map<String, Integer> values = new HashMap<>();


        Map<Character, Long> collect1 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect1.forEach((key, value) -> System.out.println(key + ": " + value));
//        select salary from employee desc limit 1 offset 1;



    }
}
