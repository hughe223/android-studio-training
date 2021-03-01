/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.FragmentCommunicate;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SimpleFragment.OnFragmentInteractionListener{
    private Button mButton;
    private int mRadioButtonChoice = 2;
    private boolean isFragmentDisplayed = false;
    static final String STATE_FRAGMENT = "state_of_fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.open_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFragmentDisplayed){
                    displayFragment();
                }
                else {
                    closeFragment();
                }
            }
        });

        if(savedInstanceState != null) {
            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_FRAGMENT);
        }
        if(isFragmentDisplayed) {
            mButton.setText(R.string.close);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed);
        super.onSaveInstanceState(outState);
    }

    public void displayFragment() {
        SimpleFragment simpleFragment = SimpleFragment.newInstance(mRadioButtonChoice);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, simpleFragment).addToBackStack(null).commit();
        mButton.setText(R.string.close);
        isFragmentDisplayed = true;
    }

    public void closeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment_container);
        if(simpleFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }
        mButton.setText(R.string.open);
        isFragmentDisplayed = false;
    }

    public void newActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRadioButtonChoice(int choice) {
        mRadioButtonChoice = choice;
        String message = "";
        switch(choice){
            case 0:
                message = "yes";
                break;

            case 1:
                message = "no";
                break;
            default:
                break;
        }
        Toast.makeText(this, "You chose " + message + "!", Toast.LENGTH_SHORT).show();
    }
}
