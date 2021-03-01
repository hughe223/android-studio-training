package com.example.a21hw;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String mSharedPrefFile = "com.example.a21hw";
    public static final String SAVED_MESSAGE = "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPrefs = getApplicationContext().getSharedPreferences(mSharedPrefFile, 0);
        String savedMessage = sharedPrefs.getString(SAVED_MESSAGE, "");

        EditText mEditText = findViewById(R.id.edit_text);
        mEditText.setText(savedMessage);

        Button mButton = findViewById(R.id.button_save);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditText.getText().toString();
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putString(SAVED_MESSAGE, message).apply();
                Toast.makeText(getApplicationContext(), "Message Saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}