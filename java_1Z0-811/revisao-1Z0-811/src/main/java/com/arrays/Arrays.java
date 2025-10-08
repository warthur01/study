package com.arrays;

public class Arrays {
    public static void main(String[] args) {
        int[] notas = {7, 8, 5, 10, 6};
        int soma = 0;

        for (int nota : notas) {
            soma += nota;
        }

        double media = (double) soma / notas.length;

        System.out.println("Média das notas: " + media);

    }
}
