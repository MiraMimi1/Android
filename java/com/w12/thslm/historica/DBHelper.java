package com.w12.thslm.historica;

/**
 *
 * OLD VERSION OF MY APP **USELESS**
 *
 *
 **/

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


/*
public class DBHelper extends SQLiteOpenHelper {



    private static final  String DB_NAME="mydb.db";
    private static final int DB_DBVERSION=1;
    private static final  String TABLE_NAME="Histoires";

    public static final  String COL_0="ID";
    public static final  String COL_1="AUTEUR";
    public static final  String COL_2="TITRE";
    public static final  String COL_3="DESCRIPTION";


    public DBHelper(Context context) {
        super(context,DB_NAME,null,DB_DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL("CREATE TABLE  "+TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT ,AUTEUR TEXT,TITRE TEXT,DESCRIPTION TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF  EXISTS "+TABLE_NAME);
    }

    public boolean AddData(String at,String tr,String ds){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(COL_1,at);
        cv.put(COL_2,tr);
        cv.put(COL_3,ds);

        long result=sqLiteDatabase.insert(TABLE_NAME,null,cv);
        sqLiteDatabase.close();

        if (result != -1) return true;
        else return false;
    }

    public ArrayList<Livres> getData(){
        ArrayList<Livres>  books= new ArrayList<Livres>();

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cr=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        cr.moveToFirst();
        while (!cr.isAfterLast()){
            books.add(new Livres(cr.getString(cr.getColumnIndex(COL_1)),cr.getString(cr.getColumnIndex(COL_2)),cr.getString(cr.getColumnIndex(COL_3))));
        cr.moveToNext();
        }
        return books;
    }

    private boolean checkDB(){
        SQLiteDatabase check=null;
        check=SQLiteDatabase.openDatabase(DB_NAME,null,SQLiteDatabase.OPEN_READONLY);
        check.close();
        return check !=null;
    }


}
*/