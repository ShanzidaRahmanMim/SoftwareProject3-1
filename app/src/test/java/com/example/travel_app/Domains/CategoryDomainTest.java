package com.example.travel_app.Domains;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * @author Hafsa Tazrian
 */

public class CategoryDomainTest extends TestCase {
    private CategoryDomain categoryDomain;

    @Before
    public void setUp() {
        categoryDomain = new CategoryDomain("Beach", "/images/beach.jpg");
    }

    @Test
    public void testGetTitle() {
        assertEquals("Beach", categoryDomain.getTitle());
    }

    @Test
    public void testSetTitle() {
        categoryDomain.setTitle("Mountain");
        assertEquals("Mountain", categoryDomain.getTitle());
    }

    @Test
    public void testGetPicPath() {
        assertEquals("/images/beach.jpg", categoryDomain.getPicPath());
    }

    @Test
    public void testSetPicPath() {
        categoryDomain.setPicPath("/images/mountain.jpg");
        assertEquals("/images/mountain.jpg", categoryDomain.getPicPath());
    }

    @Test
    public void testSetTitleToNull() {
        categoryDomain.setTitle(null);
        assertNull(categoryDomain.getTitle());
    }

    @Test
    public void testSetPicPathToNull() {
        categoryDomain.setPicPath(null);
        assertNull(categoryDomain.getPicPath());
    }

    @Test
    public void testSetTitleToEmptyString() {
        categoryDomain.setTitle("");
        assertEquals("", categoryDomain.getTitle());
    }

    @Test
    public void testSetPicPathToEmptyString() {
        categoryDomain.setPicPath("");
        assertEquals("", categoryDomain.getPicPath());
    }

    @Test
    public void testSetTitleToVeryLongString() {
        StringBuilder longTitleBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longTitleBuilder.append("a");
        }
        String longTitle = longTitleBuilder.toString();
        categoryDomain.setTitle(longTitle);
        assertEquals(longTitle, categoryDomain.getTitle());
    }

    @Test
    public void testSetPicPathToVeryLongString() {
        StringBuilder longPicPathBuilder = new StringBuilder("/images/");
        for (int i = 0; i < 1000; i++) {
            longPicPathBuilder.append("a");
        }
        longPicPathBuilder.append(".jpg");
        String longPicPath = longPicPathBuilder.toString();
        categoryDomain.setPicPath(longPicPath);
        assertEquals(longPicPath, categoryDomain.getPicPath());
    }

    @Test
    public void testSetTitleToSpecialCharacters() {
        String specialTitle = "!@#$%^&*()_+";
        categoryDomain.setTitle(specialTitle);
        assertEquals(specialTitle, categoryDomain.getTitle());
    }

    @Test
    public void testSetPicPathToSpecialCharacters() {
        String specialPicPath = "/images/!@#$%^&*()_+.jpg";
        categoryDomain.setPicPath(specialPicPath);
        assertEquals(specialPicPath, categoryDomain.getPicPath());
    }
}