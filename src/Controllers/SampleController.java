package Controllers;

import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController extends Application{
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
	public void start(Stage primaryStage) throws Exception {
		
		
	}
	
}
