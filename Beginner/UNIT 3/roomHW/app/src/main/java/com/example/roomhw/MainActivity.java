package com.example.roomhw;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String LIST_STATE_KEY = "list-key";
    public static final int NEW_PAIR_ACTIVITY_REQUEST_CODE = 1;
    public Parcelable mListState = null;
    private LinearLayoutManager manager;

    private QAViewModel mQAViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewPairActivity.class);
                startActivityForResult(intent, NEW_PAIR_ACTIVITY_REQUEST_CODE);
            }
        });

        //recycler view init
        manager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final QAListAdapter adapter = new QAListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        //touch helper init
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new QAListAdapter.SwipeToDeleteCallback(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);

        //View model init
        mQAViewModel = ViewModelProviders.of(this).get(QAViewModel.class);
        mQAViewModel.getAllQuestions().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                adapter.setQuestion(questions);
            }
        });

        mQAViewModel.getAllAnswers().observe(this, new Observer<List<Answer>>() {
            @Override
            public void onChanged(List<Answer> answers) {
                adapter.setAnswer(answers);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_PAIR_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Question question = new Question(data.getStringExtra(NewPairActivity.EXTRA_REPLY_QUESTION));
            Answer answer = new Answer(data.getStringExtra(NewPairActivity.EXTRA_REPLY_ANSWER));
            mQAViewModel.insert(question);
            mQAViewModel.insert(answer);
        } else {
            Toast.makeText(getApplicationContext(),"Nothing saved",Toast.LENGTH_LONG).show();
        }
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Parcelable mState = manager.onSaveInstanceState();
        outState.putParcelable(LIST_STATE_KEY, mState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            mListState = savedInstanceState.getParcelable(LIST_STATE_KEY);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(mListState != null){
            manager.onRestoreInstanceState(mListState);
        }
    }
}