package com.example.surveyapp;


import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Engine  extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "survey.db";
    private static final int DATABASE_VERSION = 1;

    public Engine(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
