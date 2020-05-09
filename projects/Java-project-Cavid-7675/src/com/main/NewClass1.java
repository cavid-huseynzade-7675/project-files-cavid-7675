/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import javax.swing.JOptionPane;

/**
 *
 * @author Cavid
 */
public class NewClass1 {
    public static void main(String[] args) {
        int number1=Integer.parseInt(JOptionPane.showInputDialog(" 1 ci ededi yaz"));
         int number2=Integer.parseInt(JOptionPane.showInputDialog(" 2 ci ededi yaz"));
         int sum=number1*number2;
         JOptionPane.showMessageDialog(null, "hasil =" + sum);
    }
   
}
