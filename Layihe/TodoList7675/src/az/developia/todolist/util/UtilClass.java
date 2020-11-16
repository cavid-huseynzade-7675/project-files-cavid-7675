/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.developia.todolist.util;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Cavid
 */
public class UtilClass {
     public static boolean confirmDialog(String message) {
        boolean result = false;
         JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, message, "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            result = false;

        } else if (response == JOptionPane.YES_OPTION) {
            result = true;

        } else if (response == JOptionPane.CLOSED_OPTION) {

            result = false;
        }
        return result;
    } 
}
