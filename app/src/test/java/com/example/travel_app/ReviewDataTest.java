package com.example.travel_app;
//review datatest samiha commit 

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ReviewDataTest {

    @Test
    public void testReviewData() {
        // Create an instance of ReviewData with a sample rating and comment
        float expectedRating = 4.5f;
        String expectedComment = "Great experience!";
        ReviewData review = new ReviewData(expectedRating, expectedComment);

        // Assert that the values are correctly set by the constructor
        assertEquals(expectedRating, review.getRating(), "Rating should match the constructor input");
        assertEquals(expectedComment, review.getComment(), "Comment should match the constructor input");
    }

    // Test for handling null comments
    @Test
    public void testNullComment() {
        // Create an instance of ReviewData with a null comment
        float rating = 3.5f;
        ReviewData review = new ReviewData(rating, null);

        // Assert that the comment is null
        assertEquals(null, review.getComment(), "Comment should handle null inputs without crashing");
    }

    // Test for handling empty comments
    @Test
    public void testEmptyComment() {
        // Create an instance of ReviewData with an empty string as comment
        float rating = 5.0f;
        ReviewData review = new ReviewData(rating, "");

        // Assert that the empty string is correctly handled
        assertEquals("", review.getComment(), "Comment should be empty");
    }
}

