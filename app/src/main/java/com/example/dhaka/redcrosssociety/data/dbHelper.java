package com.example.dhaka.redcrosssociety.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dhaka.redcrosssociety.model.person;

import java.util.ArrayList;
import java.util.List;

public class dbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "person.db";
    public static final String TABLE_NAME = "person";
    public static final int DB_VERSON = 1;
    public static final String DB_LOCATION = "/data/data/com.example.dhaka.redcrosssociety/databases/";
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public dbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSON);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Open Database
     */
    public void openDatabase() {
        String dbPath = context.getDatabasePath(DB_NAME).getPath();
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
            return;
        }
        sqLiteDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    /**
     * Close Database
     */
    public void closeDatabase() {
        if (sqLiteDatabase != null) {
            sqLiteDatabase.close();
        }
    }

    /**
     * Get the list obtained from the Query.
     *
     * @param selection     String representing Where clause.
     * @param selectionArgs Arguments passed into where clause.
     * @return List of objects returned from query
     */
    public List<person> getPersonList(String selection, String[] selectionArgs) {
        List<person> personList = new ArrayList<>();
        openDatabase();
        Cursor cursor = sqLiteDatabase.query(
                TABLE_NAME,
                new String[]{person.COLUMN_ID,
                        person.COLUMN_FNAME,
                        person.COLUMN_LNAME,
                        person.COLUMN_GENDER,
                        person.COLUMN_ADDRESS,
                        person.COLUMN_CONTACT,
                        person.COLUMN_BLOOD_GROUP},
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        do {
            personList.add(new person(cursor.getInt(person.ID),
                    cursor.getString(person.FNAME),
                    cursor.getString(person.LNAME),
                    cursor.getString(person.GENDER),
                    cursor.getString(person.ADDRESS),
                    cursor.getString(person.CONTACT),
                    cursor.getString(person.BLOOD_GROUP)));
        } while (cursor.moveToNext());
        cursor.close();
        closeDatabase();
        return personList;
    }

}
