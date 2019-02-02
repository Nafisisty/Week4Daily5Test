package com.example.week4daily5test.model.events;

import com.example.week4daily5test.model.photo.PhotoResponse;

public class PhotoResponseEvent {
    private PhotoResponse photoResponse;

    public PhotoResponseEvent(PhotoResponse photoResponse) {
        this.photoResponse = photoResponse;
    }

    public PhotoResponse getPhotoResponse() {
        return photoResponse;
    }

    public void setPhotoResponse(PhotoResponse photoResponse) {
        this.photoResponse = photoResponse;
    }
}
