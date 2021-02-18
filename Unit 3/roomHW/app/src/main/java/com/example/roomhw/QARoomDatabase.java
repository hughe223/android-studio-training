package com.example.roomhw;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {QAPair.class}, version = 1, exportSchema = false)
public abstract class QARoomDatabase extends RoomDatabase {
    public abstract QADao mQADao();

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

        private final QADao mDao;
        String[] questions = {"Who was the first president of the USA?",
                              "How many days pass in four years?",
                              "What is the music of life?"};

        String[] answers = {"George Washington was the first president of the United States.",
                            "1461 days.",
                            "Silence, my brother."};

        public PopulateDbAsync(QARoomDatabase instance) {
            mDao = instance.mQADao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();

            for (int i = 0; i <= questions.length - 1; i++) {
                QAPair word = new QAPair(questions[i]);
                mDao.insert(word);
            }
            return null;
        }

    }
}
