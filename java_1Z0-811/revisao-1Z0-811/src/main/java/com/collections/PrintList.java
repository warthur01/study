package com.collections;

import java.util.ArrayList;
import java.util.List;

public class PrintList {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");
        nomes.add("Diana");
        nomes.add("Eduardo");
        nomes.stream().forEach(System.out::println);
    }
}
