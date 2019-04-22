package com.example.flashquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class FlashQuizWrapper {
    static final String TAG = "DBAdapter";
    final Context context;
    DBHelper openHelper;
    SQLiteDatabase fqDB;

    public FlashQuizWrapper(Context ctx) {
        this.context = ctx;
        openHelper = new DBHelper(ctx);
    }

    //--opens database--
    public SQLiteDatabase open() throws SQLException
    {
        fqDB = openHelper.getWritableDatabase();
        return fqDB;
    }

    public void close() {
        openHelper.close();
    }

    public long insert(Flashcard card) {
        ContentValues val = new ContentValues();
        val.put("front", card.getFront());
        val.put("back", card.getBack());
        val.put("timesSeen", card.getTimesSeen());
        val.put("timesCorrect", card.getPercentCorrect());
        return fqDB.insert("FlashQuizDB", null, val);
    }

    public boolean delete(long rowID) {
        return fqDB.delete("FlashQuizDB", "_id=" + rowID, null) > 0;
    }

    public Cursor getAll() throws SQLException {
        return fqDB.query("FlashQuizDB", new String[] {"_id", "front", "back", "timesSeen", "timesCorrect"},
                null, null,null, null, null);
    }

    public Cursor get(long rowID) throws SQLException{
        Cursor mCursor = fqDB.query(true, "FlashQuizDB",
                new String[] {"_id,", "front", "back", "timesSeen", "timesCorrect"},
                "_id" + rowID, null, null, null, null, null);
        if(mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public long update(long rowID, Flashcard card) {
        ContentValues val = new ContentValues();
        val.put("front", card.getFront());
        val.put("back", card.getBack());
        val.put("timesSeen", card.getTimesSeen());
        val.put("timesCorrect", card.getPercentCorrect());
        return fqDB.update("FlashQuizDB", val, "_id" + rowID, null);
    }
}
