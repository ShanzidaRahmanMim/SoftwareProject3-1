package com.example.travel_app;

/**
 * Represents an Info object with name and phone.
 * This class is used to store contact information.
 *
 * @author Mim
 */
public class Info {
    public String namee;
    public String phonee;

    /**
     * Default constructor.
     * Initializes name and phone to null.
     */
    public Info() {
    }

    /**
     * Parameterized constructor.
     *
     * @param name  the name to set
     * @param phone the phone to set
     */
    public Info(String name, String phone) {
        this.namee = name;
        this.phonee = phone;
    }
}
