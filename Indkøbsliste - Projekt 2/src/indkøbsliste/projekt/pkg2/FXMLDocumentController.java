/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package indkøbsliste.projekt.pkg2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author krist
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ListView<String> vareListe;
    @FXML
    private Button tilføjKnap;
    @FXML
    private Button sletKnap;
    @FXML
    private TextField tekstFelt;
    @FXML
    private Label advarsel;
    
    DatabaseKode db = new DatabaseKode();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.vareListe.setItems(this.db.VareInfo());
    }    

    @FXML
    private void indsæt(ActionEvent event) {
        String indkøbsvare = this.tekstFelt.getText();
        if (indkøbsvare.length()>0) {
            this.db.skrivString(indkøbsvare);
            
        }
        else {
            this.advarsel.setText("ingen vare indtastet");
        }
        
    }
//det der skal ske når vi trykker tilføj. der bliver her tilføjet det der står i indputfeltet. Dette vil med lægere arbejde kun være vare der kan købes og ikke bare alle strings//
    
    @FXML
    private void slet(ActionEvent event) {
        this.vareListe.getItems().remove(this.vareListe.getSelectionModel().getSelectedItem());
    }
//funktionen til at slette en vare der eventuelt er købt ind//
}
