package models;

import java.sql.Date;

public class medicament {

String Code_Med;
String Désignation;
int Prix;
String Remarque;
Date Date_EXP;
int quantité;

 public medicament(){
	super();
}
public medicament(String CodeMedicament,String designation,int prix,String remarque,Date DateExp,int quan ) {
	this.Code_Med=CodeMedicament;
	this.Désignation=designation;
	this.Prix=prix;
	this.Remarque=remarque;
	this.Date_EXP=DateExp;
	this.quantité=quan;
	
}
public String getCode_Med() {
	return Code_Med;
}
public void setCode_Med(String code_Med) {
	Code_Med = code_Med;
}
public String getDésignation() {
	return Désignation;
}
public void setDésignation(String désignation) {
	Désignation = désignation;
}
public int getPrix() {
	return Prix;
}
public void setPrix(int prix) {
	Prix = prix;
}
public String getRemarque() {
	return Remarque;
}
public void setRemarque(String remarque) {
	Remarque = remarque;
}
public Date getDate_EXP() {
	return Date_EXP;
}
public void setDate_EXP(Date date_EXP) {
	Date_EXP = date_EXP;
}
public int getQuantité() {
	return quantité;
}
public void setQuantité(int quantité) {
	this.quantité = quantité;
}


}
