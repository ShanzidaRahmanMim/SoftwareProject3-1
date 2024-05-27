package com.example.travel_app.Domains;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Unit tests for the {@link CategoryDomain} class.
 * This class tests the getter and setter methods for the title and picture path properties.
 *
 * @version 1.0
 * @since 2024-05-27
 *
 * @see CategoryDomain
 * @see junit.framework.TestCase
 * @see org.junit.Before
 * @see org.junit.Test
 *
 * @author Hafsa Tazrian
 */

public class CategoryDomainTest extends TestCase {
    private CategoryDomain categoryDomain;

    /**
     * Sets up the test environment before each test.
     * Initializes a new {@link CategoryDomain} instance with a title and picture path.
     */
    @Before
    public void setUp() {
        categoryDomain = new CategoryDomain("Beach", "/images/beach.jpg");
    }

    /**
     * Tests the {@link CategoryDomain#getTitle()} method.
     * Verifies that the initial title is correctly returned.
     */
    @Test
    public void testGetTitle() {
        assertEquals("Beach", categoryDomain.getTitle());
    }

    /**
     * Tests the {@link CategoryDomain#setTitle(String)} method.
     * Verifies that the title can be updated and retrieved correctly.
     */
    @Test
    public void testSetTitle() {
        categoryDomain.setTitle("Mountain");
        assertEquals("Mountain", categoryDomain.getTitle());
    }

    /**
     * Tests the {@link CategoryDomain#getPicPath()} method.
     * Verifies that the initial picture path is correctly returned.
     */
    @Test
    public void testGetPicPath() {
        assertEquals("/images/beach.jpg", categoryDomain.getPicPath());
    }

    /**
     * Tests the {@link CategoryDomain#setPicPath(String)} method.
     * Verifies that the picture path can be updated and retrieved correctly.
     */
    @Test
    public void testSetPicPath() {
        categoryDomain.setPicPath("/images/mountain.jpg");
        assertEquals("/images/mountain.jpg", categoryDomain.getPicPath());
    }

    /**
     * Tests setting the title to null.
     * Verifies that the title can be set to null and retrieved as null.
     */
    @Test
    public void testSetTitleToNull() {
        categoryDomain.setTitle(null);
        assertNull(categoryDomain.getTitle());
    }

    /**
     * Tests setting the picture path to null.
     * Verifies that the picture path can be set to null and retrieved as null.
     */
    @Test
    public void testSetPicPathToNull() {
        categoryDomain.setPicPath(null);
        assertNull(categoryDomain.getPicPath());
    }

    /**
     * Tests setting the title to an empty string.
     * Verifies that the title can be set to an empty string and retrieved correctly.
     */
    @Test
    public void testSetTitleToEmptyString() {
        categoryDomain.setTitle("");
        assertEquals("", categoryDomain.getTitle());
    }

    /**
     * Tests setting the picture path to an empty string.
     * Verifies that the picture path can be set to an empty string and retrieved correctly.
     */
    @Test
    public void testSetPicPathToEmptyString() {
        categoryDomain.setPicPath("");
        assertEquals("", categoryDomain.getPicPath());
    }

    /**
     * Tests setting the title to a very long string.
     * Verifies that the title can be set to a very long string and retrieved correctly.
     */
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

    /**
     * Tests setting the picture path to a very long string.
     * Verifies that the picture path can be set to a very long string and retrieved correctly.
     */
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

    /**
     * Tests setting the title to a string containing special characters.
     * Verifies that the title can be set to a string with special characters and retrieved correctly.
     */
    @Test
    public void testSetTitleToSpecialCharacters() {
        String specialTitle = "!@#$%^&*()_+";
        categoryDomain.setTitle(specialTitle);
        assertEquals(specialTitle, categoryDomain.getTitle());
    }

    /**
     * Tests setting the picture path to a string containing special characters.
     * Verifies that the picture path can be set to a string with special characters and retrieved correctly.
     */
    @Test
    public void testSetPicPathToSpecialCharacters() {
        String specialPicPath = "/images/!@#$%^&*()_+.jpg";
        categoryDomain.setPicPath(specialPicPath);
        assertEquals(specialPicPath, categoryDomain.getPicPath());
    }
}