package Controllers;

import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.cell.PropertyValueFactory;
import models.Vente;

public class venteController implements Initializable{
	Connection cnx;
	public PreparedStatement st;
	public ResultSet resultat;
	@FXML
    private TextField Code_Med;

    @FXML
    private TableColumn<Vente, String> Code_Med_Cell;

    @FXML
    private TextField Date;

    @FXML
    private TableColumn<Vente, java.sql.Date> Date_Cell;

    @FXML
    private TextField Dosage;

    @FXML
    private TableColumn<Vente, Integer> Dosage_Cell;

    @FXML
    private TextField Nom_Cli;

    @FXML
    private TableColumn<Vente, String> Nom_Cli_Cell;

    @FXML
    private TextField Prenom_Cli;

    @FXML
    private TableColumn<Vente, String> Prenom_Cli_Cell;

    @FXML
    private TextField Prix;

    @FXML
    private TableColumn<Vente, Integer> Prix_Cell;

    @FXML
    private TextField Quantite;

    @FXML
    private TableColumn<Vente, Integer> Quantite_Cell;

    @FXML
    private TableView<Vente> TableauxVente;

    @FXML
    private Button btn_enregistrer_vente;

    @FXML
    private Button btn_modifier_vente;

    @FXML
    private Button btn_supprimer_vente;
    
    public ObservableList<Vente> data = FXCollections.observableArrayList();

    @FXML
    void Add_Vente() {

    }

    @FXML
    void Modifier_Vente() {

    }

    @FXML
    void Supprimer_Vente() {

    }
    
    public void showVente(){
    	String sql="select * from Vente";
    	try {
			st=cnx.prepareStatement(sql);
			resultat=st.executeQuery();
			while(resultat.next()) {
				data.add(new Vente(
				     resultat.getString("Code_Med"),
				     resultat.getDate("date"),
				     resultat.getInt("Dosage"),
				     resultat.getString("Nom_Cli"),
                     resultat.getString("Prenom_Cli"),
                     resultat.getInt("Prix"),
                     resultat.getInt("Quantité")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	Code_Med_Cell.setCellValueFactory(new PropertyValueFactory<Vente,String>("CodeMedicamentVente"));
    	Date_Cell.setCellValueFactory(new PropertyValueFactory<Vente,java.sql.Date>("DateVente"));
    	Dosage_Cell.setCellValueFactory(new PropertyValueFactory<Vente,Integer>("DosageVente"));
    	Nom_Cli_Cell.setCellValueFactory(new PropertyValueFactory<Vente,String>("NomVente"));
    	Prenom_Cli_Cell.setCellValueFactory(new PropertyValueFactory<Vente,String>("PrenomVente"));
    	Prix_Cell.setCellValueFactory(new PropertyValueFactory<Vente,Integer>("PrixVente"));
    	Quantite_Cell.setCellValueFactory(new PropertyValueFactory<Vente,Integer>("QuantiteVente"));
    	TableauxVente.setItems(data);
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx=DataBaseConnexion.connexionDB();
    	showVente();
		
	}

}

	

	