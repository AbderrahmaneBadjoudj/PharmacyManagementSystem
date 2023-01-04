package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class venteController implements Initializable{

    @FXML
    private Button btn_enregistrer;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_supprimer;

    @FXML
    private TextField code_cli;

    @FXML
    private TextField code_med;

    @FXML
    private TextField date;

    @FXML
    private TextField dosage;

    @FXML
    private TextField prix;

    @FXML
    private TextField quantite;

    @FXML
    private TableView<?> tableaux;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}

	

	