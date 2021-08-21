package administration.java.models;

public class etu_mat {
public etu_mat(int id_etu, int id_mat) {
		super();
		this.id_etu = id_etu;
		this.id_mat = id_mat;
	}
private int id_etu;
public etu_mat() {
	super();
	// TODO Auto-generated constructor stub
}
private int id_mat;
public int getId_mat() {
	return id_mat;
}
public void setId_mat(int id_mat) {
	this.id_mat = id_mat;
}
public int getId_etu() {
	return id_etu;
}
public void setId_etu(int id_etu) {
	this.id_etu = id_etu;
}
}
