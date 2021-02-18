package com.example.android.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
    private int mCount;
    private String CURRENT_COUNT = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        TextView showCount = findViewById(R.id.hello_count);
        Intent intent = getIntent();
        mCount = intent.getIntExtra(CURRENT_COUNT, 0);
        showCount.setText(String.format("%s", mCount));
    }
}