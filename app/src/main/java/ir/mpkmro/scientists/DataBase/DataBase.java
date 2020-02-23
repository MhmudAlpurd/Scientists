package ir.mpkmro.scientists.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import ir.mpkmro.scientists.Model.Person;

public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public DataBase(Context context) {
        super(context, info_db.DATABASE_NAME, null, info_db.DATABASE_VERSION);
        this.context = context;
        isDataBase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    private void isDataBase() {
        File check = new File(info_db.PACKAGE);
        if (check.exists()) {

        } else {
            check.mkdir();
            Log.i("SQLite Error", "isDatabase_method");
        }

        check = this.context.getDatabasePath(info_db.DATABASE_NAME);


        if (check.exists()) {

        } else {

            try {
                copyDataBase();
                Log.i("SQLite Error", "copyDataBase_method");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(info_db.DATABASE_SOURCE);
        String outFileName = info_db.PACKAGE + info_db.DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public List<Person> getAllPerson() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "SELECT * FROM person";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));

                data.add(person);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;

    }

    public List<Person> getIranPerson() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "SELECT * FROM person WHERE category = 'irani'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));

                data.add(person);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;

    }

    public List<Person> getForeignPerson() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "SELECT * FROM person WHERE category = 'foreign'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));

                data.add(person);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;

    }




}
