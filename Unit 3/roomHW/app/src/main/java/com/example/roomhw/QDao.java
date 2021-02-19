package com.example.roomhw;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Question pair);

    @Query("DELETE FROM Q_table")
    void deleteAll();

    @Query("SELECT * from Q_table ORDER BY question ASC")
    LiveData<List<Question>> getAllPairs();

    /*@Query("SELECT * from QA_table ORDER BY answer ASC")
    LiveData<List<QAPair>> getAllAnswers();*/
}
