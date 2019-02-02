package com.example.week4daily5test.view.activities.mainactivity;

import com.example.week4daily5test.model.photo.Photo;
import com.example.week4daily5test.model.photo.PhotoResponse;

import java.util.List;

public interface MainActivityContract {
    void getPhotos(List<Photo> photoList);
}
