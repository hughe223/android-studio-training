package com.example.roomhw;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Q_table")
public class QPair {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "question")
    private String mQuestion;

    /*@NonNull
    @ColumnInfo(name = "answer")
    private String mAnswer;*/

    public QPair(@NonNull String question) {this.mQuestion = question;}
                                             //this.mAnswer = answer;}
    public String getQuestion(){return this.mQuestion;}
    //public String getAnswer(){return this.mAnswer;}
}
