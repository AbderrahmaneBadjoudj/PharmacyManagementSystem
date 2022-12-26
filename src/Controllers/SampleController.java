package Controllers;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SampleController implements Initializable{
	@FXML
    private Button login;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;
    
    @FXML
     void onLogin(ActionEvent event) {

    }

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
}
