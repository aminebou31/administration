package administration.java.models;

import java.io.InputStream;

public class doc_etu {
public doc_etu() {
		super();
		// TODO Auto-generated constructor stub
	}
public doc_etu(String descript, String nom, InputStream doc, int id_etu) {
		super();
		this.descript = descript;
		this.nom = nom;
		this.doc = doc;
		this.id_etu = id_etu;
	}
private int id_docEtu;
private String descript=null;
private String nom=null;
private InputStream doc=null;
private int id_etu;
public int getId_docEtu() {
	return id_docEtu;
}
public void setId_docEtu(int id_docEtu) {
	this.id_docEtu = id_docEtu;
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
public int getId_etu() {
	return id_etu;
}
public void setId_etu(int id_etu) {
	this.id_etu = id_etu;
}
}
