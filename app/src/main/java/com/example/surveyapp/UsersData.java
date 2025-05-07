package com.example.surveyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UsersData {
    Engine eng ;
    SQLiteDatabase db ;

    public UsersData(Context context) {
        eng =new Engine(context);
        db=eng.getWritableDatabase();
    }
    public  boolean insert (String name ,byte yes , byte no){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("yes",yes);
        contentValues.put("no",no);
        long id = db.insert("users", null, contentValues);
        if (id>0)
            return  true;
        return  false ;

    }
    public  boolean exists (String name) {
//        String query = "select name from users where name=name=?";
//        String query = "SELECT name FROM users WHERE name = ?";
//
//        String []where = {name};
//        Cursor cursor = db.rawQuery(query, where);
//        if (cursor.getCount()>0)
//            return true;
//        return false;


        String query = "SELECT name FROM users WHERE name = ?";
        String[] where = {name};
        Cursor cursor = db.rawQuery(query, where);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;

    }
    public  int getCount (){
        String query = "SELECT count(*) from users ";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToNext();
        int count =cursor.getInt(0);

       cursor.close();
        return  count;



    }
    public  String[]selectNames(){
        String query = "select name from users";
        Cursor cursor = db.rawQuery(query, null);
        String []names = new  String[cursor.getCount()];
        if (cursor.getCount()>0){
            for(int i =0 ; i<cursor.getCount();i++){
                cursor.moveToNext();
                names[i]=cursor.getString(0);
            }
        }
        return  names ;


    }
    public Cursor selectAll(){
        String  query = "select * from users";
        Cursor cursor = db.rawQuery(query, null);
        return  cursor ;
    }
}