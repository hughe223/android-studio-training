package com.example.roomhw;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QRepository {
    private QDao mQDao;
    private LiveData<List<QPair>> mAllPairs;

    QRepository(Application application){
        QRoomDatabase db = QRoomDatabase.getDatabase(application);
        mQDao = db.mQADao();
        mAllPairs = mQDao.getAllPairs();
    }

    public void insert(QPair pair){
        new insertAsyncTask(mQDao).execute(pair);
    }

    LiveData <List<QPair>> getAllPairs (){
        return mAllPairs;
    }

    private static class insertAsyncTask extends AsyncTask<QPair, Void, Void> {
        private QDao mAsyncTaskDao;

        insertAsyncTask(QDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(QPair... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
