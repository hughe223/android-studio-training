package com.example.roomhw;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "A_table")
public class Answer {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "answer")
    private String mAnswer;

    public Answer(@NonNull String answer) {this.mAnswer = answer;}
    public String getQuestion(){return this.mAnswer;}
}
