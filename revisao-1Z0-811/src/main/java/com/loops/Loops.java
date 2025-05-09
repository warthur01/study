package com.loops;

public class Loops {
    public static void main(String[] args) {
        // for tradicional
        System.out.println("Loop for:");
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        // while
        System.out.println("\nLoop while:");
        int i = 0;
        while (i < 5) {
            System.out.println("i = " + i);
            i++;
        }

        // do-while
        System.out.println("\nLoop do-while:");
        int k = 0;
        do {
            System.out.println("k = " + i);
        } while (k < 5);

        // for-each (usado com arrays ou coleções)
        System.out.println("\nLoop for-each:");
        int[] numeros = {10, 20, 30, 40, 50};
        for (int num : numeros) {
            System.out.println("num = " + num);
        }
    }
}
