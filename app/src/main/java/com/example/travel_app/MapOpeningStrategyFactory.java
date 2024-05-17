package com.example.travel_app;

// MapOpeningStrategyFactory.java
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class MapOpeningStrategyFactory {
    public static IMapOpeningStrategy createStrategy(Context context) {
        if (isGoogleMapsInstalled(context)) {
            return new GoogleMapsStrategy(context);
        } else {
            return new WebBrowserStrategy(context);
        }
    }

    private static boolean isGoogleMapsInstalled(Context context) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=New+York"));
        mapIntent.setPackage("com.google.android.apps.maps");
        return mapIntent.resolveActivity(context.getPackageManager()) != null;
    }
}
