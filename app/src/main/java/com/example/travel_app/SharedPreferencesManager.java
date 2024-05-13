package com.example.travel_app;

import android.content.Context;
import android.content.SharedPreferences;


//Singleton applied!!!
public class SharedPreferencesManager {
    private static final String SHARED_PREF_NAME = "MySharedPref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    private static SharedPreferencesManager instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    // Private constructor to prevent instantiation from other classes
    private SharedPreferencesManager(Context context) {
        this.context = context.getApplicationContext();  // Use application context to avoid memory leaks
        sharedPreferences = this.context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // Singleton method to get the instance
    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesManager(context);
        }
        return instance;
    }

    public void saveLoginDetails(String username) {
        editor.putString(KEY_USERNAME, username);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, null);
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void clear() {
        editor.clear();
        editor.apply();
    }
}
