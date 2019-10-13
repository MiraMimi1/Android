package com.w12.thslm.historica;

import android.content.Context;

/** ADDED DEPENDENCE IN THE GRADLE **/
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class getDB extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "myDataBase.db";
    private static final int DATABASE_VERSION = 1;

    public getDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}