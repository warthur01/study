package com.condicionaloperators;

public class CondicionalOperators {
    public static void main(String[] args) {
        int numero = 10;

        // if simples
        if (numero > 0) {
            System.out.println("O número é positivo.");
        }

        // if-else
        if (numero % 2 == 0) {
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar.");
        }

        // if-else if-else
        if (numero < 0) {
            System.out.println("Negativo");
        } else if (numero == 0) {
            System.out.println("Zero");
        } else {
            System.out.println("Positivo");
        }

        // operador ternário (forma resumida de if-else)
        String resultado = (numero >= 18) ? "Maior de idade" : "Menor de idade";
        System.out.println(resultado);

        // switch (útil para múltiplos casos)
        int dia = 3;
        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda-feira");
                break;
            case 3:
                System.out.println("Terça-feira");
                break;
            default:
                System.out.println("Outro dia");
        }
    }
}
