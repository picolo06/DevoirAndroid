package com.example.claudy.devoirandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by CLAUDY on 4/27/2017.
 */

public class SqqDev extends SQLiteOpenHelper {
    private static final String TAG = "SqqDev";

    public static final String db_name = "Contact.db";
    private static final String TABLE_NAME = "contact_table";
    //public static final int db_version = 1;
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NOM";
    private static final String COL_3 = "PRENOM";
    private static final String COL_4 = "MAIL";
    private static final String COL_5 = "TELEPHONE";
    private static final String COL_6 = "ADRESSE";
    private static final String COL_7 = "STATUT";

    public SqqDev(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "ID INTEGER PRIMARY KEY AUTOINCREMENT, NOM TEXT, PRENOM TEXT, MAIL TEXT, TELEPHONE TEXT, ADRESSE TEXT, STATUT TEXT ";
        db.execSQL(createTable);
       // onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbl, int i, int i1) {
        //oldVersion = 1;
        dbl.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME );
        onCreate(dbl);

    }


    public boolean insertdata(String Nom, String Prenom, String Mail, String Telephone, String Adresse, String Statut) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, Nom);
        contentValues.put(COL_3, Prenom);
        contentValues.put(COL_4, Mail);
        contentValues.put(COL_5, Telephone);
        contentValues.put(COL_6, Adresse);
        contentValues.put(COL_7, Statut);

        Log.d(TAG, "insertdata: Adding " + Nom + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor res = db.rawQuery(query, null);
        return res;
    }

 /*  public boolean updatedata(String ID, String Nom, String Prenom, String Mail, String Telephone, String Adresse, String Statut) {
        SQLiteDatabase dtbd = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, ID);
        contentValues.put(COL_2, Nom);
        contentValues.put(COL_3, Prenom);
        contentValues.put(COL_4, Mail);
        contentValues.put(COL_5, Telephone);
        contentValues.put(COL_6, Adresse);
        contentValues.put(COL_7, Statut);
        dtbd.update(TABLE_NAME, contentValues, "ID = ?",new String[] {ID});
        return true;
    }

    public int deletedata(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{ID});

    }

    public Cursor findContactByName(String Nom){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE nom = ?", new String[]{Nom});
        return cursor;
    } */
}
