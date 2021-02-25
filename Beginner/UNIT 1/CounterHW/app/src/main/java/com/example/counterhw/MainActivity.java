package com.example.counterhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {
    int mCount = 0;
    TextView mShowCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.view_count);
        if(savedInstanceState != null)
        {
            onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("savedCount", mCount);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCount = savedInstanceState.getInt("savedCount");
        mShowCount.setText(Integer.toString(mCount));
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null)
        {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}