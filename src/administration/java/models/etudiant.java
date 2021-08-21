package administration.java.models;

import java.sql.Date;


public class etudiant{
public etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

@Override
public String toString() {
	return "etudiant [id_etu=" + id_etu + ", nomAr=" + nomAr + ", prenomAr=" + prenomAr + ", nomFr=" + nomFr
			+ ", prenomFr=" + prenomFr + ", nationalite=" + nationalite + ", lieuNaissanceAR=" + lieuNaissanceAR
			+ ", lieuNaissanceFR=" + lieuNaissanceFR + ", ville=" + ville + ", anneeBac=" + anneeBac + ", mention="
			+ mention + ", lycee=" + lycee + ", serieBac=" + serieBac + ", villeBac=" + villeBac + ", academie="
			+ academie + ", date_inscription=" + date_inscription + ", CNE=" + CNE + ", CNI=" + CNI + ", assiduite="
			+ assiduite + ", nbreAbsence=" + nbreAbsence + ", date_naissance=" + date_naissance + ", sexe=" + sexe
			+ ", id_filiere=" + id_filiere + "]";
}

public etudiant(String nomAr, String prenomAr, String nomFr, String prenomFr, String nationalite,
		String lieuNaissanceAR, String lieuNaissanceFR, String ville, int anneeBac, String mention, String lycee,
		String serieBac, String villeBac, String academie, String cNE,
		String cNI, Date date_naissance, String sexe) {
	super();
	this.serieBac = serieBac;
	this.nomAr = nomAr;
	this.prenomAr = prenomAr;
	this.nomFr = nomFr;
	this.prenomFr = prenomFr;
	this.nationalite = nationalite;
	this.lieuNaissanceAR = lieuNaissanceAR;
	this.lieuNaissanceFR = lieuNaissanceFR;
	this.ville = ville;
	this.anneeBac = anneeBac;
	this.villeBac = villeBac;
	this.mention = mention;
	this.lycee = lycee;
	this.academie = academie;
	CNE = cNE;
	CNI = cNI;
	this.date_naissance = date_naissance;
	this.sexe = sexe;
}

public void setId_etu(int id_etu) {
	this.id_etu = id_etu;
}
private int id_sem=0;
private int id_etu=0;
private String nomAr="null";
private String prenomAr="null";
private String nomFr="null";
private String prenomFr="null";
private String nationalite="null";
private String lieuNaissanceAR="null";
private String lieuNaissanceFR="null";
private String ville="null";
private int anneeBac=0;
private String mention="null";
private String lycee="null";
private String serieBac="null";
private String villeBac="null";
private String academie="null";
private Date date_inscription;
private String CNE="null";
private String CNI="null";
private String assiduite="null";
private int nbreAbsence=0;
private Date date_naissance;
private String sexe="null"; 
private int id_filiere=0;
public int getId_etu() {
	return id_etu;
}
public String getCNE() {
	return CNE;
}
public void setCNE(String cNE) {
	CNE = cNE;
}
public String getCNI() {
	return CNI;
}
public void setCNI(String cNI) {
	CNI = cNI;
}
public String getAssiduite() {
	return assiduite;
}
public void setAssiduite(String assiduite) {
	this.assiduite = assiduite;
}
public int getNbreAbsence() {
	return nbreAbsence;
}
public void setNbreAbsence(int nbreAbsence) {
	this.nbreAbsence = nbreAbsence;
}
public java.sql.Date getDate_naissance() {
	return date_naissance;
}
public void setDate_naissance(Date date_naissance) {
	this.date_naissance = date_naissance;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
public int getId_filiere() {
	return id_filiere;
}
public void setId_filiere(int id_filiere) {
	this.id_filiere = id_filiere;
}
public String getNomAr() {
	return nomAr;
}
public void setNomAr(String nomAr) {
	this.nomAr = nomAr;
}
public String getPrenomAr() {
	return prenomAr;
}
public void setPrenomAr(String prenomAr) {
	this.prenomAr = prenomAr;
}
public String getNomFr() {
	return nomFr;
}
public void setNomFr(String nomFr) {
	this.nomFr = nomFr;
}
public String getPrenomFr() {
	return prenomFr;
}
public void setPrenomFr(String prenomFr) {
	this.prenomFr = prenomFr;
}
public String getNationalite() {
	return nationalite;
}
public void setNationalite(String nationalite) {
	this.nationalite = nationalite;
}
public String getLieuNaissanceAR() {
	return lieuNaissanceAR;
}
public void setLieuNaissanceAR(String lieuNaissanceAR) {
	this.lieuNaissanceAR = lieuNaissanceAR;
}
public String getLieuNaissanceFR() {
	return lieuNaissanceFR;
}
public void setLieuNaissanceFR(String lieuNaissanceFR) {
	this.lieuNaissanceFR = lieuNaissanceFR;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public int getAnneeBac() {
	return anneeBac;
}
public void setAnneeBac(int anneeBac) {
	this.anneeBac = anneeBac;
}
public String getMention() {
	return mention;
}
public void setMention(String mention) {
	this.mention = mention;
}
public String getLycee() {
	return lycee;
}
public void setLycee(String lycee) {
	this.lycee = lycee;
}
public String getAcademie() {
	return academie;
}
public void setAcademie(String academie) {
	this.academie = academie;
}
public Date getDate_inscription() {
	return date_inscription;
}
public void setDate_inscription(Date date_inscription) {
	this.date_inscription = date_inscription;
}
public String getSerieBac() {
	return serieBac;
}
public void setSerieBac(String serieBac) {
	this.serieBac = serieBac;
}
public String getVilleBac() {
	return villeBac;
}
public void setVilleBac(String villeBac) {
	this.villeBac = villeBac;
}

public int getId_sem() {
	return id_sem;
}

public void setId_sem(int id_sem) {
	this.id_sem = id_sem;
}

}
