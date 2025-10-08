package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(1);
        numbers.add(3);
        Collections.sort(numbers);
        numbers.stream().forEach(System.out::println);
    }
}
