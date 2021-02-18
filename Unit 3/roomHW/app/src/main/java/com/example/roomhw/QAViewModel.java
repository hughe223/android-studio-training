package com.example.roomhw;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class QAViewModel extends AndroidViewModel {

    private QARepository mRepository;
    private LiveData<List<QAPair>> mAllPairs;

    public QAViewModel(@NonNull Application application) {
        super(application);
        mRepository = new QARepository(application);
        mAllPairs = mRepository.getAllPairs();
    }

    LiveData<List<QAPair>> getAllPairs () {
        return mAllPairs;
    }

    public void insert(QAPair pair) {
        mRepository.insert(pair);
    }
}
