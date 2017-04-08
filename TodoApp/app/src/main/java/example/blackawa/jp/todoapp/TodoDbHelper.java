package example.blackawa.jp.todoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import example.blackawa.jp.todoapp.repository.TodoContract;

public class TodoDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "shelter.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TODO_TABLE_DDL = "CREATE TABLE " + TodoContract.TodoEntity.TABLE_NAME + " (" +
            TodoContract.TodoEntity._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            TodoContract.TodoEntity.COLUMN_TITLE + " TEXT NOT NULL," +
            TodoContract.TodoEntity.COLUMN_DESCRIPTION + " TEXT NOT NULL," +
            TodoContract.TodoEntity.COLUMN_OWNER + " TEXT NOT NULL," +
            TodoContract.TodoEntity.COLUMN_DEAD_LINE + " TEXT NOT NULL" +
            ");";

    public TodoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TODO_TABLE_DDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
