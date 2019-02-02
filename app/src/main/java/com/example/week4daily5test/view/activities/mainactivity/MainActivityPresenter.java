package com.example.week4daily5test.view.activities.mainactivity;

import com.example.week4daily5test.model.photo.PhotoResponse;


public class MainActivityPresenter {

    MainActivityContract mainActivityContract;

    public MainActivityPresenter(MainActivityContract mainActivityContract) {
        this.mainActivityContract = mainActivityContract;
    }

    public void sendToMainActivity(PhotoResponse photoResponse) {

        mainActivityContract.getPhotos(photoResponse.getPhotos().getPhoto());

    }
}
