package validation;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;

import validation.MasterCard;


public class MasterCardTest 
{
    
	MasterCard mstr;
	
	@Before
	public void setUp() {
		mstr = new MasterCard(null);
	}
	
    @Test
    public void MasterCardAuth()
    {	String cNum = "5380118041386780";
    	boolean isMaster = mstr.auth(cNum);
    	assertEquals(isMaster, true);
        System.out.println("AUTHENTIC MASTERCARD NUMBER: " +cNum);
    }
    
    @Test
    public void unauthenticMasterCard()
    {	String cNum = "80118041386780";
    	boolean isMaster = mstr.auth(cNum);
    	assertEquals(isMaster, false);
        System.out.println("--------INVALID MASTER CARD: " +cNum);
    }
    
}
