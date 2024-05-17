package com.example.travel_app;


import android.content.Context;
import android.widget.Toast;

public class ReviewPresenter {
    private ReviewView view;
    private ReviewModel model;

    private ReviewPresenter(Context context) {
        this.model = ReviewModel.getInstance(context);
    }

    public static ReviewPresenter getInstance(Context context) {
        return new ReviewPresenter(context);
    }

    public void onSubmitButtonClick(float rating, String comment) {
        model.saveReview(rating, comment);
        view.showToast("Review saved successfully.");
    }

    public void loadReviewData() {
        ReviewData reviewData = model.loadReview();
        view.displayReviewData(reviewData.getRating(), reviewData.getComment());
    }
}
