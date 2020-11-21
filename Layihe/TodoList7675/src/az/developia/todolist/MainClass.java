
package az.developia.todolist;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainClass extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage s) throws Exception {
          s.setTitle("Login");
          //FileInputStream input=new FileInputStream("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\Layihe\\TodoList7675\\image\\login.png");
          Image image=new Image("images/login.png");
         
        Image[] elements = new Image[1];
        elements[0]=image;
          s.getIcons().setAll(elements);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("view/login.fxml"));
        Parent root=loader.load();
        Scene scene= new Scene(root);
        s.setScene(scene);
        s.show();  
        }
    
    
}
