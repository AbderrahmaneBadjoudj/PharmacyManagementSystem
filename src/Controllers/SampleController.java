package Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SampleController implements Initializable{
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
    	if (nom.equals("badjoudj")&&pass.equals("abderrahmane")) {
    		System.out.println("bien!");
    		Stage home=new Stage();
    		try {
				fxml=FXMLLoader.load(getClass().getResource("/Interfaces/Home.fxml"));
				Scene scene=new Scene(fxml);
				home.setScene(scene);
				home.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	} else {
    		System.out.println("error");
    	}
    }

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
}
