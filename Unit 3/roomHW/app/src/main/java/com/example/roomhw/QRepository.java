package com.example.roomhw;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QRepository {
    private QDao mQDao;
    private LiveData<List<Question>> mAllPairs;

    QRepository(Application application){
        QRoomDatabase db = QRoomDatabase.getDatabase(application);
        mQDao = db.mQDao();
        mAllPairs = mQDao.getAllPairs();
    }

    public void insert(Question pair){
        new insertAsyncTask(mQDao).execute(pair);
    }

    LiveData <List<Question>> getAllPairs (){
        return mAllPairs;
    }

    private static class insertAsyncTask extends AsyncTask<Question, Void, Void> {
        private QDao mAsyncTaskDao;

        insertAsyncTask(QDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Question... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
