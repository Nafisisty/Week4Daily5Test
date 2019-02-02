package com.example.week4daily5test.view.activities.detailsactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.week4daily5test.model.photo.Photo;

public class DetailsActivityPresenter {

    DetailsActivityContract detailsActivityContract;

    public DetailsActivityPresenter(DetailsActivityContract detailsActivityContract) {
        this.detailsActivityContract = detailsActivityContract;
    }

    public void getPhotoDetails(@NonNull Bundle aBundle) {

        Photo photo = aBundle.getParcelable("selectedPhoto");
        detailsActivityContract.sendToActivity(photo);

    }
}
