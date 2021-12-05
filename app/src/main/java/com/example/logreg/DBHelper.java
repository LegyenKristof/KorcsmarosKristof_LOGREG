package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "logs.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "felhasznalo";
    private static final String COL_ID = "id";
    private static final String COL_EMAIL = "email";
    private static final String COL_FELHNEV = "felhnev";
    private static final String COL_JELSZO = "jelszo";
    private static final String COL_TELJESNEV = "teljesnev";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL + " TEXT NOT NULL UNIQUE, " +
                COL_FELHNEV + " TEXT NOT NULL UNIQUE, " +
                COL_JELSZO + " TEXT NOT NULL, " +
                COL_TELJESNEV + " TEXT NOT NULL);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean regisztracio(String[] adatok){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, adatok[0]);
        contentValues.put(COL_FELHNEV, adatok[1]);
        contentValues.put(COL_JELSZO, adatok[2]);
        contentValues.put(COL_TELJESNEV, adatok[3]);
        return this.getWritableDatabase().insert(TABLE_NAME, null, contentValues) != -1;
    }

    public Cursor belepes(String[] adatok){
        return this.getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE " + COL_FELHNEV + " = ? AND " + COL_JELSZO + " = ?;", adatok);
    }
}
