package com.main;

public class NewClass {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            int a = i % 7;
            if (a == 0) {
                System.out.println(i + "  7 e qaliqsiz bolunur");
            }
        }
    }
}
