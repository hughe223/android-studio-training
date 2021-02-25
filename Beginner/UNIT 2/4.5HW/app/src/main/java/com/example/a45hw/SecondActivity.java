package com.example.a45hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String item_name = null;
        if(extras != null){
            item_name = extras.getString(RecipeListAdapter.EXTRA_NAME);
        }
        TextView heading = findViewById(R.id.item_title);
        TextView body = findViewById(R.id.item_recipe);
        heading.setText(item_name);
        if(item_name != null){
            switch(item_name){
                case "Spaghetti and Meatballs":
                    body.setText(getString(R.string.spaghetti_recipe));
                    break;

                case "Steak and Potatoes":
                    body.setText(getString(R.string.steak_recipe));
                    break;

                case "Chicken Stir-fry":
                    body.setText(getString(R.string.stir_fry_recipe));
                    break;

                case "Cheeseburgers":
                    body.setText(getString(R.string.burger_recipe));
                    break;

                case "Chicken Tacos":
                    body.setText(getString(R.string.taco_recipe));
                    break;

                default: body.setText(R.string.default_body);
                         break;
            }
        }
    }
}