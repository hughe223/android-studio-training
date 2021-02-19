package com.example.roomhw;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Question.class}, version = 2, exportSchema = false)
public abstract class QRoomDatabase extends RoomDatabase {
    public abstract QDao mQDao();

    private static QRoomDatabase INSTANCE;

    public static QRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (QRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QRoomDatabase.class, "qa_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static QRoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>  {

        private final QDao mDao;
        String[] questions = {"Who was the first president of the USA?",
                              "How many days pass in four years?",
                              "What is the music of life?"};

        String[] answers = {"George Washington was the first president of the United States.",
                            "1461 days.",
                            "Silence, my brother."};

        public PopulateDbAsync(QRoomDatabase instance) {
            mDao = instance.mQDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();

            for (int i = 0; i <= questions.length - 1; i++) {
                Question word = new Question(questions[i]);
                mDao.insert(word);
            }
            return null;
        }

    }
}
