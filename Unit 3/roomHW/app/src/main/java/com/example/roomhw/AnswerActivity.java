package com.example.roomhw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class AnswerActivity extends AppCompatActivity {
    private QAViewModel qaViewModel;
    private final String CURRENT_POS = "com.example.roomHW.POS";
    private final String CLICKED_ANSWER = "com.example.roomHW.ANSWER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        TextView answerView = findViewById(R.id.answer_text);
        Intent intent = getIntent();
        String answer = intent.getStringExtra(CLICKED_ANSWER);
        answerView.setText(answer);
    }
}