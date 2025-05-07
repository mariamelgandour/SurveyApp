package com.example.surveyapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Name_View_Activity extends AppCompatActivity {
     ListView list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_view);
       list = findViewById(R.id.list_Of_Names);
       String from = getIntent().getStringExtra("From");
        UsersData usersData =new UsersData(this);
       if (from.equals("countNames")){
       //get names from database ;
        String []names =usersData.selectNames();
        ArrayAdapter adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,names);
        list.setAdapter(adapter);
    } else if (from.equals("details")) {
           Cursor cursor =usersData.selectAll();
           String []columns ={"name","yes","no"};
           int []ids ={R.id.customName,R.id.customYes,R.id.customNo};
           SimpleCursorAdapter adapter =new SimpleCursorAdapter(this,R.layout.custom_user,cursor,columns,ids,0);
           list.setAdapter(adapter);

       }
    }}