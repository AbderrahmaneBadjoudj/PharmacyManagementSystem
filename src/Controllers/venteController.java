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
    private TextField Code_Med;

    @FXML
    private TextField Date;

    @FXML
    private TextField Dosage;

    @FXML
    private TextField Nom_Cli;

    @FXML
    private TextField Prenom_Cli;

    @FXML
    private TextField Prix;

    @FXML
    private TextField Quantite;

    @FXML
    private TableView<?> TableauxVente;

    @FXML
    private Button btn_enregistrer;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_supprimer;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}

	

	