package Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HomeController {
	private Parent fxml;

    @FXML
    private Button btn_AjouterUtilisateur;

    @FXML
    private Button btn_Client;

    @FXML
    private Button btn_Decconexion;

    @FXML
    private Button btn_Home;

    @FXML
    private Button btn_Medicament;

    @FXML
    private Button btn_Statistique;

    @FXML
    private Button btn_Vente;

    @FXML
    private AnchorPane root;

    @FXML
    void ClickOnButtonAjouterUtilisateur(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Controllers/utilisateur.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void ClickOnButtonClient(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Controllers/Client.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void ClickOnButtonDeconnexion(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Controllers/Sample.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void ClickOnButtonHome(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Controllers/Home.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void ClickOnButtonMedicament(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Controllers/Medicament.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void ClickOnButtonStatistique(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Controllers/statistic.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void ClickOnButtonVente(MouseEvent event) {
    	try {
			fxml=FXMLLoader.load(getClass().getResource("/Controllers/Ventepage.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
