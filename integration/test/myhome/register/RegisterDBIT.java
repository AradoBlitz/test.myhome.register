package test.myhome.register;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegisterDBIT {

	@Test 
	public void getDataFromStorage() throws Exception{
		MonthPayment monthPayment = new MonthPayment();
		monthPayment.readPayment();
		assertEquals("Rent should be provided.", 3500, monthPayment.rent);
	}
}
