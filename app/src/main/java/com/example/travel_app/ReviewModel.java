package com.example.travel_app;



import android.content.Context;
import android.content.SharedPreferences;

public class ReviewModel {
    private static final String PREF_NAME = "ReviewPrefs";
    private static final String PREF_KEY_RATING = "rating";
    private static final String PREF_KEY_COMMENT = "comment";
    private static ReviewModel instance;
    private SharedPreferences sharedPreferences;

    private ReviewModel(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static ReviewModel getInstance(Context context) {
        if (instance == null) {
            instance = new ReviewModel(context);
        }
        return instance;
    }

    public void saveReview(float rating, String comment) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(PREF_KEY_RATING, rating);
        editor.putString(PREF_KEY_COMMENT, comment);
        editor.apply();
    }

    public ReviewData loadReview() {
        float rating = sharedPreferences.getFloat(PREF_KEY_RATING, 0);
        String comment = sharedPreferences.getString(PREF_KEY_COMMENT, "");
        return new ReviewData(rating, comment);
    }
}
