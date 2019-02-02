package com.example.week4daily5test.view.activities.detailsactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4daily5test.R;
import com.example.week4daily5test.model.photo.Photo;

public class DetailsActivity extends AppCompatActivity implements DetailsActivityContract {

    DetailsActivityPresenter detailsActivityPresenter;
    ImageView photoDetailsImageView;
    TextView photoDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        photoDetailsImageView = findViewById(R.id.photoDetailsImageViewId);
        photoDetailsTextView = findViewById(R.id.photoDetailsTitleTextViewId);

        detailsActivityPresenter = new DetailsActivityPresenter(this);
        detailsActivityPresenter.getPhotoDetails(getIntent().getExtras());
    }

    @Override
    public void sendToActivity(Photo aPhoto) {

        Glide.with(photoDetailsImageView)
                .load("https://farm"+ aPhoto.getFarm() +".staticflickr.com/" + aPhoto.getServer() + "/" + aPhoto.getId() +"_" + aPhoto.getSecret() +"_q.jpg")
                .into(photoDetailsImageView);

        photoDetailsTextView.setText(aPhoto.getTitle());

    }
}
