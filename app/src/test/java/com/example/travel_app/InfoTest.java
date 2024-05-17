package com.example.travel_app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Info class.
 * This class tests various scenarios for the Info class including default and parameterized constructors,
 * handling of empty and null values, and handling of special characters and long strings.
 *
 * @author Mim
 */
public class InfoTest {

    /**
     * Tests the default constructor of the Info class.
     * Ensures that name and phone are initialized to null.
     */
    @Test
    public void testDefaultConstructor() {
        Info info = new Info();
        assertNull("Name should be null", info.namee);
        assertNull("Phone should be null", info.phonee);
    }

    /**
     * Tests the parameterized constructor of the Info class.
     * Ensures that name and phone are set correctly.
     */
    @Test
    public void testParameterizedConstructor() {
        Info info = new Info("Mim", "1234567890");
        assertEquals("Name should be Mim", "Mim", info.namee);
        assertEquals("Phone should be 1234567890", "1234567890", info.phonee);
    }

    /**
     * Tests setting an empty name.
     * Ensures that the name is set to an empty string.
     */
    @Test
    public void testEmptyName() {
        Info info = new Info("", "1234567890");
        assertEquals("Name should be empty", "", info.namee);
    }

    /**
     * Tests setting an empty phone number.
     * Ensures that the phone number is set to an empty string.
     */
    @Test
    public void testEmptyPhone() {
        Info info = new Info("Mim", "");
        assertEquals("Phone should be empty", "", info.phonee);
    }

    /**
     * Tests setting a null name.
     * Ensures that the name is set to null.
     */
    @Test
    public void testNullName() {
        Info info = new Info(null, "1234567890");
        assertNull("Name should be null", info.namee);
    }

    /**
     * Tests setting a null phone number.
     * Ensures that the phone number is set to null.
     */
    @Test
    public void testNullPhone() {
        Info info = new Info("Mim", null);
        assertNull("Phone should be null", info.phonee);
    }

    /**
     * Tests setting a name with special characters.
     * Ensures that the name is set correctly.
     */
    @Test
    public void testNameSpecialCharacters() {
        Info info = new Info("!@#$%^&*()", "1234567890");
        assertEquals("Name should be !@#$%^&*()", "!@#$%^&*()", info.namee);
    }

    /**
     * Tests setting a phone number with special characters.
     * Ensures that the phone number is set correctly.
     */
    @Test
    public void testPhoneSpecialCharacters() {
        Info info = new Info("Mim", "!@#$%^&*()");
        assertEquals("Phone should be !@#$%^&*()", "!@#$%^&*()", info.phonee);
    }

    /**
     * Tests setting a long name.
     * Ensures that the name is set correctly.
     */
    @Test
    public void testLongName() {
        String longName = generateLongString('a', 1000);
        Info info = new Info(longName, "1234567890");
        assertEquals("Name should be a long string of 'a'", longName, info.namee);
    }

    /**
     * Tests setting a long phone number.
     * Ensures that the phone number is set correctly.
     */
    @Test
    public void testLongPhone() {
        String longPhone = generateLongString('1', 1000);
        Info info = new Info("Mim", longPhone);
        assertEquals("Phone should be a long string of '1'", longPhone, info.phonee);
    }

    /**
     * Tests setting both name and phone number with special characters.
     * Ensures that the name and phone number are set correctly.
     */
    @Test
    public void testNameAndPhoneSpecialCharacters() {
        Info info = new Info("NameWith!@#$", "PhoneWith!@#$");
        assertEquals("Name should be NameWith!@#$", "NameWith!@#$", info.namee);
        assertEquals("Phone should be PhoneWith!@#$", "PhoneWith!@#$", info.phonee);
    }

    /**
     * Generates a long string consisting of the specified character repeated the specified number of times.
     *
     * @param ch the character to repeat
     * @param length the number of times to repeat the character
     * @return a long string consisting of the specified character repeated the specified number of times
     */
    private String generateLongString(char ch, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
