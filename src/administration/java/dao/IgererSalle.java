package administration.java.dao;

import administration.java.models.salle;

public interface IgererSalle {
	void ajouterSalle(salle p);
	void deleteSalle(int id_salle);
	void modifierSalle(salle p); 
}
