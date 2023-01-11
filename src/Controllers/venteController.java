package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ResourceBundle;

import application.DataBaseConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    private DatePicker datePicker;


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
    @FXML
    private TextField Txt_chercher;

    @FXML
    private Button btn_chercher;
    
    @FXML
   /* void chercher_vente() {
    	String sql="select Code_Med,Dosage,Nom_Cli,Prenom_Cli,Quantité,Prix,date where Nom_Cli='"+Txt_chercher.getText()+"'";
        try {
			st=cnx.prepareStatement(resultat.getString(sql));
			resultat=st.executeQuery();
			if(resultat.next()){
				
				Code_Med.setText(resultat.getString("Code_Med"));
				Dosage.setText(resultat.getString("Dosage"));
				Nom_Cli.setText(resultat.getString("Nom_Cli"));
				Prenom_Cli.setText(resultat.getString("Prenom_Cli"));
				Quantite.setText(resultat.getString("Quantité"));
				Prix.setText(resultat.getString("Prix"));
				Date date=resultat.getDate(resultat.getString("Code_Med"));
                datePicker.setValue(date.toLocalDate());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }*/
    
    public ObservableList<Vente> data = FXCollections.observableArrayList();

    @FXML
    void Add_Vente() {
    	String codeC=Code_Med.getText();
    	String dosagemedicament=Dosage.getText();
    	String nom_client=Nom_Cli.getText();
    	String prenom_client=Prenom_Cli.getText();
    	String prix_medicament=Prix.getText();
    	String quantite_medicament=Quantite.getText();
    	
    	String sql="INSERT INTO vente(Code_Med,Dosage,Nom_Cli,Prenom_Cli,Quantité,Prix,date) VALUES(?,?,?,?,?,?,?)";
    	if(!codeC.equals("")&&!datePicker.getValue().equals(null)  &&!dosagemedicament.equals("")&&!nom_client.equals("")&&!prenom_client.equals("")&&!prix_medicament.equals("")&&!quantite_medicament.equals("")) {
    		
    		try {
	    		st=cnx.prepareStatement(sql);
	    		st.setString(1, codeC);
	    		
	    		st.setString(2, dosagemedicament);
	    		st.setString(3, nom_client);
	    		st.setString(4, prenom_client);
	    		st.setString(5, prix_medicament);
	    		st.setString(6, quantite_medicament);
	    		java.util.Date date =java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
	    		Date sqlDate=new Date(date.getTime());
	    		st.setDate(7, sqlDate);
	    		st.execute();
	    		Code_Med_Cell.setText("");
	    		Date_Cell.setText("");
	    		Dosage_Cell.setText("");
	    		Nom_Cli_Cell.setText("");
	    		Prenom_Cli_Cell.setText("");
	    		Prix_Cell.setText("");
	    		Quantite_Cell.setText("");
	    		Alert alert=new Alert(AlertType.CONFIRMATION,"Vendre Ajouter avec succes", javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
	    		showVente();
	    	}catch (SQLException e) {
	    		e.printStackTrace();
	    	}
    	} 
    else {
    		
    		Alert alert=new Alert(AlertType.WARNING,"Remplir tout les champs !", javafx.scene.control.ButtonType.OK);
    		alert.showAndWait();
    	}

    }

    

    @FXML
    void Modifier_Vente() {
    	String codeC=Code_Med.getText();
    	String dosagemedicament=Dosage.getText();
    	String nom_client=Nom_Cli.getText();
    	String prenom_client=Prenom_Cli.getText();
    	String prix_medicament=Prix.getText();
    	String quantite_medicament=Quantite.getText();
    	String sql="update vente set (Code_Med,Dosage,Nom_Cli,Prenom_Cli,Quantité,Prix,date) where Nom_Cli='"+ Nom_Cli.getText()+"'";
    	
    	if(!codeC.equals("")&&!datePicker.getValue().equals(null)  &&!dosagemedicament.equals("")&&!nom_client.equals("")&&!prenom_client.equals("")&&!prix_medicament.equals("")&&!quantite_medicament.equals("")) {
    		try {
            	st=cnx.prepareStatement(sql);
        		st.setString(1, codeC);
        		java.util.Date date =java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        		st.setString(2, dosagemedicament);
        		st.setString(3, nom_client);
        		st.setString(4, prenom_client);
        		st.setString(5, prix_medicament);
        		st.setString(6, quantite_medicament);
        		Date sqlDate=new Date(date.getTime());
        		st.setDate(7, sqlDate);
        		st.execute();
        		Code_Med_Cell.setText("");
        		Date_Cell.setText("");
        		Dosage_Cell.setText("");
        		Nom_Cli_Cell.setText("");
        		Prenom_Cli_Cell.setText("");
        		Prix_Cell.setText("");
        		Quantite_Cell.setText("");
        		Alert alert=new Alert(AlertType.CONFIRMATION,"Vendre modifier avec succes", javafx.scene.control.ButtonType.OK);
        		alert.showAndWait();
        		showVente();
    			
    	}
    	
		 catch (SQLException e) {
			e.printStackTrace();
		}
    	}
    		else {
		
		Alert alert=new Alert(AlertType.WARNING,"Remplir tout les champs !", javafx.scene.control.ButtonType.OK);
		alert.showAndWait();
	}

    }

    @FXML
    void Supprimer_Vente() {
    
    }
    
    public void showVente(){
    	TableauxVente.getItems().clear();
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

	

	