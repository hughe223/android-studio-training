package com.example.roomhw;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Q_table")
public class Question {

    @PrimaryKey(autoGenerate = true)
    public int id = 0;

    @NonNull
    @ColumnInfo(name = "question")
    private String mQuestion;

    public Question(@NonNull String question) {this.mQuestion = question;}
    public String getQuestion(){return this.mQuestion;}
    public int getId() {return this.id;}

}
