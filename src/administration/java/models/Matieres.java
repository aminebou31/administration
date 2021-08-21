package administration.java.models;

import java.util.ArrayList;

public class Matieres {
private int id_matiere;
private String nom_matiere;
private String type;
private String nom_mod;
public Matieres(int id_matiere, String nom_matiere, String type, String nom_mod) {
	super();
	this.id_matiere = id_matiere;
	this.nom_matiere = nom_matiere;
	this.type = type;
	this.nom_mod = nom_mod;
}
public Matieres() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId_matiere() {
	return id_matiere;
}
public void setId_matiere(int id_matiere) {
	this.id_matiere = id_matiere;
}
public String getNom_matiere() {
	return nom_matiere;
}
public void setNom_matiere(String nom_matiere) {
	this.nom_matiere = nom_matiere;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getNom_mod() {
	return nom_mod;
}
public void setNom_mod(String nom_mod) {
	this.nom_mod = nom_mod;
}
public ArrayList<Matieres> filterMatieres(ArrayList<Matieres> salles) {

	boolean check = true;
	ArrayList<Matieres> sallesFiltrer = new ArrayList<Matieres>();
	for (Matieres inscriptionPedagogique : salles) {
		check = true;
		for (Matieres inscriptionPedagogique1 : sallesFiltrer) {
			if (inscriptionPedagogique.getNom_matiere().equals(inscriptionPedagogique1.getNom_matiere()))
				check = check && false;
		}
		if (check) {
			sallesFiltrer.add(inscriptionPedagogique);
		}
	}
	return sallesFiltrer;
}
}
