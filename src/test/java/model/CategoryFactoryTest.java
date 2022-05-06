package model;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;
import type.Category;


public class CategoryFactoryTest
{

    CategoryFactory cF;

    @Before
    public void setUp() {
        cF = new CategoryFactory();
    }

    @Test
    public void authBusinessCategory()
    {
        Category obj = cF.create("BUSINESS");
        assertEquals(obj.getName(), "BUSINESS");
        System.out.println("---------------- "+obj.getName()+".");
    }

    @Test
    public void authEconomyCategory()
    {
        Category obj = cF.create("ECONOMY");
        assertEquals(obj.getName(), "ECONOMY");
        System.out.println("---------------- "+obj.getName()+".");
    }

    @Test
    public void authPremiumEconomyCategory()
    {
        Category obj = cF.create("PREMIUM ECONOMY");
        assertEquals(obj.getName(), "PREMIUM ECONOMY");
        System.out.println("---------------- "+obj.getName()+".");
    }

    @Test
    public void nullifyBusinessCategory()
    {
        Category obj = cF.create("BUSINESS");
        assertNotEquals(obj.getName(), "PREMIUM ECONOMY");
        System.out.println("---------------- "+obj.getName()+", PLEASE TRY AGAIN.");
    }

    @Test
    public void nullifyEconomyCategory()
    {
        Category obj = cF.create("ECONOMY");
        assertNotEquals(obj.getName(), "BUSINESS");
        System.out.println("---------------- "+obj.getName()+", PLEASE TRY AGAIN.");
    }

    @Test
    public void nullifyPremiumEconomyCategory()
    {
        Category obj = cF.create("PREMIUM ECONOMY");
        assertNotEquals(obj.getName(), "ECONOMY");
        System.out.println("---------------- "+obj.getName()+", PLEASE TRY AGAIN.");
    }

}