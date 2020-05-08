/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

/**
 *
 * @author Cavid
 */
public class MainClassToplama {
    public static void main(String[] args) {
        int sum=0;
        for (int i = 1; i <= 10; i++) {
            sum += i; // sum=sum+i
        }
        System.out.println("sum = "+sum);
    }
}
