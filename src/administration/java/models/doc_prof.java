package administration.java.models;

import java.io.InputStream;

public class doc_prof {
public doc_prof() {
		super();
		// TODO Auto-generated constructor stub
	}
public doc_prof(String descript, String nom, InputStream doc, int id_etu) {
		super();
		this.descript = descript;
		this.nom = nom;
		this.doc = doc;
		this.id_prof = id_etu;
	}
private int id_docprof;
private String descript=null;
private String nom=null;
private InputStream doc=null;
private int id_prof;
public int getId_docEtu() {
	return id_docprof;
}
public void setId_docEtu(int id_docEtu) {
	this.id_docprof = id_docEtu;
}
public String getDescript() {
	return descript;
}
public void setDescript(String descript) {
	this.descript = descript;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public InputStream getDoc() {
	return doc;
}
public void setDoc(InputStream doc) {
	this.doc = doc;
}
public int getId_prof() {
	return id_prof;
}
public void setId_prof(int id_prof) {
	this.id_prof = id_prof;
}
}
