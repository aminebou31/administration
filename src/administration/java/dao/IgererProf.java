package administration.java.dao;

import java.util.ArrayList;

import administration.java.models.professeur;
import administration.java.models.salle;

public interface IgererProf {
void ajouterProf(professeur p, int id);
void deleteProf(int id);
void modifierProf(professeur p);
public ArrayList<professeur> listProf();
public professeur getProf(int id_prof);
}
