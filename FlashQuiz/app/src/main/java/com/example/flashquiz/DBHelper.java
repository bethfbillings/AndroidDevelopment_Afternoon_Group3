package com.example.flashquiz;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_CREATE = "create table FlashQuizDB (_id integer primary key" +
            " autoincrement, front text not null, back text not null, timesSeen integer not null, " +
            " timesCorrect integer not null);";
    DBHelper(Context context){
        super(context, "FlashQuizDB", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DATABASE_CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + "to version " +
                newVersion + "which will destroy all data");
        db.execSQL("DROP TABLE IF EXISTS FlashQuizDB");
        onCreate(db);
    }
}
