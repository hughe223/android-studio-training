package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_COUNT = "com.example.myapplication.extra.COUNT";
    int mCount = 0;
    TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        if(savedInstanceState != null)
        {
            Log.d("MainActivity", "restoring save state");
            mCount = savedInstanceState.getInt("savedCount");
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Main", "Saving State");
        outState.putInt("savedCount", mCount);
    }

    public void countUp(View view) {
        Log.d("MainActivity","Clicked Count!");
        mCount++;
        if(mShowCount != null)
        {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void sayHello(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_COUNT, mCount);
        startActivity(intent);
    }
}