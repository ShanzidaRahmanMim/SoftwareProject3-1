package com.example.travel_app;


import android.content.Context;
import android.widget.Toast;

public class ReviewPresenter {
    private ReviewView view;
    private static ReviewPresenter instance;
    private Context context;
    private ReviewModel model;

    private ReviewPresenter(Context context) {
        this.context = context;
        this.model = ReviewModel.getInstance(context);
    }

    public static ReviewPresenter getInstance(Context context) {
        if (instance == null) {
            instance = new ReviewPresenter(context);
        }
        return instance;
    }

    public void attachView(ReviewView view) {
        this.view = view;
    }

    public void onSubmitButtonClick(float rating, String comment) {
        model.saveReview(rating, comment);
        if (view != null) {
            view.showToast("Review saved successfully.");
        }
    }

    public void loadReviewData() {
        ReviewData reviewData = model.loadReview();
        if (view != null) {
            view.displayReviewData(reviewData.getRating(), reviewData.getComment());
        }
    }
}
