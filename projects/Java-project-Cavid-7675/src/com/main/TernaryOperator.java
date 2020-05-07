/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import java.util.Random;

/**
 *
 * @author Cavid
 */
public class TernaryOperator {
    public static void main(String[] args) {
       
        Random zer=new Random();
        Random dice=new Random();
          int c=dice.nextInt(1000);    
        System.out.println("c="+c);
       for(int counter = 0;counter<1000; counter++){
          int a = zer.nextInt(1000);  
         boolean z = (a == c) ? true : false;
         if(z==true){
             System.out.println(counter+"ci defe de beraber oldular");   
         }
       }
    }
   
}
