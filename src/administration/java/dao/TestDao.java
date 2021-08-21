package administration.java.dao;

import java.sql.Connection;
import java.sql.Date;

import administration.java.models.*;

public class TestDao {
	public static void main(String[] args) {
		Connection conn = SingletonConnection.getConnection();
		GererSalleImpl gs = new GererSalleImpl();
	/*	professeur<String> e=new professeur<String>("amine","bouchakor","","bvcuyzb",53);
		GererProf_impl i=new GererProf_impl();
		i.ajouterProf(e); 
		System.out.println(gs.list2(new Date(2021, 14, 06),"creneau 1"));*/
		}
}
