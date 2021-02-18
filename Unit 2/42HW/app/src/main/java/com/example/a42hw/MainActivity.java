package com.example.a42hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String message = "";
    public CheckBox syrupBox;
    public CheckBox sprinkleBox;
    public CheckBox nutsBox;
    public CheckBox cherryBox;
    public CheckBox oreoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        syrupBox = findViewById((R.id.syrup_checkbox));
        sprinkleBox = findViewById((R.id.sprinkles_checkbox));
        nutsBox = findViewById((R.id.crushed_nuts_checkbox));
        cherryBox = findViewById((R.id.cherries_checkbox));
        oreoBox = findViewById((R.id.oreo_checkbox));

        syrupBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheck();
            }
        });

        sprinkleBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheck();
            }
        });

        nutsBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheck();
            }
        });

        cherryBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheck();
            }
        });

        oreoBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheck();
            }
        });
    }

    public void onCheck(){
        message = "Toppings: ";
        if(syrupBox.isChecked()) {
            message += "Chocolate syrup ";
        }
        if(sprinkleBox.isChecked()) {
            message += "Sprinkles ";
        }
        if(nutsBox.isChecked()) {
            message += "Crushed nuts ";
        }
        if(cherryBox.isChecked()) {
            message += "Cherries ";
        }
        if(oreoBox.isChecked()) {
            message += "Oreo cookie crumbles";
        }
    }

    public void DisplayToast(View view){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}