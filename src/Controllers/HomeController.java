package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {
	private Parent fxml;
	@FXML
    private AnchorPane root;

    @FXML
    void btn_AjouterUtilisateur(MouseEvent event) {
		try {
			fxml=FXMLLoader.load(getClass().getResource("/Interfaces/utilisateur.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void btn_Client(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Interfaces/client.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btn_Home(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Interfaces/Home.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btn_Medicament(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Interfaces/Medicament.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btn_Statistique(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Interfaces/statistic.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void btn_Vente(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Interfaces/Ventepage.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			fxml=FXMLLoader.load(getClass().getResource("/Interfaces/Home.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
