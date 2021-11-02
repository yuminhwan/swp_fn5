package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

public class VillageWeatherDAO {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3308/test?serverTimezone=UTC"; 
	static final String USERNAME = "hos"; 
	static final String PASSWORD = "123"; 

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public void intertVillageWeather(int id, VillageWeather v) {
		
		String query = "INSERT INTO hospital"
				+ " VALUE(" + id +",'" + v.getHospital_name() + "','" + v.getHospital_category() + "','" + v.getHospital_location() + "','" + v.getHospital_tel()+"','"
				+v.getHospital_M() +"','" + v.getHospital_Tu() + "','" + v.getHospital_W() + "','" + v.getHospital_Th()  + "','" + v.getHospital_F() 
				+ "','" + v.getHospital_Sa() + "','" + v.getHospital_Su() + "','" + v.getHospital_H() +"');";
		System.out.print("YourWeather Database ���� : ");
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); 
			
			if (conn != null){System.out.println("����");}
			else{System.out.println("����");}
			
			System.out.println(query); 
			
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		    stmt.close();
		    conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exection");
		} catch (SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage());
		}
	}

}