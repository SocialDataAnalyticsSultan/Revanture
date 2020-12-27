package test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Connection connection = null;
		try {
			//Step 1 - Load Driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded successfully...");
			
			
			//Step 2 - Open connection (url, username, password)
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String userName = "postgres";
			String password = "Sultan_134062";
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connect successfully...");
			
			//Step 3 - Create Statement
			Statement statement = connection.createStatement();
			String sql = "select employee_id, first_name, last_name, email, gender, date_of_birth, "
					+ "country, state, city, street, cellphone, department_id from my_company.employee_info";
			
			//Step 4 - Execute Query
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("Query Executed...");
			
			//Process Results
			while(resultSet.next()) {
				System.out.print("Id: " + resultSet.getInt("employee_id") + "    ");
				System.out.print("Name: " + resultSet.getString("first_name")+ "    ");
				System.out.println();
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				
				//Step 6 - Close Connection
				connection.close();
				System.out.println("Connection Closed successfully...");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
