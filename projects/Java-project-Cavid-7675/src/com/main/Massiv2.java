package com.main;

public class Massiv2 {

    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 73552;
        numbers[1] = 1234;
        numbers[2] = 79;
        numbers[3] = 59;
        numbers[4] = 78;
        for (int i = 0; i < 5; i++) {
            System.out.println("reqem "+numbers[i]);

        }
        int a=0;
   for(int b:numbers){
        System.out.println("reqem en"+numbers[a]);  
       a++;
    }

}
}