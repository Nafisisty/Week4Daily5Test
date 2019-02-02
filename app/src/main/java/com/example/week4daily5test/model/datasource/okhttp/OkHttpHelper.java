package com.example.week4daily5test.model.datasource.okhttp;

import android.util.Log;

import com.example.week4daily5test.model.events.PhotoResponseEvent;
import com.example.week4daily5test.model.photo.PhotoResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {
    public static void okHttpApiCall(String url) {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            String jsonResponse;

            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("TAG", "onFailure: " + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                jsonResponse = response.body().string();
                Log.d("TAG", "onResponse: " + jsonResponse);

                Gson gson = new Gson();
                PhotoResponse photoResponse = gson.fromJson(jsonResponse, PhotoResponse.class);

                EventBus.getDefault().post(new PhotoResponseEvent(photoResponse));
            }
        });
    }
}
