package com.example.roomhw;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Question.class,
                      Answer.class}, version = 10, exportSchema = false)
public abstract class QARoomDatabase extends RoomDatabase {
    public abstract QDao mQDao();
    public abstract ADao mADao();

    private static QARoomDatabase INSTANCE;

    public static QARoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (QARoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QARoomDatabase.class, "qa_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static QARoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>  {

        private final QDao mQDao;
        private final ADao mADao;

        String[] questions = {"Who was the first president of the USA?",
                              "How many days pass in four years?",
                              "What is the music of life?"};

        String[] answers = {"George Washington was the first president of the United States.",
                            "1461 days.",
                            "Silence, my brother."};

        public PopulateDbAsync(QARoomDatabase instance) {
            mQDao = instance.mQDao();
            mADao = instance.mADao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mQDao.deleteAll();
            mADao.deleteAll();

            for (int i = 0; i <= questions.length - 1; i++) {
                Question question = new Question(questions[i]);
                Answer answer = new Answer(answers[i]);
                mQDao.insert(question);
                mADao.insert(answer);
            }
            return null;
        }

    }
}
