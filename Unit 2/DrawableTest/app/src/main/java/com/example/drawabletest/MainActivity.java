package com.example.drawabletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int mLevel = 0;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = findViewById(R.id.image_view);
        LevelListDrawable drawable = new LevelListDrawable();
        mImage.setImageDrawable(drawable);
        mImage.setImageLevel(mLevel);
    }

    public void raiseLevel(View view) {
        mLevel++;
        mImage.setImageLevel(mLevel);
        mImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batter_level));
        mImage.refreshDrawableState();
    }

    public void dropLevel(View view) {
        mLevel--;
        mImage.setImageLevel(mLevel);
        mImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batter_level));
        mImage.refreshDrawableState();
    }
}