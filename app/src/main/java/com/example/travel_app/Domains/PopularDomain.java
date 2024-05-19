package com.example.travel_app.Domains;

import java.io.Serializable;

/**
 * A class representing popular travel destinations.
 * @author samiha
 */

public class PopularDomain implements Serializable {
    private String title;
    private String location;
    private String description;
    private String bed;
    public boolean guide;
    private double score;
    private String pic;
    private boolean wifi;
    private int price;

    /**
     * Constructs a new PopularDomain object with the given parameters.
     *
     * @param title       The title of the destination.
     * @param location    The location of the destination.
     * @param description The description of the destination.
     * @param bed         The type of bed available at the destination.
     * @param guide       Indicates if a guide is available for the destination.
     * @param score       The rating score of the destination.
     * @param pic         The picture URL of the destination.
     * @param wifi        Indicates if Wi-Fi is available at the destination.
     * @param price       The price of the destination.
     */
    public PopularDomain(String title, String location, String description, String bed, boolean guide, double score, String pic, boolean wifi, int price) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.bed = bed;
        this.guide = guide;
        this.score = score;
        this.pic = pic;
        this.wifi = wifi;
        this.price = price;
    }

    /**
     * Gets the title of the destination.
     *
     * @return The title of the destination.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the destination.
     *
     * @param title The title of the destination.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the location of the destination.
     *
     * @return The location of the destination.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the destination.
     *
     * @param location The location of the destination.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the description of the destination.
     *
     * @return The description of the destination.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the destination.
     *
     * @param description The description of the destination.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the type of bed available at the destination.
     *
     * @return The type of bed available at the destination.
     */
    public String getBed() {
        return bed;
    }

    /**
     * Sets the type of bed available at the destination.
     *
     * @param bed The type of bed available at the destination.
     */
    public void setBed(String bed) {
        this.bed = bed;
    }

    /**
     * Checks if a guide is available for the destination.
     *
     * @return True if a guide is available, false otherwise.
     */
    public boolean isGuide() {
        return guide;
    }

    /**
     * Sets whether a guide is available for the destination.
     *
     * @param guide True if a guide is available, false otherwise.
     */
    public void setGuide(boolean guide) {
        this.guide = guide;
    }

    /**
     * Gets the rating score of the destination.
     *
     * @return The rating score of the destination.
     */
    public double getScore() {
        return score;
    }

    /**
     * Sets the rating score of the destination.
     *
     * @param score The rating score of the destination.
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Gets the picture URL of the destination.
     *
     * @return The picture URL of the destination.
     */
    public String getPic() {
        return pic;
    }

    /**
     * Sets the picture URL of the destination.
     *
     * @param pic The picture URL of the destination.
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * Checks if Wi-Fi is available at the destination.
     *
     * @return True if Wi-Fi is available, false otherwise.
     */
    public boolean isWifi() {
        return wifi;
    }

    /**
     * Sets whether Wi-Fi is available at the destination.
     *
     * @param wifi True if Wi-Fi is available, false otherwise.
     */
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    /**
     * Gets the price of the destination.
     *
     * @return The price of the destination.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the destination.
     *
     * @param price The price of the destination.
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
