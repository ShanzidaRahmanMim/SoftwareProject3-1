package com.example.travel_app.Domains;

import com.example.travel_app.Domains.PopularDomain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PopularDomainTest {

    private PopularDomain popularDomain;

    @Before
    public void setUp() {
        popularDomain = new PopularDomain("Beach Resort", "Maldives", "Beautiful beach resort", "King Size", true, 9.5, "beach_resort.jpg", true, 500);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Beach Resort", popularDomain.getTitle());
    }

    @Test
    public void testSetTitle() {
        popularDomain.setTitle("Mountain Resort");
        assertEquals("Mountain Resort", popularDomain.getTitle());
    }

    @Test
    public void testGetLocation() {
        assertEquals("Maldives", popularDomain.getLocation());
    }

    @Test
    public void testSetLocation() {
        popularDomain.setLocation("Switzerland");
        assertEquals("Switzerland", popularDomain.getLocation());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Beautiful beach resort", popularDomain.getDescription());
    }

    @Test
    public void testSetDescription() {
        popularDomain.setDescription("Scenic mountain resort");
        assertEquals("Scenic mountain resort", popularDomain.getDescription());
    }

    @Test
    public void testGetBed() {
        assertEquals("King Size", popularDomain.getBed());
    }

    @Test
    public void testSetBed() {
        popularDomain.setBed("Queen Size");
        assertEquals("Queen Size", popularDomain.getBed());
    }

    @Test
    public void testIsGuide() {
        assertTrue(popularDomain.isGuide());
    }
      @Test
    public void testGetScore() {
        assertEquals(9.5, popularDomain.getScore(), 0.0);
    }

    @Test
    public void testSetScore() {
        popularDomain.setScore(8.7);
        assertEquals(8.7, popularDomain.getScore(), 0.0);
    }

    @Test
    public void testGetPic() {
        assertEquals("beach_resort.jpg", popularDomain.getPic());
    }

    @Test
    public void testSetPic() {
        popularDomain.setPic("mountain_resort.jpg");
        assertEquals("mountain_resort.jpg", popularDomain.getPic());
    }

    @Test
    public void testIsWifi() {
        assertTrue(popularDomain.isWifi());
    }

    @Test
    public void testSetWifi() {
        popularDomain.setWifi(false);
        assertEquals(false, popularDomain.isWifi());
    }

    @Test
    public void testGetPrice() {
        assertEquals(500, popularDomain.getPrice());
    }

    @Test
    public void testSetPrice() {
        popularDomain.setPrice(700);
        assertEquals(700, popularDomain.getPrice());
    }

}