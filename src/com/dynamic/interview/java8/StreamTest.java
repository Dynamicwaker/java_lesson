package com.dynamic.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author xinghuajian
 * @description
 * @date 2019/4/29 20:36
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filteredArray = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filteredArray.forEach(string -> System.out.println(string));
        System.out.println("****************************");
        filteredArray.forEach(System.out::println);
        System.out.println("****************************");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}
