package Controllers;


import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SampleController implements Initializable{
	@FXML
	private PasswordField Password;


    @FXML
    private TextField UserNameField;

    @FXML
    private Button btn_login;

    @FXML
    void onLogin() {

    }

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
}
