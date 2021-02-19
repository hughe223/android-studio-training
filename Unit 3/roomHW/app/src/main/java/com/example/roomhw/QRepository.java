package com.example.roomhw;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QRepository {
    private QDao mQDao;
    private ADao mADao;
    private LiveData<List<Question>> mAllQuestions;
    private LiveData<List<Answer>> mAllAnswers;

    QRepository(Application application){
        QARoomDatabase db = QARoomDatabase.getDatabase(application);
        mQDao = db.mQDao();
        mADao = db.mADao();
        mAllQuestions = mQDao.getAllQuestions();
        mAllAnswers = mADao.getAllAnswers();
    }

    public void insert(Question question) {
        new insertQAsyncTask(mQDao).execute(question);
    }

    public void insert(Answer answer) {
        new insertAAsyncTask(mADao).execute(answer);
    }

    LiveData<List<Question>> getAllQuestions (){
        return mAllQuestions;
    }

    LiveData<List<Answer>> getAllAnswers() {return mAllAnswers; }


    private static class insertQAsyncTask extends AsyncTask<Question, Void, Void> {
        private QDao mQAsyncTaskDao;

        insertQAsyncTask(QDao dao) {
            mQAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Question... params) {
            mQAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertAAsyncTask extends AsyncTask<Answer, Void, Void> {
        private ADao mAAsyncTaskDao;

        insertAAsyncTask(ADao dao) {
            mAAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Answer... params) {
            mAAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
