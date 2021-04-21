package winter_jdbc_tutoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecute01 {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
		
		Statement st = con.createStatement();
		
		//Create dwmo table which has demo_id (number), demo_name (String)
		String q0 = "DROP TABLE demo";
		boolean rs0 = st.execute(q0);
		
		String q1 = "CREATE TABLE demo(demo_id NUMBER(2), demo_name VARCHAR2(20))";
		boolean rs1 = st.execute(q1);
		
		String q3 = "INSERT INTO demo VALUES(101, 'First Demo')";
		st.executeUpdate(q3);
		
		System.out.println(rs1);
		
		con.close();
		st.close();
		
		//execute() method is used for DDL (Create , Drop)
		// executeUpdate() method is used to insert, update, delete
	}

}
