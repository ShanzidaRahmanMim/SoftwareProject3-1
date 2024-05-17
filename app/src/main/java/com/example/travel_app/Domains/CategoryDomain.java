package com.example.travel_app.Domains;

/**
 * Represents a category in the travel application.
 * Each category has a title and a path to its associated picture.
 * <p>
 * This class is part of the domain layer of the application.
 * </p>
 *
 * @author Hafsa Tazrian
 */

public class CategoryDomain {

    /**
     * Constructs a new CategoryDomain object with the specified title and picture path.
     *
     * @param title the title of the category
     * @param picPath the path to the category's picture
     */
    private String title;private String picPath;

    public CategoryDomain(String title, String picPath) {
        this.title = title;
        this.picPath = picPath;
    }

    /**
     * Returns the title of the category.
     *
     * @return the title of the category
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the category.
     *
     * @param title the new title of the category
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the path to the category's picture.
     *
     * @return the path to the category's picture
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * Sets the path to the category's picture.
     *
     * @param picPath the new path to the category's picture
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}

