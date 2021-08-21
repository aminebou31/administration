package administration.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import administration.java.models.Matieres;
import administration.java.models.SingletonConnection;
import administration.java.models.doc_etu;
import administration.java.models.doc_prof;
import administration.java.models.etudiant;
import administration.java.models.professeur;

public class GererProf_impl implements IgererProf {
	public void ajouterProf(professeur p,int mat) {
		Connection conn=SingletonConnection.getConnection();
		try {
			System.out.println("bien entrer");
	        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO professeur(nom, username, tel, prenom, nbreAbsence ) VALUES(?, ?, ?, ?, ?);");
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO mat_prof(id_prof,id_mat) VALUES(?, ?);");
	        preparedStatement.setString(1, p.getNom());
	        preparedStatement.setString(2, p.getEmail());
	        preparedStatement.setInt(3, p.getTel());
	        preparedStatement.setString(4, p.getPrenom());
	        preparedStatement.setInt(5, p.getNbreAbsence());
	        preparedStatement.executeUpdate();
	        ps.setInt(1, getProfByTel(p.getTel()));
	        ps.setInt(2, mat);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void deleteProf(int id_prof) {
		Connection conn=SingletonConnection.getConnection();
		try {
	        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM professeur WHERE id_prof=?;");
	        PreparedStatement p = conn.prepareStatement("DELETE FROM utilisateur WHERE id_prof=?;");
	        PreparedStatement ps = conn.prepareStatement("DELETE FROM docprof WHERE id_prof=?;");
	        PreparedStatement pre = conn.prepareStatement("DELETE FROM mat_prof WHERE id_prof=?;");
	        preparedStatement.setInt(1, id_prof);
	        p.setInt(1, id_prof);
	        ps.setInt(1, id_prof);
	        pre.setInt(1, id_prof);
	        pre.executeUpdate();
	        pre.executeUpdate();
	        ps.executeUpdate();
	        p.executeUpdate();
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void ajoutDocProf(doc_prof E) {
		Connection conn=SingletonConnection.getConnection();
		try {
			System.out.println("bien entrer");
	        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO docprof(fichier, nom, id_prof, descript ) VALUES(?, ?, ?, ?);");
	        preparedStatement.setBlob(1, E.getDoc());
	        preparedStatement.setString(2, E.getNom());
	        preparedStatement.setInt(3, E.getId_prof());
	        preparedStatement.setString(4, E.getDescript());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public ArrayList<professeur> listProf() {
		ArrayList<professeur> list = new ArrayList<professeur>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from professeur;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                professeur prof = new professeur();
                prof.setId_prof(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setNbreAbsence(rs.getInt("nbreAbsence"));
                prof.setTel(rs.getInt("tel"));
                list.add(prof);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	public void modifierProf(professeur E) {
		Connection conn =SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("UPDATE professeur SET nom=?,prenom=?,nbreAbsence=?,tel=? where id_prof=?;");
			ps.setString(1, E.getNom());
			ps.setString(2, E.getPrenom());
			ps.setInt(3, E.getNbreAbsence());
			ps.setInt(4, E.getId_prof());
			ps.setInt(5, E.getTel());
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*public ArrayList<Matieres> listMat(int id_prof) {
		ArrayList<Matieres> list = new ArrayList<Matieres>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from mat_prof where id_prof=?;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                professeur prof = new professeur();
                prof.setId_prof(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setNbreAbsence(rs.getInt("nbreAbsence"));
                prof.setTel(rs.getInt("tel"));
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }*/
	public int getMat(String nom) {
		int id_mat=0;
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select id_matiere from matiere where nom_matiere=?;");
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id_mat=rs.getInt("id_matiere");
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return id_mat;
	}
	public ArrayList<Matieres> listMat() {
		ArrayList<Matieres> list = new ArrayList<Matieres>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select distinct * from matiere;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Matieres mat = new Matieres();
                mat.setNom_matiere(rs.getString("nom_matiere"));
                mat.setType(rs.getString("type"));
                mat.setNom_mod(rs.getString("nom_mod"));
                list.add(mat);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	public professeur getProf(int id_prof) {
		professeur prof = new professeur();
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from professeur where id_prof=?;");
            ps.setInt(1,id_prof);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setNbreAbsence(rs.getInt("nbreAbsence"));
                prof.setTel(rs.getInt("tel"));
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return prof;
	}
	public int getProfByTel(int Tel) {
		int id_prof=0;
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from professeur where tel=?;");
            ps.setInt(1,Tel);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id_prof=rs.getInt("id_prof");
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return id_prof;
	}
	public int getProfByName(String nom_prof) {
		int id_prof=0;
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from professeur where nom=?;");
            ps.setString(1,nom_prof);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id_prof=rs.getInt("id_prof");
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return id_prof;
	}
	public ArrayList<professeur> listProfFilt(int id_mat) {
		ArrayList<professeur> list = new ArrayList<professeur>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select  p.* from professeur p , mat_prof m where m.id_mat=? and m.id_prof=p.id_prof;");
            ps.setInt(1, id_mat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                professeur prof = new professeur();
                prof.setId_prof(rs.getInt("id_prof"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setNbreAbsence(rs.getInt("nbreAbsence"));
                prof.setTel(rs.getInt("tel"));
                list.add(prof);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	}

