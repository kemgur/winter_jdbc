package winter_jdbc_tutoring;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExecuteQuery02 {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
		
		Statement st = con.createStatement();
		
		//Select country_ids and country_names whose region_id is less than 3
		String q1 = "SELECT country_id, country_name FROM countries WHERE region_id < 3";
		ResultSet rs1 = st.executeQuery(q1);
		
		while(rs1.next()) {
			System.out.println(rs1.getString(1) + " - " + rs1.getString(2));
		}
		
		//Select second highest salary from employees table
		String q2 = "SELECT salary FROM employees ORDER BY salary DESC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY";
		ResultSet rs2 = st.executeQuery(q2);
		
		while(rs2.next()) {
			System.out.println(rs2.getInt("SALARY"));
		}
		
		//Select all data about the worker who has third lowest salary
		String q3 = "SELECT * FROM employees ORDER BY salary ASC OFFSET 2 ROW FETCH NEXT 1 ROW ONLY";
		ResultSet rs3 = st.executeQuery(q3);
		
		while(rs3.next()) {
			System.out.println(rs3.getInt(1) + " - " + rs3.getString(2) + " - " + rs3.getString(3) + " - " + rs3.getString(4)
							   + " - " + rs3.getString(5) + " - " + rs3.getDate(6) + " - " + rs3.getString(7)  
							   + " - " + rs3.getInt(8) + " - " + rs3.getInt(9) + " - " + rs3.getInt(10) + " - " + rs3.getInt(11));
		}

		con.close();
		st.close();
		rs1.close();
		rs2.close();
		rs3.close();

	}

}