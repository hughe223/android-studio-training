package com.example.roomhw;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QADao {

    @Insert
    void insert(QAPair pair);

    @Query("DELETE FROM QA_table")
    void deleteAll();

    @Query("SELECT * from QA_table ORDER BY question ASC")
    LiveData<List<QAPair>> getAllPairs();

    /*@Query("SELECT * from QA_table ORDER BY answer ASC")
    LiveData<List<QAPair>> getAllAnswers();*/
}
