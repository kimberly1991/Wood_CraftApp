package com.example.wood_craftapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBName = "USER_RECORD";
    private static final String Table_Name = "USER_DATA";
    private static final String Col_1 = "ID";
    private static final String Col_2 = "USERNAME";
    private static final String Col_3 = "EMAIL";
    private static final String Col_4 = "PASSWORD";

    public DBHelper( Context context){
        super(context, "DBName", null, 1);
    }


    @Override
    public void onCreate(@Nullable SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE IF NOT EXISTS " +Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, EMAIL TEXT,  PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE IF EXIST" + Table_Name);
        onCreate(MyDB);
    }

    public boolean registerUser (String username, String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Col_2", username);
        contentValues.put("Col_3", email);
        contentValues.put("Col_4", password);

        Long result = MyDB.insert( "Table_Name", null, contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public boolean checkUser(String username, String password){
    SQLiteDatabase MyDB = this.getWritableDatabase();
    String [] columns = {Col_1};
    String selection =  Col_2 + "=?" + " and " + Col_4 + "=?";
    String [] selectionargs = { username , password };
        Cursor cursor = MyDB.query(Table_Name , columns , selection , selectionargs , null , null , null );
        int count = cursor.getCount();
        MyDB.close();
        cursor.close();
        if (count > 0)
            return true;
        else
            return false;
    }

}
