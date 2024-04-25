package com.example.budgetbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class db_data extends SQLiteOpenHelper {
    String s="";
   public ArrayList<String> samG1 = new ArrayList<String>();
    public ArrayList<String> samG2 = new ArrayList<String>();

    String a = "-";
    String b;
    int i=0;

    public db_data(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE d(id INTEGER PRIMARY KEY AUTOINCREMENT,day INTEGER,month INTEGER,year INTEGER," +
                "rs INTEGER,credit TEXT,debit TEXT,online TEXT,offline TEXT,upi TEXT,note TEXT,Date TEXT)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+"d");
        onCreate(sqLiteDatabase);
    }




    public void adddata(data dt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("day",dt.getDay());
        values.put("month",dt.getMonth());
        values.put("year",dt.getYear());
        values.put("rs",dt.getRs());
        values.put("credit",dt.getCredit());
        values.put("debit",dt.getDebit());
        values.put("online",dt.getOnline());
        values.put("offline",dt.getOffline());
        values.put("upi",dt.getUpi());
        values.put("note",dt.getNote());
        values.put("Date",dt.getDate());



        long K = db.insert("d", null, values);


        db.close();
    }




    public void getdata_all() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM d", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Log.d("sam id : ", cursor.getString(0));
                Log.d("sam day : ", cursor.getString(1));
                Log.d("sam month : ", cursor.getString(2));
                Log.d("sam year : ", cursor.getString(3));
                Log.d("sam rs : ", cursor.getString(4));
                Log.d("sam credit : ", cursor.getString(5));
                Log.d("sam debit : ", cursor.getString(6));
                Log.d("sam online : ", cursor.getString(7));
                Log.d("sam offline : ", cursor.getString(8));
                Log.d("sam upi : ", cursor.getString(9));
                Log.d("sam note : ", cursor.getString(10));
                Log.d("sam Date : ", cursor.getString(11));

            } while (cursor.moveToNext());
        }
        else
        {
            Log.d("sam", "Some error occur");
        }
            db.close();
    }



    public ArrayList<String> getdata_2() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM d", null);
        Log.d("sam : ","at start from getdata2 in db_data.java");
        if (cursor != null && cursor.moveToFirst()) {
            do {

                s =" DATE : "+cursor.getString(1)+"/"+cursor.getString(2)+"/"+cursor.getString(3)+"\n"+
                     " In Online Mode : "+cursor.getString(7)+"\n"+" In Offline Mode : "+cursor.getString(8)+"\n"+
                      " Selected UPI : "+cursor.getString(9)+"\n"+ " Entry Time : "+cursor.getString(11)+"\n"+
                        " Note : "+cursor.getString(10);

                samG2.add(s);

            } while (cursor.moveToNext());
        }
        else {
            Log.d("sam", "Some error occur");
        }
        db.close();

        return samG2;
    }



    public ArrayList<String> getdata_1() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM d", null);
        Log.d("sam : ","at start from getdata1 in db_data.java");
        if (cursor != null && cursor.moveToFirst()) {
            do {
                s= "  "+"\n\t\t"+cursor.getString(4)+"\n\n";
                b = cursor.getString(5);
                if (b.equals(a)) {
                    s+=cursor.getString(6);
                }
                else{
                    s+=b;
                }

                samG1.add(s);


            } while (cursor.moveToNext());
        }
        else {
            Log.d("sam", "Some error occur");
        }
        db.close();

        return samG1;
    }


    public int deletedata(int index){

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete("d","id=?",new String[]{String.valueOf(index)});
            return index;
        }catch (Exception e){
            return 0;
        }

    }

        public int getLength(){
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM d", null);
            int a = cursor.getCount();
            db.close();
            return a;
        }

    public ArrayList<String> getSamG2() {
        return samG2;
    }

    public ArrayList<String> getSamG1() {
        return samG1;
    }
}

