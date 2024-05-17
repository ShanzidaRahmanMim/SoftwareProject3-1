package com.example.travel_app;

// GoogleMapsStrategy.java
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class GoogleMapsStrategy implements IMapOpeningStrategy {
    private Context context;

    public GoogleMapsStrategy(Context context) {
        this.context = context;
    }

    @Override
    public void openMap(String source) {
        Uri uri = Uri.parse("https://www.google.com/maps/dir/" + source);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            openMapInBrowser(source);
        }
    }

    private void openMapInBrowser(String source) {
        Uri webUri = Uri.parse("https://www.google.com/maps/dir/" + source);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
        context.startActivity(webIntent);
    }
}
