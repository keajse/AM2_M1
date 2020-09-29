package com.example.am2_m1_adaptadores_listview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    String tabla = "CREATE TABLE CONTACTO (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRES TEXT, TELEFONO TEXT)";
    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE CONTACTO");
        db.execSQL(tabla);

    }
}

