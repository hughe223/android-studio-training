package com.example.roomhw;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ADao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Answer answer);

    @Query("DELETE FROM A_table")
    void deleteAll();

    @Query("DELETE FROM A_TABLE WHERE id=:id")
    void delete(int id);

    @Query("SELECT * from A_table ORDER BY id ASC")
    LiveData<List<Answer>> getAllAnswers();
}
