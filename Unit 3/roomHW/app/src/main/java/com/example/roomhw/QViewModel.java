package com.example.roomhw;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class QViewModel extends AndroidViewModel {

    private QRepository mRepository;
    private LiveData<List<Question>> mAllPairs;

    public QViewModel(@NonNull Application application) {
        super(application);
        mRepository = new QRepository(application);
        mAllPairs = mRepository.getAllPairs();
    }

    LiveData<List<Question>> getAllPairs () {
        return mAllPairs;
    }

    public void insert(Question pair) {
        mRepository.insert(pair);
    }
}
