package com.example.am2_m1_adaptadores_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listadobase extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadobase);

        listView = findViewById(R.id.lvcontacto);
        CargarListado();
    }

    private void CargarListado() {
        listado=ListaContactos();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,listado);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> ListaContactos() {
        ArrayList<String> datos = new ArrayList<String>();
        BaseDatos helper = new BaseDatos(this,"BDCONTACTO",null,1);
        SQLiteDatabase db= helper.getReadableDatabase();
        String sql = "Select Id,Nombres,Telefono From Contacto";
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst())
        {
            do{
                //String linea = c.getInt(0)+" "+c.getString(1)+" "+c.getString(2);
                String linea = c.getString(1)+" "+c.getString(2);
                datos.add(linea);
            }while (c.moveToNext());
        }
        db.close();
        return datos;
    }
}