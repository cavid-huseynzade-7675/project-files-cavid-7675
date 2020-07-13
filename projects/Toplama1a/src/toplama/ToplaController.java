/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toplama;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ToplaController implements Initializable {
@FXML
private  TextField FirstNumber;
@FXML
private  TextField SecondNumber;
@FXML
private Label Answer;
@FXML
private  TextField emel;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    
    
}
         @FXML
    private void Equal(ActionEvent event) {
        String Emel=emel.getText();
       String firstnumber= FirstNumber.getText();
       int firstNumber=Integer.parseInt(firstnumber);
         String secondnumber =SecondNumber.getText();
       int secondNumber=Integer.parseInt(secondnumber); 
       if("+".equals(Emel)){
       int total=firstNumber+secondNumber;
        String Total=String.valueOf(total);
           Answer.setText(Total);
       }
    if( "-".equals(Emel)){
       int total=firstNumber-secondNumber;
        String Total=String.valueOf(total);
           Answer.setText(Total);
       }
   
     if("*".equals(Emel)){
       int total=firstNumber*secondNumber;
        String Total=String.valueOf(total);
           Answer.setText(Total);
       }
        if("/".equals(Emel)){
       int total=firstNumber/secondNumber;
        String Total=String.valueOf(total);
           Answer.setText(Total);
       }
       
       
    }
}
