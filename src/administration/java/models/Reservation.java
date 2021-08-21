package administration.java.models;

import java.sql.Date;

import administration.java.dao.GererSalleImpl;

public class Reservation {
public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
private int id_prof;
private int id_salle;
private Date date_res;
private String crenau;
public int getId_prof() {
	return id_prof;
}
public void setId_prof(int id_prof) {
	this.id_prof = id_prof;
}
public int getId_salle() {
	return id_salle;
}
public void setId_salle(int id_salle) {
	this.id_salle = id_salle;
}
public Date getDate_res() {
	return date_res;
}
public void setDate_res(Date date_res) {
	this.date_res = date_res;
}
public String getCrenau() {
	return crenau;
}
public void setCrenau(String crenau) {
	this.crenau = crenau;
}
public String getNom_prof(int id_prof) {
	GererSalleImpl g=new GererSalleImpl();
	return g.getNomprof(id_prof);
}
}
