package com.example.surveyapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class QuestionData {
    Engine eng ;
    SQLiteDatabase db ;

    public QuestionData(Context context) {
      eng =new Engine(context);
      db = eng.getReadableDatabase();
    }
    public String [] selectQuestions(){
        String query = "select question from questions" ;
         Cursor cursor =db.rawQuery(query,null);
         String []data =new String [cursor.getCount()];
         if (cursor.getCount()>0){
             for (int i =0 ;i<cursor.getCount() ; i++){
                 cursor.moveToNext();
                 data[i]=cursor.getString(0);

             }
         }
         return data;
    }
}
