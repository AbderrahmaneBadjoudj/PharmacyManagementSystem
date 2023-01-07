package Controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.DataBaseConnexion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SampleController implements Initializable{
	Connection cnx;
	public PreparedStatement st;
	public ResultSet resultat;
	@FXML
	private PasswordField Password;


    @FXML
    private TextField UserNameField;

    @FXML
    private Button btn_login;
    private Parent fxml;
    @FXML
    void onLogin() {
    	String nom=UserNameField.getText();
    	String pass=Password.getText();
    	String sql="select username , password from users";
    	try {
			st= cnx.prepareStatement(sql);
			resultat=st.executeQuery();
			if(resultat.next()) {
				if (nom.equals(resultat.getString("username"))&&pass.equals(resultat.getString("password"))) {
		    		System.out.println("bien!");
		    		Stage home=new Stage();
		    		try {
						fxml=FXMLLoader.load(getClass().getResource("/Controllers/Home.fxml"));
						Scene scene=new Scene(fxml);
						home.setScene(scene);
						home.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
		    	} else {
		    		Alert alert= new Alert (AlertType.ERROR,"UserName Or Password incorrecte",javafx.scene.control.ButtonType.OK);
		    		alert.showAndWait();
		    	}
		    }

			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	
    }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx=DataBaseConnexion.connexionDB();
		
	}
	
}
