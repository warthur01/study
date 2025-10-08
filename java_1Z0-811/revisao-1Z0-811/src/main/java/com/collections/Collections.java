package com.collections;

import java.util.*;

public class Collections {
    public static void main(String[] args) {

        // LIST - Mantém ordem, permite duplicatas
        List<String> listaNomes = new ArrayList<>();
        listaNomes.add("Ana");
        listaNomes.add("Bruno");
        listaNomes.add("Ana");

        System.out.println("List (ArrayList):");
        for (String nome : listaNomes) {
            System.out.println("- " + nome);
        }

        // SET - Não permite duplicatas, ordem não garantida (HashSet)
        Set<String> conjuntoNomes = new HashSet<>();
        conjuntoNomes.add("Ana");
        conjuntoNomes.add("Bruno");
        conjuntoNomes.add("Ana");

        System.out.println("\nSet (HashSet):");
        for (String nome : conjuntoNomes) {
            System.out.println("- " + nome);
        }

        // MAP - Chave -> Valor (não permite chaves duplicadas)
        Map<Integer, String> mapaUsuarios = new HashMap<>();
        mapaUsuarios.put(1, "Ana");
        mapaUsuarios.put(2, "Bruno");
        mapaUsuarios.put(1, "Carlos");

        System.out.println("\nMap (HashMap):");
        for (Map.Entry<Integer, String> entrada : mapaUsuarios.entrySet()) {
            System.out.println("- ID " + entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
