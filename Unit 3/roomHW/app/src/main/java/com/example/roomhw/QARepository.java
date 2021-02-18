package com.example.roomhw;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QARepository {
    private QADao mQADao;
    private LiveData<List<QAPair>> mAllPairs;

    QARepository(Application application){
        QARoomDatabase db = QARoomDatabase.getDatabase(application);
        mQADao = db.mQADao();
        mAllPairs = mQADao.getAllPairs();
    }

    public void insert(QAPair pair){
        new insertAsyncTask(mQADao).execute(pair);
    }

    LiveData <List<QAPair>> getAllPairs (){
        return mAllPairs;
    }

    private static class insertAsyncTask extends AsyncTask<QAPair, Void, Void> {
        private QADao mAsyncTaskDao;

        insertAsyncTask(QADao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(QAPair... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
