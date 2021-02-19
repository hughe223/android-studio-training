package com.example.roomhw;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class QAViewModel extends AndroidViewModel {

    private QRepository mRepository;
    private LiveData<List<Question>> mAllQuestions;
    private LiveData<List<Answer>> mAllAnswers;

    public QAViewModel(@NonNull Application application) {
        super(application);
        mRepository = new QRepository(application);
        mAllQuestions = mRepository.getAllQuestions();
        mAllAnswers = mRepository.getAllAnswers();
    }

    LiveData<List<Question>> getAllQuestions() {
        return mAllQuestions;
    }

    LiveData<List<Answer>> getAllAnswers() {
        return mAllAnswers;
    }


    public void insert(Question question) {
        mRepository.insert(question);
    }

    public void insert(Answer answer) {
        mRepository.insert(answer);
    }


}
