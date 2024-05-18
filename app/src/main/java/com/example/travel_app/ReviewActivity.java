package com.example.travel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

//Singleton

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * The ReviewActivity class handles the review interface where users can submit and view their ratings and comments.
 * Implements the ReviewView interface to handle the display of review data and toasts.
 *
 * @author Samiha
 */
public class ReviewActivity extends AppCompatActivity implements ReviewView {
    Button submitButton;
    RatingBar ratingBar;
    EditText commentEditText;
    ImageView imageView;
    ReviewPresenter presenter;

    /**
     * Called when the activity is first created.
     * Initializes the UI elements and sets up the presenter.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        EdgeToEdge.enable(this);
        setupWindowInsets();

        ratingBar = findViewById(R.id.ratingBar);
        commentEditText = findViewById(R.id.commentEditText);
        submitButton = findViewById(R.id.submitButton);
        imageView = findViewById(R.id.backgroundImage);
        presenter = ReviewPresenter.getInstance(this);
        presenter.attachView(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                String comment = commentEditText.getText().toString();
                presenter.onSubmitButtonClick(rating, comment);
            }
        });

        presenter.loadReviewData();
    }

    /**
     * Sets up the window insets to ensure proper padding.
     */
    private void setupWindowInsets() {
        View reviewLayout = findViewById(R.id.reviewLayout);
        if (reviewLayout != null) {
            ViewCompat.setOnApplyWindowInsetsListener(reviewLayout, (view, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        } else {
            Toast.makeText(this, "Review Layout is not found!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Displays the review data by setting the rating and comment in the UI.
     *
     * @param rating The rating to display.
     * @param comment The comment to display.
     */
    @Override
    public void displayReviewData(float rating, String comment) {
        ratingBar.setRating(rating);
        commentEditText.setText(comment);
    }

    /**
     * Shows a toast message.
     *
     * @param message The message to show in the toast.
     */
    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
