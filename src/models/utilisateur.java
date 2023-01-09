package models;

public class utilisateur {
	
	private int Code_Util; // private ajouter
	private String Nom_Util;
	private String Prenom_Util;
	private String Password;
	private String Type;
	
	public utilisateur() {
		super();
	}
	public utilisateur(int code_util, String Nom, String Prenom, String Password, String Type) {
		super(); // super ajouter
		this.Code_Util=code_util;
		this.Nom_Util=Nom;
		this.Prenom_Util=Prenom;
		this.Password=Password;
		this.Type=Type;
	}
	public int getCode_Util() {
		return Code_Util;
	}
	public void setCode_Util(int code_Util) {
		Code_Util = code_Util;
	}
	public String getNom_Util() {
		return Nom_Util;
	}
	public void setNom_Util(String nom_Util) {
		Nom_Util = nom_Util;
	}
	public String getPrenom_Util() {
		return Prenom_Util;
	}
	public void setPrenom_Util(String prenom_Util) {
		Prenom_Util = prenom_Util;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	

}
