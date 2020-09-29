package com.example.am2_m1_adaptadores_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class formulario extends AppCompatActivity {

    EditText etnombres,ettelefono;
    Button btnguardar,btnlistar,btnbuscar,btnactualizar,btneliminar, btnejadapterlist;
    BaseDatos helper = new BaseDatos(this,"BDCONTACTO",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        etnombres=findViewById(R.id.etnombres);
        ettelefono=findViewById(R.id.ettelefono);
        btnguardar=findViewById(R.id.btnguardar);
        btnbuscar=findViewById(R.id.btnbuscar);
        btnactualizar=findViewById(R.id.btnactualizar);
        btneliminar=findViewById(R.id.btneliminar);
        btnlistar=findViewById(R.id.btnlistar);
        btnejadapterlist= findViewById(R.id.btnejadapterlist);

        btnejadapterlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(formulario.this,MainActivity.class));

            }
        });

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(etnombres.getText().toString(), ettelefono.getText().toString());
            }
        });

        btnlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(formulario.this,listadobase.class));

            }
        });

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(etnombres.getText().toString());
            }
        });

        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase obde = helper.getWritableDatabase();
                obde.execSQL("UPDATE Contacto SET TELEFONO = '"+ettelefono.getText().toString()+"' WHERE Nombres = '"+etnombres.getText().toString()+"'");
                Toast.makeText(getApplicationContext(),"Contacto Actualizado correctamente...",Toast.LENGTH_SHORT).show();
            }
        });

        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(formulario.this);
                alertDialogBuilder.setMessage("Eliminación de Contactos");
                alertDialogBuilder.setPositiveButton("Sí",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                SQLiteDatabase obde = helper.getWritableDatabase();
                                obde.execSQL("DELETE FROM Contacto WHERE Nombres = '"+etnombres.getText().toString()+"'");
                                Toast.makeText(getApplicationContext(),"Contacto Eliminado correctamente...",Toast.LENGTH_SHORT).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                /*SQLiteDatabase obde = odb.getWritableDatabase();
                obde.execSQL("DELETE FROM Contacto WHERE Nombres = '"+etnombres.getText().toString()+"'");
                Toast.makeText(getApplicationContext(),"Contacto Eliminado correctamente...",Toast.LENGTH_SHORT).show();
                */
            }
        });
    }

    private void guardar(String Nombres, String Telefono) {
        //BaseDatos helper = new BaseDatos(this,"BDCONTACTO",null,1);
        SQLiteDatabase db= helper.getWritableDatabase();
        try //Manejo de excepciones
        {
            //Contenedor de datos del contacto
            ContentValues c = new ContentValues();
            c.put("Nombres",Nombres);
            c.put("Telefono",Telefono);
            db.insert("CONTACTO",null,c);
            db.close();
            Toast.makeText(this,"Contacto agregado correctamente...",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e)
        {
            Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }

    private void buscar (String toString){
        ArrayList<String> datosb = new ArrayList<String>();
        //BaseDatos helper = new BaseDatos(this,"BDCONTACTO",null,1);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "Select Nombres,Telefono From Contacto Where Nombres = '"+etnombres.getText().toString()+"'";
        Cursor ccont = db.rawQuery(sql,null);
        if (ccont.moveToFirst())
        {
            ettelefono.setText(ccont.getString(1));
        }
        else
        {
            Toast.makeText(this,"Contacto NO Existe!",Toast.LENGTH_SHORT).show();
        }
    }
}