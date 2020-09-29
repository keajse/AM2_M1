package com.example.am2_m1_adaptadores_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.txtNombre);
        textView.setText(getIntent().getStringExtra("nombre"));

        ImageView imageView = findViewById(R.id.imagenview);

    }
}