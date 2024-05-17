package com.example.travel_app;

// WebBrowserStrategy.java
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class WebBrowserStrategy implements IMapOpeningStrategy {
    private Context context;

    public WebBrowserStrategy(Context context) {
        this.context = context;
    }

    @Override
    public void openMap(String source) {
        Uri webUri = Uri.parse("https://www.google.com/maps/dir/" + source);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
        context.startActivity(webIntent);
    }
}
