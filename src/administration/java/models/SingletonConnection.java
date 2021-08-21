package administration.java.models;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class SingletonConnection {
	private static Connection connection;
	static {
		String url="jdbc:mysql://localhost:3306/administration?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "Aminedugheto31";
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =  DriverManager.getConnection(url, user, password);
		System.out.println("connection etablie !!!");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
	
}
