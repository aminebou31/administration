package administration.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import administration.java.models.Reservation;
import administration.java.models.SingletonConnection;
import administration.java.models.salle;

public class GererSalleImpl implements IgererSalle {
	public void ajouterSalle(salle p) {
		Connection conn=SingletonConnection.getConnection();
		try {
			System.out.println("bien entrer");
	        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO salle(descri) VALUES(?);");
	        preparedStatement.setString(1, p.getDescri());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void deleteSalle(int id_salle) {
		Connection conn=SingletonConnection.getConnection();
		try {
			System.out.println("bien entrer");
	        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM salle WHERE id_salle= ? ");
	        preparedStatement.setInt(1,id_salle);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void modifierSalle(salle E) {
		Connection conn =SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("UPDATE salle set descri=? where id_salle=?;");
			ps.setString(1, E.getDescri());
			ps.setInt(2, E.getId_salle());
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public ArrayList<salle> listSalle() {
		ArrayList<salle> list = new ArrayList<salle>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("select * from salle;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	salle s=new salle();
                s.setDescri(rs.getString("descri"));
                s.setId_salle(rs.getInt("id_salle"));
                list.add(s);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return list;
	}
	public ArrayList<salle> listSalleFiltrer(Date date_res, String creneau) {
		ArrayList<salle> list = new ArrayList<salle>();
        Connection conn = SingletonConnection.getConnection();
        PreparedStatement p;
        PreparedStatement ps;
        PreparedStatement pr;
        try {
            p = conn.prepareStatement("select * from salle where id_salle != ? ;");
            ps = conn.prepareStatement("select * from salle where id_salle != ? ;");
            pr = conn.prepareStatement("select s.* from salle s, reserversalle r where s.id_salle != r.id_salle and s.id_salle != ? and s.id_salle != ?;");
            p.setInt(1, list(date_res));
            ps.setInt(1, list2(date_res,creneau));
            pr.setInt(1, list(date_res));
            pr.setInt(2, list2(date_res,creneau));
            System.out.println("salle a ne pas afficher id="+list2(date_res,creneau));
            System.out.println("salle a ne pas afficher id="+list(date_res));
            //ResultSet rs1 = p.executeQuery();
            ResultSet rs3 = ps.executeQuery();
            ResultSet rs2 = pr.executeQuery();
           /* while (rs1.next()) {
            	salle s1=new salle();
                s1.setDescri(rs1.getString("descri"));
                s1.setId_salle(rs1.getInt("id_salle"));
                list.add(s1);
            }*/
            while (rs2.next()) {
            	salle s2=new salle();
                s2.setDescri(rs2.getString("descri"));
                s2.setId_salle(rs2.getInt("id_salle"));
                list.add(s2);
            }
            while (rs3.next()) {
            	salle s1=new salle();
                s1.setDescri(rs3.getString("descri"));
                s1.setId_salle(rs3.getInt("id_salle"));
                list.add(s1);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return list;
	}
	public int list(Date date_res) {
        Connection conn = SingletonConnection.getConnection();
        int id_salle=0;
        PreparedStatement p;
        try {
            p = conn.prepareStatement("select s.* from salle s, reserversalle r where s.id_salle=r.id_salle and r.date_res = ? ;");
            p.setDate(1, date_res);
            ResultSet rs1 = p.executeQuery();
            while (rs1.next()) {
                id_salle= rs1.getInt("id_salle");
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return id_salle;
	}
	public int list2(Date date_res,String creneau) {
        Connection conn = SingletonConnection.getConnection();
        int id_salle=0;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select  s.* from salle s, reserversalle r where s.id_salle=r.id_salle and r.date_res=? and r.crenau = ?");
            ps.setString(1, date_res.toString());
            ps.setString(2, creneau);
            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()) {
                id_salle= rs1.getInt("id_salle");
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return id_salle;
	}
	public salle geSalle(int id_salle) {
		salle s = new salle();
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from salle where id_salle=?;");
            ps.setInt(1,id_salle);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	s.setDescri(rs.getString("descri"));
                s.setId_salle(Integer.parseInt(rs.getString("id_salle")));
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return s;
	}
	public void ajouterReser(Reservation p) throws SQLException{
		Connection conn=SingletonConnection.getConnection();
		try {
			System.out.println("bien entrer");
	        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO reserverSalle(date_res,id_salle,id_prof,crenau) VALUES(?,?,?,?);");
	        preparedStatement.setString(1, p.getDate_res().toString());
	        preparedStatement.setInt(2, p.getId_salle());
	        preparedStatement.setInt(3, p.getId_prof());
	        preparedStatement.setString(4, p.getCrenau());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        throw (e);
	    }
	}
	public ArrayList<Reservation> listres() {
		ArrayList<Reservation> s = new ArrayList<Reservation>();
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from reserversalle;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Reservation r=new Reservation();
            	r.setCrenau(rs.getString("crenau"));
            	r.setDate_res(rs.getDate("date_res"));
            	r.setId_prof(rs.getInt("id_prof"));
                r.setId_salle(rs.getInt("id_salle"));
                s.add(r);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return s;
	}
	public ArrayList<Reservation> listResProf(int id_prof) {
		ArrayList<Reservation> s = new ArrayList<Reservation>();
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from reserversalle where id_prof=?;");
            ps.setInt(1, id_prof);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Reservation r=new Reservation();
            	r.setCrenau(rs.getString("crenau"));
            	r.setDate_res(rs.getDate("date_res"));
                r.setId_salle(rs.getInt("id_salle"));
                s.add(r);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return s;
	}
	public String getNomprof(int id_prof) {
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        String nomprof = null;
        try {
            ps = conn.prepareStatement("select nom from professeur where id_prof=?;");
            ps.setInt(1,id_prof);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	nomprof=rs.getString("nom");
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return nomprof;
	}
	public int getIdprof(String nom) {
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        int idprof = 0;
        try {
            ps = conn.prepareStatement("select id_prof from professeur where nom=?;");
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	idprof=rs.getInt("id_prof");
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return idprof;
	}
	public void deleteRes(int id_prof, int id_salle, String crenau, Date date_res) {
		Connection conn=SingletonConnection.getConnection();
		try {
			System.out.println("bien entrer");
	        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM reserversalle WHERE id_salle= ? and id_prof=? and crenau=? and date_res=? ");
	        preparedStatement.setInt(1,id_salle);
	        preparedStatement.setInt(2,id_prof);
	        preparedStatement.setString(3,crenau);
	        preparedStatement.setString(4,date_res.toString());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public ArrayList<Reservation> listresFiltrer(String nom) {
		ArrayList<Reservation> s = new ArrayList<Reservation>();
		Connection conn = SingletonConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from reserversalle where id_prof=?;");
            ps.setInt(1,getIdprof(nom));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Reservation r=new Reservation();
            	r.setCrenau(rs.getString("crenau"));
            	r.setDate_res(rs.getDate("date_res"));
            	r.setId_prof(rs.getInt("id_prof"));
                r.setId_salle(rs.getInt("id_salle"));
                s.add(r);
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }
		return s;
	}
}
