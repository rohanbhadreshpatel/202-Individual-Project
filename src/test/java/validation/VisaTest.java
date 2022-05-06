package validation;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;

import validation.Visa;


public class VisaTest 
{
   
	Visa vsa;
	
	@Before
	public void setUp() {
		vsa = new Visa(null);
	}
	
    @Test
    public void visaAuth()
    {	String cNum = "4815481548154";
    	boolean isVisa = vsa.auth(cNum);
    	assertEquals(isVisa, true);
        System.out.println("AUTHENTIC VISA CARD NUMBER: " +cNum);
    }
    
    @Test
    public void unauthenticVisa()
    {	String cardNumber = "8815481548154";
    	boolean isVisaCard = vsa.auth(cardNumber);
    	assertEquals(isVisaCard, false);
        System.out.println("--------INVALID VISA CARD: " +cardNumber);
    }
    
}
