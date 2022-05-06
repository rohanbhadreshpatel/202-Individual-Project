package validation;

import static org.junit.Assert.*;
import org.junit.*;


import org.junit.Test;

import validation.Discover;


public class DiscoverTest {

    Discover dscvr;

    @Before
    public void setUp() {
        dscvr = new Discover(null);
    }

    @Test
    public void discoverAuth() {
        String cNum = "6011449644964496";
        boolean isDiscover = dscvr.auth(cNum);
        assertEquals(isDiscover, true);
        System.out.println("AUTHENTIC DISCOVER CARD NUMBER: " +cNum);
    }

    @Test
    public void unauthenticDiscoverCard() {
        String cNum = "1811181118111811";
        boolean isDiscover = dscvr.auth(cNum);
        assertEquals(isDiscover, false);
        System.out.println("--------INVALID DISCOVER CARD: " +cNum);
    }
}
