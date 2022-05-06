package model;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;

import model.Business;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class BusinessTest 
{
	Business b;
	
	@Before
	public void setUp() {
		b = new Business();
	}

    @Test
    public void priceAuth()
    {
    	int price = 5000;
        b.setPrice(price);
        assertEquals(b.getPrice(), price);
    }
    
    @Test
    public void counterAuth()
    {
        int counter = 3;
        b.setSeatCount(counter);
        assertEquals(b.getSeatCount(), counter);
    }
    
    @Test
    public void nameAuth()
    {
        assertEquals(b.getName(), "BUSINESS");
    }

}
