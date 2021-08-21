package administration.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import administration.java.models.SingletonConnection;
import administration.java.models.Utilisateur;

public class LoginCheck {
	public void ajouterUtilEtu(Utilisateur u,int id_etu) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps;
	    try {
	        ps=conn.prepareStatement("INSERT INTO utilisateur(email,mdp,role,id_etu ) VALUES(?, ?, ?, ?);");
	        ps.setString(1, u.getEmail());
	        ps.setString(2, u.getMdp());
	        ps.setString(3,u.getRole() );
	        ps.setInt(4, id_etu);
	        ps.executeUpdate();
	    }catch(Exception e ) {
	        e.printStackTrace();
	    }
	}
	public void ajouterUtilProf(Utilisateur u,int id_prof) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps;
	    try {
	        ps=conn.prepareStatement("INSERT INTO utilisateur(email,mdp,role,id_prof ) VALUES(?, ?, ?, ?);");
	        ps.setString(1, u.getEmail());
	        ps.setString(2, u.getMdp());
	        ps.setString(3,u.getRole() );
	        ps.setInt(4, id_prof);
	        ps.executeUpdate();
	    }catch(Exception e ) {
	        e.printStackTrace();
	    }
	}
	public boolean checkUtil(Utilisateur u) {
		boolean lbool = false ;
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps;
	    try {
	        ps=conn.prepareStatement("select * from utilisateur where email =? and mdp=?");
	        ps.setString(1, u.getEmail());
	        ps.setString(2, u.getMdp());
	        
	        ResultSet rs = ps.executeQuery();
	        lbool =rs.next();
	    }catch(Exception e ) {
	        e.printStackTrace();
	    }
	            return lbool ;
	}
	public String getRole(Utilisateur u) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps ;
	    String role =null;
	    try {
	        ps = conn.prepareStatement("select role from utilisateur where email=? and mdp=? ");
	        ps.setString(1, u.getEmail());
	        ps.setString(2, u.getMdp());
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            role = rs.getString("role");
	        }
	    }catch (Exception e) {
	        // TODO: handle exception
	    }
	    return role ;
	}
	public int getidEtu(Utilisateur u) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps ;
	    int id_etu =0;
	    try {
	        ps = conn.prepareStatement("select id_etu from utilisateur where email=? and mdp=? ");
	        ps.setString(1, u.getEmail());
	        ps.setString(2, u.getMdp());
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            id_etu = rs.getInt("id_etu");
	        }
	    }catch (Exception e) {
	        // TODO: handle exception
	    }
	    return id_etu ;
	}
	public int getidProf(Utilisateur u) {
	    Connection conn = SingletonConnection.getConnection();
	    PreparedStatement ps ;
	    int id_etu =0;
	    try {
	        ps = conn.prepareStatement("select id_prof from utilisateur where email=? and mdp=? ");
	        ps.setString(1, u.getEmail());
	        ps.setString(2, u.getMdp());
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            id_etu = rs.getInt("id_prof");
	        }
	    }catch (Exception e) {
	        // TODO: handle exception
	    }
	    return id_etu ;
	}
	}

