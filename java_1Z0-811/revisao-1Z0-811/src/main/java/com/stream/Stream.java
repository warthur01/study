package com.stream;

import java.util.*;
import java.util.stream.*;

public class Stream {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> dobrados = numeros.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        int soma = numeros.stream()
                .reduce(0, Integer::sum);

        Optional<Integer> maximo = numeros.stream()
                .max(Comparator.naturalOrder());

        Optional<Integer> minimo = numeros.stream()
                .min(Comparator.naturalOrder());

        long quantidade = numeros.stream()
                .count();

        boolean todosPositivos = numeros.stream()
                .allMatch(n -> n > 0);

        boolean algumPar = numeros.stream()
                .anyMatch(n -> n % 2 == 0);

        boolean nenhumNegativo = numeros.stream()
                .noneMatch(n -> n < 0);

        numeros.stream()
                .forEach(System.out::println);

        List<String> palavras = Arrays.asList("java", "stream", "api");

        String concatenado = palavras.stream()
                .reduce("", (a, b) -> a + b);

        List<String> filtradas = palavras.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());

        Set<Integer> conjunto = numeros.stream()
                .collect(Collectors.toSet());

        Map<Boolean, List<Integer>> agrupado = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        Map<Integer, List<Integer>> agrupamento = numeros.stream()
                .collect(Collectors.groupingBy(n -> n % 3));

        IntSummaryStatistics estatisticas = numeros.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        
    }
}