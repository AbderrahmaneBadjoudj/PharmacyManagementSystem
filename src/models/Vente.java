package models;

import java.sql.Date;

public class Vente {
	String CodeMedicamentVente;
	Date DateVente;
	int DosageVente;
	String NomVente;
	String PrenomVente;
	int PrixVente;
	int QuantiteVente;
	
	public Vente(){
		super();
	}
	public Vente(String CodeMedCell,Date DateCell,int DosageCell,String NomCliCell,String PrenomCliCell,
			int PrixCell,int QuantiteCell) {
		this.CodeMedicamentVente=CodeMedCell;
		this.DateVente=DateCell;
		this.DosageVente=DosageCell;
		this.NomVente=NomCliCell;
		this.PrenomVente=PrenomCliCell;
		this.PrixVente=PrixCell;
		this.QuantiteVente=QuantiteCell;
	}
	public String getCodeMedicamentVente() {
		return CodeMedicamentVente;
	}
	public void setCodeMedicamentVente(String codeMedicamentVente) {
		CodeMedicamentVente = codeMedicamentVente;
	}
	public Date getDateVente() {
		return DateVente;
	}
	public void setDateVente(Date dateVente) {
		DateVente = dateVente;
	}
	public int getDosageVente() {
		return DosageVente;
	}
	public void setDosageVente(int dosageVente) {
		DosageVente = dosageVente;
	}
	public String getNomVente() {
		return NomVente;
	}
	public void setNomVente(String nomVente) {
		NomVente = nomVente;
	}
	public String getPrenomVente() {
		return PrenomVente;
	}
	public void setPrenomVente(String prenomVente) {
		PrenomVente = prenomVente;
	}
	public int getPrixVente() {
		return PrixVente;
	}
	public void setPrixVente(int prixVente) {
		PrixVente = prixVente;
	}
	public int getQuantiteVente() {
		return QuantiteVente;
	}
	public void setQuantiteVente(int quantiteVente) {
		QuantiteVente = quantiteVente;
	}
	
}
