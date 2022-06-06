package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.insurance.Insurance;

public class Dao {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void connect() {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/insurance_system?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public boolean create(String query) { //원칙적으로는 boolean 값을 가져야함
		//	"insert into insurance (user_name, user_phoneno, isAccepted) values ('test', 'test', 1);"
		try {
			statement = connect.createStatement();
			if (!statement.execute(query)) {
				System.out.println("insert OK!!!");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
//	public void create(String query) { //원칙적으로는 boolean 값을 가져야함
////		"insert into insurance (user_name, user_phoneno, isAccepted) values ('test', 'test', 1);"
//		try {
//			statement = connect.createStatement();
//			if (!statement.execute(query)) System.out.println("insert OK!!!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void update(String query) { //원칙적으로는 boolean 값을 가져야함
//	}
//	
//	public void delete(String query) { //원칙적으로는 boolean 값을 가져야함
//	}
//	
//	public ResultSet retrieve(String query) {
//		try {
//			statement = connect.createStatement();
//			resultSet = statement.executeQuery(query);
//			return resultSet;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return resultSet;
//	}
}
