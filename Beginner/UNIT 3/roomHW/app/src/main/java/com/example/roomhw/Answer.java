package com.example.roomhw;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity (tableName = "A_table")
public class Answer {
    @PrimaryKey (autoGenerate = true)
    public int id = 0;

    @NonNull
    @ColumnInfo(name = "answer")
    public String mAnswer;

    public Answer(@NonNull String answer) {
        this.mAnswer = answer;
    }

    public String getAnswer(){
        return this.mAnswer;
    }

    public int getId() {
        return this.id;
    }
}
