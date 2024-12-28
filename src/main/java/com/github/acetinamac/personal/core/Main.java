package com.github.acetinamac.personal.core;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String mensaje1 = "Feliz Navidad";
        String mensaje2 = "Les desea la familia:";
        String mensaje3 = "Cetina Aldana";

        while (true) {
            printChristmasTree(12, mensaje1, mensaje2, mensaje3);
            Thread.sleep(500);
        }
    }

    public static void printChristmasTree(int altura, String mensaje1, String mensaje2, String mensaje3) {
        clearScreen();
        Random random = new Random();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < altura - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (2 * i) + 1; j++) {
                System.out.print(getRandomColor() + "*" + resetColor());
            }
            System.out.println();
        }

        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < altura -1; j++) {
                System.out.print(" ");
            }
            System.out.println("|||");
        }

        printCenteredMessage(mensaje1, altura);
        printCenteredMessage(mensaje2, altura);
        printCenteredMessage(mensaje3, altura);
    }

    public static String resetColor() {
        return "\u001B[0m";
    }

    public static void printCenteredMessage(String messaje, int ancho) {
        int padding = ancho - (messaje.length() / 2);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.println(messaje);
    }

    public static String getRandomColor() {
        Random random = new Random();
        int colorCode = random.nextInt(6) + 31;
        return "\u001B[" + colorCode + "m";
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
