package administration.java.dao;
import administration.java.models.*;

interface IGererEtudiant {
	void ajoutEtudiant(etudiant e);
	void deleteEtudiant(int i);
	void modifierEtu(etudiant e);
}

