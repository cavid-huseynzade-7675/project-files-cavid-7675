package com.main;

public class Massiv {

    public static void main(String[] args) {

        String[] names = new String[4];
        names[0] = "nihad";
        names[1] = "adil";
        names[2] = "ayxan";
        names[3] = "celal";

        for (int i = 0; i < 4; i++) {
          System.out.println("telebe adi " + names[i]); 
         }
        int i = 0;
        for (String a : names) {
            System.out.println(names[i]);
            i++;

        }

    }
}
