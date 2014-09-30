package test.myhome.register;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class RegisterDBIT {

	@Test 
	public void getDataFromStorage() throws Exception{
		MonthPayment monthPayment = new MonthPayment();
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/seconddb;create=true");
		try{
			Statement stmt = conn.createStatement();
			try{
				stmt.execute("create table rent (rent integer)");
				String strRent = "" + monthPayment.rent;
		
				stmt.execute("insert into rent (rent) values("  + strRent + ")");
				monthPayment.readPayment();
			}finally{
				
				stmt.close();
				
			}
		}finally{
			conn.close();
		}
	
		assertEquals("Rent should be provided.", 3500, monthPayment.rent);
	}
}
