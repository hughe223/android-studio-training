package com.example.roomhw;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "QA_table")
public class QAPair {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "question")
    private String mQuestion;

    /*@NonNull
    @ColumnInfo(name = "answer")
    private String mAnswer;*/

    public QAPair(@NonNull String question) {this.mQuestion = question;}
                                             //this.mAnswer = answer;}
    public String getQuestion(){return this.mQuestion;}
    //public String getAnswer(){return this.mAnswer;}
}
