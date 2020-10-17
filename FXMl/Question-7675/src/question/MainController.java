package question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class MainController implements Initializable {

    @FXML
    private ListView<String> suallarlist;

    @FXML
    private ListView<String> telebelerlist;
    ArrayList<String> telebeler = new ArrayList<>();
ArrayList<String> suallar = new ArrayList<>();
Random r=new Random();
    @FXML
    void qarisdirButton(ActionEvent event) {
        telebelerlist.getItems().clear();
        suallarlist.getItems().clear();
telebelerlist.getItems().addAll(telebeler);
        for (int i = 0; i < telebeler.size(); i++) {
          suallarlist.getItems().add(suallar.get(r.nextInt(suallar.size())));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        telebeler.add("Adil");
        telebeler.add("Serxan");
        telebeler.add("Ayxan");
        telebeler.add("Cavid");
        telebeler.add("Mehemmed");
        telebeler.add("Nihad");
        // 

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Cavid\\Documents\\Github\\project-files-cavid-7675\\FXMl\\Question-7675\\textler\\sual.txt"));
            
            String line = br.readLine();

            while (line != null) {
                suallar.add(line);
                line = br.readLine();
            }
          
            br.close();
        } catch (Exception ex) {
ex.printStackTrace();
        }

    }
    
    
}
