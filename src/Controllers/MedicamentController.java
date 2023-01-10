package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.DataBaseConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import models.medicament;

public class MedicamentController implements Initializable{

	Connection cnx;
	public PreparedStatement st;
	public ResultSet resultat;
    @FXML
    private TextField Code_Med;

    @FXML
    private TextField Date_EXP;

    @FXML
    private TextField Désignation;

    @FXML
    private TextField Prix;

    @FXML
    private TextField Quantité;

    @FXML
    private TextField Remarque;

    @FXML
    private TableColumn<medicament, String> col_code;

    @FXML
    private TableColumn<medicament, Date> col_date;

    @FXML
    private TableColumn<medicament, String> col_désignation;

    @FXML
    private TableColumn<medicament, Integer> col_prix;

    @FXML
    private TableColumn<medicament, Integer> col_quantité;
    @FXML
    private TableColumn<medicament, String> col_remarque;

    @FXML
    private Button enregistrer_med;

    @FXML
    private Button modifier_med;

    @FXML
    private Button supprimer_med;

    @FXML
    private TableView<medicament> tab_medicament;

    public ObservableList <medicament> data = FXCollections.observableArrayList() ;
    @FXML
    void add_med(MouseEvent event) {

    }


    @FXML
    void delete_med(MouseEvent event) {

    }

    @FXML
    void edit_med(MouseEvent event) {

    }

    @FXML
    void tableMedicamentEvent(MouseEvent event) {

    }

    public void showMedicament () {
    	
    	String sql= "select * from medicament";
    	try {
    		st=cnx.prepareStatement(sql);
    		resultat=st.executeQuery(sql);
    		while(resultat.next()) {
    			data.add(new medicament(
    					resultat.getString("Code_Med"),
    					resultat.getString("Désignation"),
    					resultat.getInt("Prix"),
    					resultat.getString("Remarque"),
    					resultat.getDate("Date_EXP"),
    					resultat.getInt("Quantité")
    					));
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	col_code.setCellValueFactory(new PropertyValueFactory<medicament,String>("Code_Med"));
    	col_désignation.setCellValueFactory(new PropertyValueFactory<medicament,String>("Désignation"));
    	col_prix.setCellValueFactory(new PropertyValueFactory<medicament,Integer>("Prix"));
    	col_remarque.setCellValueFactory(new PropertyValueFactory<medicament,String>("Remarque"));
    	col_date.setCellValueFactory(new PropertyValueFactory<medicament,Date>("Date_EXP"));
    	col_quantité.setCellValueFactory(new PropertyValueFactory<medicament,Integer>("quantité"));
    	tab_medicament.setItems(data);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx=DataBaseConnexion.connexionDB();
    	showMedicament();
		
	}

}
