package administration.java.models;

public class professeur {
public professeur(String nom, int tel, String prenom, String email) {
		super();
		this.nom = nom;
		this.tel = tel;
		this.prenom = prenom;
		this.email = email;
	}
public professeur() {
		super();
		// TODO Auto-generated constructor stub
	}
private int id_prof=0;
private String nom=null;
private int tel=0;
private String prenom=null;
private String email=null;
private int nbreAbsence=0;


public int getId_prof() {
	return id_prof;
}
public void setId_prof(int id_prof) {
	this.id_prof = id_prof;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getNbreAbsence() {
	return nbreAbsence;
}
public void setNbreAbsence(int nbreAbsence) {
	this.nbreAbsence = nbreAbsence;
}
public int getTel() {
	return tel;
}
public void setTel(int tel) {
	this.tel = tel;
}
}
