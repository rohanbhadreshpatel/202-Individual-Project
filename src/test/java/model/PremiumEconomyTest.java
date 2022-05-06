package model;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;

import model.PremiumEconomy;


public class PremiumEconomyTest 
{
   
	PremiumEconomy pE;
	
	@Before
	public void setUp() {
		pE = new PremiumEconomy();
	}
	
    @Test
    public void priceAuth()
    {
    	int price = 1000;
    	pE.setPrice(price);
        assertEquals(pE.getPrice(), price);
    }
    
    @Test
    public void seatCountAuth()
    {
        int seatCount = 3;
        pE.setSeatCount(seatCount);
        assertEquals(pE.getSeatCount(), seatCount);
    }
    
    @Test
    public void nameAuth()
    {
        assertEquals(pE.getName(), "PREMIUM ECONOMY");
    }

    
}
