package com.main;

import java.util.Scanner;

public class DaireninSahesi {

    public static void main(String[] args) {
        double pi = 3.14;
        Scanner s = new Scanner(System.in);
        System.out.println("Dairenin radiusunu de");
        int radius = s.nextInt();
        int radiusunkvadrati = radius * radius;
        double daireninsahesi = pi * radiusunkvadrati;
        System.out.println("dairenin sahesi " + daireninsahesi + " dir");
    }

}
