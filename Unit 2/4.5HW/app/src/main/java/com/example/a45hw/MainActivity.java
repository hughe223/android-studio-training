package com.example.a45hw;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mTitleList = new LinkedList<>();
    private final LinkedList<String> mDescList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize titles and descriptions
        addTitle(getString(R.string.spaghetti_title));
        addTitle(getString(R.string.steak_title));
        addTitle(getString(R.string.stir_fry_title));
        addTitle(getString(R.string.burger_title));
        addTitle(getString(R.string.taco_title));
        addTitle(getString(R.string.strog_title));
        addTitle(getString(R.string.nacho_title));
        addTitle(getString(R.string.jambalaya_title));
        addTitle(getString(R.string.goulash_title));
        addTitle(getString(R.string.pizza_title));
        addTitle(getString(R.string.salad_title));



        addDescription(getString(R.string.spaghetti_description));
        addDescription(getString(R.string.steak_description));
        addDescription(getString(R.string.stir_fry_description));
        addDescription(getString(R.string.burger_description));
        addDescription(getString(R.string.taco_description));
        addDescription(getString(R.string.default_body));
        addDescription(getString(R.string.default_body));
        addDescription(getString(R.string.default_body));
        addDescription(getString(R.string.default_body));
        addDescription(getString(R.string.default_body));
        addDescription(getString(R.string.default_body));

        //Initialize views and adapters
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new RecipeListAdapter(this, mTitleList, mDescList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addTitle(String title){
        mTitleList.addLast(title);
    }

    private void addDescription(String desc){
        mDescList.addLast(desc);
    }
}