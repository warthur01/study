package com.collections;

import java.util.ArrayList;
import java.util.List;

public class RemoveList {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");
        nomes.add("Diana");
        nomes.add("Eduardo");
        nomes.remove(0);
        nomes.stream().forEach(System.out::println);
    }
}
