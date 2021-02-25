package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int mCount = intent.getIntExtra(MainActivity.EXTRA_COUNT,0);
        TextView mShowCount2 = findViewById(R.id.show_count2);
        mShowCount2.setText(Integer.toString(mCount));
        Log.d("MainActivity","Clicked Hello!");
    }
}