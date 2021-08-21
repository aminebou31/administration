package administration.java.models;

public class Utilisateur {
public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
@Override
public String toString() {
	return email;
}
public Utilisateur(String email, String mdp, String role) {
		super();
		Utilisateur.id_util = 1+id_util;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
	}
private static int id_util=0;
private String email;
private String mdp;
private String role;
private int id_etu=0;
private int id_prof=0;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getId_etu() {
	return id_etu;
}
public void setId_etu(int id_etu) {
	this.id_etu = id_etu;
}
public int getId_prof() {
	return id_prof;
}
public void setId_prof(int id_prof) {
	this.id_prof = id_prof;
}
}
