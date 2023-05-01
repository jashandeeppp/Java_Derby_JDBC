package Assignment4;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Please use the links posted in week 9 folder on BB and any other resources you find based on your own research to install Apache derby db
 *  on your computer then make sure to establish a successful connection from your java application. 
 */
public class DerbyConnection {

	public static void main(String[] args) throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String derbyJdbcUrl = "jdbc:derby://localhost:1527/rpdb";
		Connection conn = DriverManager.getConnection(derbyJdbcUrl);
		Statement stmt = conn.createStatement();
		String insertSQL = "INSERT INTO RPDB.GAME VALUES ('ROCK','ROCK','TIE')";
		stmt.execute(insertSQL);
		
		ResultSet results = stmt.executeQuery("select * from rpdb.GAME");
		while(results.next()) {
			String clientGesture = results.getString(1);
			String serverGesture = results.getString(2);
			String result = results.getString(3);
			System.out.println(clientGesture+"\t\t"+serverGesture+"\t\t"+result);
		}
		results.close();
		stmt.close();
		conn.close();
	}
}
