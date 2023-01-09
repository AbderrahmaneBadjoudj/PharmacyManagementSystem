package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnexionMysql;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.client;
import models.utilisateur;

public class utilisateurController implements Initializable {
	

    Connection cnx;
    public PreparedStatement st;
    public ResultSet result;
	
	@FXML
    private TextField T_code;

    @FXML
    private TextField T_pass;

    @FXML
    private TextField T_nom;

    @FXML
    private TextField T_type;

    @FXML
    private TextField T_pre;

    @FXML
    private Button bttn_enr;

    @FXML
    private Button bttn_mod;

    @FXML
    private Button bttn_sup;

    @FXML
    private TableView<utilisateur> Tablee;

    @FXML
    private TableColumn<utilisateur, Integer> tablee_code;

    @FXML
    private TableColumn<utilisateur, String> tablee_nom;

    @FXML
    private TableColumn<utilisateur, String> tablee_pre;

    @FXML
    private TableColumn<utilisateur, String> tablee_pass;

    @FXML
    private TableColumn<utilisateur, String> tablee_type;
    
    public ObservableList<utilisateur> data = FXCollections.observableArrayList();

    @FXML
    private TextField T_cher;

    @FXML
    private Button bttn_cher;

    @FXML
    void Tablee_mod() {
    	

    	utilisateur utilisateur=Tablee.getSelectionModel().getSelectedItem();
    	String sql="select * from utilisateur where Code_Util = ?";
    	try {
			st=cnx.prepareStatement(sql);
			st.setInt(1, utilisateur.getCode_Util());
			result=st.executeQuery();
			if(result.next()) {
				T_code.setText(result.getString("Code_Util"));
    			T_nom.setText(result.getString("Nom_Util"));
    			T_pre.setText(result.getString("Prenom_Util"));
    		    T_pass.setText(result.getString("Password"));
    			T_type.setText(result.getString("Type"));
    			T_cher.setText(result.getString("Code_Util"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void add_util() {
    	
    	String Code_Util=T_code.getText();
    	String Nom_Util=T_nom.getText();
    	String Prenom_Util=T_pre.getText();
    	String Password=T_pass.getText();
    	String Type=T_type.getText();
    	
    	String sql="INSERT INTO utilisateur(Code_Util,Nom_Util,Prenom_Util,Password,Type) VALUES(?,?,?,?,?)";
    	if(!Code_Util.equals("")&&!Nom_Util.equals("")&&!Prenom_Util.equals("")&&!Password.equals("")&&!Type.equals("")) {
    		
    		try {
	    		st=cnx.prepareStatement(sql);
	    		st.setString(1, Code_Util);
	    		st.setString(2, Nom_Util);
	    		st.setString(3, Prenom_Util);
	    		st.setString(4, Password);
	    		st.setString(5, Type);
	    		st.execute();
	    		T_code.setText("");
	    		T_nom.setText("");
	    		T_pre.setText("");
	    		T_pass.setText("");
	    		T_type.setText("");
	    		Alert alert=new Alert(AlertType.CONFIRMATION,"Utilisateur Ajouter Sur", javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
	    		showutilisateur();
	    	}catch (SQLException e) {
	    		e.printStackTrace();
	    	}
    	}else {
    		
    		Alert alert=new Alert(AlertType.WARNING,"Remplir tout les champs !", javafx.scene.control.ButtonType.OK);
    		alert.showAndWait();
    	}

    }

    @FXML
    void cher_util() {
    	
    	String sql="select Code_Util,Nom_Util,Prenom_Util,Password,Type from utilisateur where Code_Util = '"+T_cher.getText()+"'";
    	int m=0;
    	try {
    		st=cnx.prepareStatement(sql);
    		result=st.executeQuery();
    		if(result.next()) {
    			T_code.setText(result.getString("Code_Util"));
    			T_nom.setText(result.getString("Nom_Util"));
    			T_pre.setText(result.getString("Prenom_Util"));
    			T_pass.setText(result.getString("Password"));
    			T_type.setText(result.getString("Type"));
    			m=1;
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	if(m==0) {
    		Alert alert=new Alert(AlertType.ERROR,"Aucun utilisateur trouve avec sous code = "+T_cher.getText()+"",javafx.scene.control.ButtonType.OK);
    		alert.showAndWait();
    	}

    }

    @FXML
    void mod_util() {
    	
    	String Code_Util=T_code.getText();
    	String Nom_Util=T_nom.getText();
    	String Prenom_Util=T_pre.getText();
    	String Password=T_pass.getText();
    	String Type=T_type.getText();
    	
    	String sql="update utilisateur set Code_Util=?, Nom_Util=?, Prenom_Util=?, Password=?, Type=? where Code_Util ='"+T_cher.getText()+"'";
    	if(!Code_Util.equals("")&&!Nom_Util.equals("")&&!Prenom_Util.equals("")&&!Password.equals("")&&!Type.equals("")) {
    		try {
	    		st=cnx.prepareStatement(sql);
	    		st=cnx.prepareStatement(sql);
	    		st.setString(1, Code_Util);
	    		st.setString(2, Nom_Util);
	    		st.setString(3, Prenom_Util);
	    		st.setString(4, Password);
	    		st.setString(5, Type);
	    		st.executeUpdate();
	    		T_code.setText("");
	    		T_nom.setText("");
	    		T_pre.setText("");
	    		T_pass.setText("");
	    		T_type.setText("");
	    		Alert alert=new Alert(AlertType.CONFIRMATION,"Modifer Utilisateur Succés", javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
	    		showutilisateur();
	    	}catch(SQLException e) {
	    		
	    		e.printStackTrace();
	    	}

    	}else {
    		
    		Alert alert=new Alert(AlertType.WARNING,"Remplir tout les champs !", javafx.scene.control.ButtonType.OK);
    		alert.showAndWait();
    	}

    }

    @FXML
    void sup_util() {
    	
    	String Code_Util=T_code.getText();
    	String Nom_Util=T_nom.getText();
    	String Prenom_Util=T_pre.getText();
    	String Password=T_pass.getText();
    	String Type=T_type.getText();
    	
    	String sql="delete from utilisateur where Code_Util = '"+T_cher.getText()+"'";
    	if(!Code_Util.equals("")&&!Nom_Util.equals("")&&!Prenom_Util.equals("")&&!Password.equals("")&&!Type.equals("")) {
    	try {
			st=cnx.prepareStatement(sql);
			st.executeUpdate();
			T_code.setText("");
    		T_nom.setText("");
    		T_pre.setText("");
    		T_pass.setText("");
    		T_type.setText("");
    		Alert alert=new Alert(AlertType.CONFIRMATION,"Supprimé Utilisateur Succés", javafx.scene.control.ButtonType.OK);
    		alert.showAndWait();
    		showutilisateur();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	}else {
    		
    		Alert alert=new Alert(AlertType.WARNING,"les champs est vide !!", javafx.scene.control.ButtonType.OK);
    		alert.showAndWait();
    	}

    }
    
    public void showutilisateur() {
    	Tablee.getItems().clear(); //vider la table a chaque foi fait un mis a jour (ajouter nouve client)
    	String sql="SELECT * FROM utilisateur";
    	try {
			st=cnx.prepareStatement(sql);
			result=st.executeQuery();
		while(result.next()) {
				data.add(new utilisateur(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5) ));
		}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
         tablee_code.setCellValueFactory(new PropertyValueFactory<utilisateur,Integer>("Code_Util"));
         tablee_nom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("Nom_Util"));
         tablee_pre.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("Prenom_Util"));
         tablee_pass.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("Password"));
         tablee_type.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("Type"));
         Tablee.setItems(data);
    	
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx=ConnexionMysql.connexionDB();
		 showutilisateur();
	}

	

}

