package administration.java.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import administration.java.models.*;

public class GererEtudiant implements IGererEtudiant{
	ArrayList<String> bgi=new ArrayList<String>();
	ArrayList<String> bgb=new ArrayList<String>();
	ArrayList<String> bca=new ArrayList<String>();
	public void ajoutEtudiant(etudiant E) {
		Connection conn=SingletonConnection.getConnection();
		try {
			System.out.println("bien entrer");
	        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO etudiant(nomFr, prenomFr, nomAr, prenomAr, nationalite, lieuNaissanceFR, lieuNaissanceAR, ville, anneeBac, mention, lycee, serieBac, villeBac, academie, CNE, CNI, date_naissance, sexe, id_filiere, id_sem ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
	        preparedStatement.setString(1,E.getNomFr());
	        preparedStatement.setString(2,E.getPrenomFr());
	        preparedStatement.setString(3,E.getNomAr());
            preparedStatement.setString(4,E.getPrenomAr());
            preparedStatement.setString(5,E.getNationalite());
            preparedStatement.setString(6,E.getLieuNaissanceFR());
            preparedStatement.setString(7,E.getLieuNaissanceAR());
            preparedStatement.setString(8,E.getVille());
            preparedStatement.setInt(9,E.getAnneeBac());
            preparedStatement.setString(10,E.getMention());
            preparedStatement.setString(11,E.getLycee());
            preparedStatement.setString(12,E.getSerieBac());
            preparedStatement.setString(13,E.getVilleBac());
            preparedStatement.setString(14,E.getAcademie());
            preparedStatement.setString(15,E.getCNE());
            preparedStatement.setString(16,E.getCNI());
            preparedStatement.setDate(17,E.getDate_naissance());
            preparedStatement.setString(18,E.getSexe());
            preparedStatement.setInt(19,E.getId_filiere());
            preparedStatement.setInt(20,E.getId_sem());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void deleteEtudiant(int id_etu) {
		Connection conn=SingletonConnection.getConnection();
		try {
	        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM etudiant WHERE id_etu=?;");
	        PreparedStatement pre = conn.prepareStatement("DELETE FROM etu_mat WHERE id_etu=?;");
	        PreparedStatement p = conn.prepareStatement("DELETE FROM utilisateur WHERE id_etu=?;");
	        PreparedStatement ps = conn.prepareStatement("DELETE FROM docetu WHERE id_etu=?;");
	        preparedStatement.setInt(1, id_etu);
	        pre.setInt(1, id_etu);
	        p.setInt(1, id_etu);
	        ps.setInt(1, id_etu);
	        pre.executeUpdate();
	        ps.executeUpdate();
	        p.executeUpdate();
	        preparedStatement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void modifierEtu(etudiant E) {
			Connection conn =SingletonConnection.getConnection();
			PreparedStatement ps;
			try {
				ps=conn.prepareStatement("UPDATE etudiant SET nomAr=?,nomFr=?,prenomAr=?,prenomFr=?,id_sem=? where id_etu=?;");
				ps.setString(1, E.getNomAr());
				ps.setString(2, E.getNomFr());
				ps.setString(3, E.getPrenomAr());
				ps.setString(4, E.getPrenomFr());
				ps.setInt(6, E.getId_etu());
				ps.setInt(5, E.getId_sem());
				ps.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	public ArrayList<etudiant> listEt() {
		ArrayList<etudiant> list = new ArrayList<etudiant>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from etudiant;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etudiant etudiant = new etudiant();
                etudiant.setId_etu(rs.getInt("id_etu"));
                etudiant.setNomFr(rs.getString("nomFr"));
                etudiant.setPrenomFr(rs.getString("prenomFr"));
                etudiant.setDate_inscription(rs.getDate("date_inscription"));
                etudiant.setCNE(rs.getString("CNE"));
                etudiant.setId_filiere(rs.getInt("id_filiere"));
                etudiant.setSexe(rs.getString("sexe"));
                list.add(etudiant);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	public ArrayList<etudiant> listEtuFil(String nom) {
		ArrayList<etudiant> list = new ArrayList<etudiant>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from etudiant where nomFr=?;");
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etudiant etudiant = new etudiant();
                etudiant.setId_etu(rs.getInt("id_etu"));
                etudiant.setNomFr(rs.getString("nomFr"));
                etudiant.setPrenomFr(rs.getString("prenomFr"));
                etudiant.setDate_inscription(rs.getDate("date_inscription"));
                etudiant.setCNE(rs.getString("CNE"));
                etudiant.setId_filiere(rs.getInt("id_filiere"));
                etudiant.setSexe(rs.getString("sexe"));
                list.add(etudiant);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	public ArrayList<String> listFil() {
		ArrayList<String> list = new ArrayList<String>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from filiere;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String f= rs.getString("nom");
                System.out.println(f);
                list.add(f);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	public ArrayList<String> listSem(int id_fil) {
		ArrayList<String> list = new ArrayList<String>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from semestre where id_filiere=?;");
            ps.setInt(1, id_fil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String f= rs.getString("nom");
                System.out.println(f);
                list.add(f);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	public ArrayList<etudiant> listEtuFiltrer(int id_sem, int id_fil) {
		ArrayList<etudiant> list = new ArrayList<etudiant>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from etudiant where id_filiere=? and id_sem=?;");
            ps.setInt(1,id_fil);
            ps.setInt(2,id_sem);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	etudiant etudiant = new etudiant();
                etudiant.setId_etu(rs.getInt("id_etu"));
                etudiant.setNomFr(rs.getString("nomFr"));
                etudiant.setPrenomFr(rs.getString("prenomFr"));
                etudiant.setDate_inscription(rs.getDate("date_inscription"));
                etudiant.setCNE(rs.getString("CNE"));
                etudiant.setSexe(rs.getString("sexe"));
                
                list.add(etudiant);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	public etudiant getEtu(int id_etu) {
		etudiant etudiant = new etudiant();
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from etudiant where id_etu=?;");
            ps.setInt(1,id_etu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etudiant.setNomFr(rs.getString("nomFr"));
                etudiant.setPrenomFr(rs.getString("prenomFr"));
                etudiant.setNomAr(rs.getString("nomAr"));
                etudiant.setPrenomAr(rs.getString("prenomAr"));
                etudiant.setId_filiere(rs.getInt("id_filiere"));
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return etudiant;
	}
	public int getEtuByCNE(String nom_etu) {
		int id_etu = 0;
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from etudiant where CNE=?;");
            ps.setString(1,nom_etu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id_etu=rs.getInt("id_etu");
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return id_etu;
	}
	@SuppressWarnings("resource")
	public void addEtuExcel(InputStream file) {

		ArrayList<etudiant> Etudiants = new ArrayList<etudiant>();
		ArrayList<String> values = new ArrayList<String>();
		
		System.out.print("iciiiiiiiiiiiii" + file.toString());

		try {

			System.out.print("iciiiiiiiiiiiii1");

			HSSFWorkbook wb = new HSSFWorkbook(file);// preciser que ce document est excel
			HSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			while (rows.hasNext()) {
				System.out.println("  in  ");
				values.clear();
				HSSFRow row = (HSSFRow) rows.next();
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {

					HSSFCell cell = (HSSFCell) cells.next();

					if (cell.getCellType() == CellType.STRING)
						values.add(cell.getStringCellValue());
					else if (cell.getCellType() == CellType.NUMERIC) {
						values.add(Integer.toString((int) (cell.getNumericCellValue())));

					}

				}
				etudiant e = new etudiant();
				e.setNomFr(values.get(0));
				e.setPrenomFr(values.get(1));
				e.setNomAr(values.get(2));
				e.setPrenomAr(values.get(3));
				e.setAcademie(values.get(4));
				e.setAnneeBac(Integer.parseInt(values.get(5)));
				e.setCNI(values.get(6));
				String date = values.get(7);
				System.out.println("date=" + date);

				java.sql.Date date_sql = new java.sql.Date(Integer.parseInt(date));
				e.setDate_naissance(date_sql);
				System.out.println("dateN=" + date_sql);
				e.setVilleBac(values.get(8));
				e.setLieuNaissanceAR(values.get(9));
				e.setLieuNaissanceFR(values.get(10));
				e.setVille(values.get(11));
				e.setLycee(values.get(12));
				e.setCNE(values.get(13));
				System.out.println(values.get(13));
				e.setMention(values.get(14));
				e.setNationalite(values.get(15));
				e.setSerieBac(values.get(16));
				e.setSexe(values.get(17));
				e.setId_filiere(getIdFil(values.get(18)));

				Etudiants.add(e);
				for (int i = 0; i < Etudiants.size(); i++) {
					ajoutEtudiant(Etudiants.get(i));
					System.out.println("ajout");
				}
			}

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public int getIdFil(String nom) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps ;
	    int idfil=0;
	    try {
	        ps = conn.prepareStatement("select id_filiere from filiere where nom=? ;");
	        ps.setString(1,nom);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            idfil = rs.getInt("id_filiere");
	            System.out.println("id filiere entrer"+rs.getInt("id_filiere"));
	        }
	    }catch (Exception e) {
	        // TODO: handle exception
	    }
	    return idfil ;
	}
	public int getIdSem(String nom) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps ;
	    int idfil=0;
	    try {
	        ps = conn.prepareStatement("select id_sem from semestre where nom=? and id_filiere=1;");
	        ps.setString(1,nom);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            idfil = rs.getInt("id_sem");
	            System.out.println(rs.getInt("id_sem"));
	        }
	    }catch (Exception e) {
	        // TODO: handle exception
	    }
	    return idfil ;
	}
	public String getNomFil(int id_fil) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps ;
	    String nom_fil= null;
	    try {
	        ps = conn.prepareStatement("select nom from filiere where id_filiere=?;");
	        ps.setInt(1,id_fil);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            nom_fil = rs.getString("nom");
	            System.out.println(rs.getInt("nom"));
	        }
	    }catch (Exception e) {
	        // TODO: handle exception
	    }
	    return nom_fil ;
	}
	public void ajoutDocEtu(doc_etu E) {
		Connection conn=SingletonConnection.getConnection();
		try {
			System.out.println("bien entrer");
	        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO docetu(fichier, nom, id_etu, descript ) VALUES(?, ?, ?, ?);");
	        preparedStatement.setBlob(1, E.getDoc());
	        preparedStatement.setString(2, E.getNom());
	        preparedStatement.setInt(3, E.getId_etu());
	        preparedStatement.setString(4, E.getDescript());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public boolean checkDocEtu(int id_etu) {
		boolean check=false;
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps ;
	    try {
	        ps = conn.prepareStatement("select * from docetu where id_etu=? ;");
	        ps.setInt(1,id_etu);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            check=true;
	            
	        }
	    }catch (Exception e) {
	        // TODO: handle exception
	    }
	    System.out.println("check doc etu"+check);
		return check;
	}
	public ArrayList<String> listMat(int id_fil) {
		ArrayList<String> list = new ArrayList<String>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from semestre where id_filiere=?;");
            ps.setInt(1, id_fil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String f= rs.getString("nom");
                System.out.println(f);
                list.add(f);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	public void affecterMatBgi(int id_etu) {
		Connection conn=SingletonConnection.getConnection();
		try {
			for(int i=2;i<8;i++) {
				if(i!=3) {
			        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO etu_mat(id_etu,id_mat) values(?,?);");
		            preparedStatement.setInt(1,id_etu);
		            preparedStatement.setInt(2,i);
			        preparedStatement.executeUpdate();
				}
			}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void affecterMatBgb(int id_etu) {
		Connection conn=SingletonConnection.getConnection();
		try {
			for(int i=8;i<13;i++) {
			    PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO etu_mat(id_etu,id_mat) values(?,?);");
		        preparedStatement.setInt(1,id_etu);
		        preparedStatement.setInt(2,i);
			    preparedStatement.executeUpdate();
			}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void affecterMatBca(int id_etu) {
		Connection conn=SingletonConnection.getConnection();
		try {
			for(int i=13;i<18;i++) {
			    PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO etu_mat(id_etu,id_mat) values(?,?);");
		        preparedStatement.setInt(1,id_etu);
		        preparedStatement.setInt(2,i);
			    preparedStatement.executeUpdate();
			}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void affecterMat(int id_etu,int id_mat) {
		Connection conn=SingletonConnection.getConnection();
		try {
			        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO etu_mat(id_etu,id_mat) values(?,?);");
		            preparedStatement.setInt(1,id_etu);
		            preparedStatement.setInt(2,id_mat);
			        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public int getIdMat(String nom) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps ;
	    int idfil=0;
	    try {
	        ps = conn.prepareStatement("select id_matiere from matiere where nom_matiere=?;");
	        ps.setString(1,nom);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            idfil = rs.getInt("id_matiere");
	        }
	    }catch (Exception e) {
	        // TODO: handle exception
	    }
	    return idfil ;
	}
	public ArrayList<etudiant> listEtuFiltrerProf(int id_matiere) {
		ArrayList<etudiant> list = new ArrayList<etudiant>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select  e.* from etudiant e, etu_mat em where e.id_etu=em.id_etu and em.id_mat=?;");
            ps.setInt(1,id_matiere);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	etudiant etudiant = new etudiant();
                etudiant.setId_etu(rs.getInt("id_etu"));
                etudiant.setNomFr(rs.getString("nomFr"));
                etudiant.setPrenomFr(rs.getString("prenomFr"));
                etudiant.setDate_inscription(rs.getDate("date_inscription"));
                etudiant.setCNE(rs.getString("CNE"));
                etudiant.setSexe(rs.getString("sexe"));
                
                list.add(etudiant);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }
	}
