package model;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;

import model.Economy;


public class EconomyTest 
{
    
	Economy e;
	
	@Before
	public void setUp() {
		e = new Economy();
	}
	
    @Test
    public void priceAuth()
    {
    	int price = 500;
    	e.setPrice(price);
        assertEquals(e.getPrice(), price);
    }
    
    @Test
    public void seatCountAuth()
    {
        int seatCount = 3;
        e.setSeatCount(seatCount);
        assertEquals(e.getSeatCount(), seatCount);
    }
    
    @Test
    public void nameAuth()
    {
        assertEquals(e.getName(), "ECONOMY");
    }
    
}
