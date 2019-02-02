package com.example.week4daily5test.view.activities.mainactivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.week4daily5test.R;
import com.example.week4daily5test.model.datasource.okhttp.OkHttpHelper;
import com.example.week4daily5test.model.events.PhotoResponseEvent;
import com.example.week4daily5test.model.photo.Photo;
import com.example.week4daily5test.model.photo.PhotoResponse;
import com.example.week4daily5test.view.activities.searchactivity.SearchActivity;
import com.example.week4daily5test.view.adapters.RecyclerViewAdapter;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import static com.example.week4daily5test.model.Constants.FULL_URL;
import static com.example.week4daily5test.model.Constants.SEARCH_URL_PART_1;
import static com.example.week4daily5test.model.Constants.SEARCH_URL_PART_2;

public class MainActivity extends AppCompatActivity implements MainActivityContract {

    PhotoResponse photoResponse;
    MainActivityPresenter mainActivityPresenter;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    public static final int RESULT_CODE = 666;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.photoRecyclerViewId);
        mainActivityPresenter = new MainActivityPresenter(this);

        OkHttpHelper.okHttpApiCall(FULL_URL);
    }

    @Override
    protected void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void photoResponseEvent(@NonNull PhotoResponseEvent event) {

        mainActivityPresenter.sendToMainActivity(event.getPhotoResponse());

    }

    @Override
    public void getPhotos(List<Photo> photoList) {

        recyclerViewAdapter = new RecyclerViewAdapter(photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Intent passedIntentData = data;
        String passedTag = passedIntentData.getStringExtra("searchKey");
        OkHttpHelper.okHttpApiCall(SEARCH_URL_PART_1 + passedTag + SEARCH_URL_PART_2);
    }

    public void onClick(View view) {

        Intent intent = new Intent(this, SearchActivity.class);
        startActivityForResult(intent, RESULT_CODE);

    }
}


