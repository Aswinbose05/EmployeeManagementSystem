package Employer.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
	Connection connection;
	Statement statement;
	
	public conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String password;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","3005");
			statement=connection.createStatement();
		}catch(Exception E) {
			E.printStackTrace(); 
			
		}
	}
}
