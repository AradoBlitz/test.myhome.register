package test.myhome.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MonthPayment {

	public int rent = 3500;

	public void readPayment() throws Exception {
	
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/seconddb;create=true");
		try{
			Statement stmt = conn.createStatement();
			try{
				stmt.execute("create table rent (rent integer)");
				String strRent = "" + rent;
				Connection conn1 = DriverManager.getConnection("jdbc:derby://localhost:1527/seconddb;create=true");
				try{
					Statement stmt1 = conn1.createStatement();
					try{
				
						stmt.execute("insert into rent (rent) values("  + strRent + ")");
						ResultSet result = stmt.executeQuery("select * from rent");
						result.next();
						rent = result.getInt(1);
					}finally{
						stmt1.close();
					}
				}finally{
					conn1.close();
				}
			}finally{
				try{
					stmt.execute("drop table rent");
				}finally{
					stmt.close();
				}
			}
		}finally{
			conn.close();
		}
	}

}
