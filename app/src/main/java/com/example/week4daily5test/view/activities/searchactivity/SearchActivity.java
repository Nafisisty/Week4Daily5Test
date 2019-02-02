package com.example.week4daily5test.view.activities.searchactivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.week4daily5test.R;
import com.example.week4daily5test.view.activities.mainactivity.MainActivity;

public class SearchActivity extends AppCompatActivity {

    EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = findViewById(R.id.searchEditTextId);
    }

    public void onClick(View view) {

        @NonNull String searchKey = searchEditText.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("searchKey", searchKey);
        setResult(666, intent);
        finish();

    }
}
