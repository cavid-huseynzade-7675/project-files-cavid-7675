
package az.developia.student.util;

import javafx.geometry.Pos;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;


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
     public static void showNotification(String title,String message,Pos position){
         Notifications.create().position(position).title(title).text(message).showInformation();
        
    }
}
