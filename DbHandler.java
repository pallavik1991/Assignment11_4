package com.example.akaash.assignment11_4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKAASH on 22-11-2017.
 */

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(Context context) {
        super(context, "PersonDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q="create table person(id int primary key,fname text,lname text)";
        sqLiteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table person if exists");
    }

    private int auto_incr()
    {
        int id=0;
        SQLiteDatabase db=this.getReadableDatabase();
        String q="select count(*),max(id) from person";
        Cursor c=db.rawQuery(q,null);
        if(c.moveToFirst())
        {
               if(c.getInt(0)==0)
               {
                   id=1;
               }
               else
               {
                   id=c.getInt(1);
                   id++;
               }
        }
        return id;
    }

    public void insert(Person P)
    {

        int id=auto_incr();
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("id",id);
        values.put("fname",P.getFname());
        values.put("lname",P.getLname());
        db.insert("person",null,values);
    }

    public List<Person> display()
    {
        List<Person> list=new ArrayList<Person>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from person",null);
        if(cursor.moveToFirst())
        {
            do {
                Person P=new Person();
                P.setId(cursor.getInt(0));
                P.setFname(cursor.getString(1));
                P.setLname(cursor.getString(2));
                list.add(P);
            }while (cursor.moveToNext());
        }
        return list;
    }
}
