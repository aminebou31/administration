package administration.java.models;

import java.util.ArrayList;

public class salle {
private int id_salle;
private String descri;
public int getId_salle() {
	return id_salle;
}
public void setId_salle(int id_salle) {
	this.id_salle = id_salle;
}
public String getDescri() {
	return descri;
}
public salle() {
	super();
	// TODO Auto-generated constructor stub
}
public void setDescri(String descri) {
	this.descri = descri;
}
public ArrayList<salle> filterSalles(ArrayList<salle> salles) {

	boolean check = true;
	ArrayList<salle> sallesFiltrer = new ArrayList<salle>();
	for (salle inscriptionPedagogique : salles) {
		check = true;
		for (salle inscriptionPedagogique1 : sallesFiltrer) {
			if (inscriptionPedagogique.getId_salle()==inscriptionPedagogique1.getId_salle())
				check = check && false;
		}
		if (check) {
			sallesFiltrer.add(inscriptionPedagogique);
		}
	}
	return sallesFiltrer;
}
}
