package com.w12.thslm.historica;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new getDB(context);
    }


    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    public void open() {
        this.database = openHelper.getWritableDatabase();
    }


    public void close() {
        if (database != null) {
            this.database.close();
        }
    }




    public ArrayList<Livres> getDBdata() {
        ArrayList<Livres>  books= new ArrayList<Livres>();
        Cursor cr = database.rawQuery("SELECT * FROM Histoires", null);
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            books.add(new Livres(cr.getString(cr.getColumnIndex("Auteur")),cr.getString(cr.getColumnIndex("Titre")),cr.getString(cr.getColumnIndex("Pages")),cr.getString(cr.getColumnIndex("Images")),cr.getString(cr.getColumnIndex("BackgroungImg")),
                    getPages(cr.getString(cr.getColumnIndex("Contenu")))));
            cr.moveToNext();
        }
        cr.close();
        return books;
    }


    /******    Decouper les livres en pages     *****/

    static public String[] getPages(String  text){
        List<String> out=new ArrayList<String>();

        int taillePage=150; //  le nombre de caracterses par de page
        int lastMaxLength=0,i;

        for (i=taillePage; i<text.length(); i+=taillePage ) {
            while (i >=lastMaxLength && text.charAt(i) !=' ' ) {
                i--;
            }
            out.add(text.substring(lastMaxLength,i));
            lastMaxLength=i;
        }
        out.add(text.substring(lastMaxLength,text.length()-1));
        String [] outArray=out.toArray(new String[out.size()]);

        return outArray;
    }

}