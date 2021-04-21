package winter_jdbc_tutoring;

//1.Step: Import the sql package
import java.sql.*;
public class JdbcExecuteQuery01 {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//2.Step: Register to the oracle driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//3.Step: Establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
		
		//4.Step: Create a statement
		Statement st = con.createStatement();
		
		//5.Step:Execute query and store the result
		ResultSet rs = st.executeQuery("SELECT * FROM countries");
		
		//6.Step:Process the result
		while(rs.next()) {
			System.out.println(rs.getString(1) + " - " + rs.getString(2)  + " - " + rs.getInt(3));
		}
		
		//7.Step: Close connection, statement, ResultSet
		con.close();
		st.close();
		rs.close();
	
	}

}