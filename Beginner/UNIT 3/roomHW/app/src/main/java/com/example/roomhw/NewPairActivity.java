package com.example.roomhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPairActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY_QUESTION = "com.example.android.roomHW.Q_REPLY";
    public static final String EXTRA_REPLY_ANSWER = "com.example.android.roomHW.A_REPLY";
    private EditText mQuestionEdit;
    private EditText mAnswerEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pair);
        mQuestionEdit = findViewById(R.id.question_edit_text);
        mAnswerEdit = findViewById(R.id.answer_edit_text);

        final Button button = findViewById(R.id.save_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(mQuestionEdit.getText()) || TextUtils.isEmpty(mAnswerEdit.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                }
                else {
                    String question = mQuestionEdit.getText().toString();
                    String answer = mAnswerEdit.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY_QUESTION, question);
                    replyIntent.putExtra(EXTRA_REPLY_ANSWER, answer);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}