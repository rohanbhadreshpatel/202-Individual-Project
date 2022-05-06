package validation;

import static org.junit.Assert.*;
import org.junit.*;


import org.junit.Test;

import validation.Amex;


public class AmexTest 
{

	Amex amx;
	
	@Before
	public void setUp() {
		amx = new Amex(null);
	}
	
    @Test
    public void amexAuth()
    {	String cNum = "370118041386780";
    	boolean isAmex = amx.auth(cNum);
    	assertEquals(isAmex, true);
        System.out.println("AUTHENTIC AMEX CARD NUMBER: " +cNum);
    }
    
    @Test
    public void unauthenticAmex()
    {	String cNum = "390118041386780";
    	boolean isAmex = amx.auth(cNum);
    	assertEquals(isAmex, false);
        System.out.println("--------INVALID AMEX CARD: " +cNum);
    }
    
}
