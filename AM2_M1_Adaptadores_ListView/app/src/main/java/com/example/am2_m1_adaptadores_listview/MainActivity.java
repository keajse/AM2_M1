package com.example.am2_m1_adaptadores_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView myListView;
    private List<Modelo> mylist = new ArrayList<>();
    listAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.listView);
        myListView.setOnItemClickListener(this);

        mylist.add(new Modelo("San Francisco de Asís", "1181/1182 - 03/10/1226", R.drawable.sanfrancisco));
        mylist.add(new Modelo("Santo Padre Pio", "25/05/1887 - 23/09/1968", R.drawable.padrepio));
        mylist.add(new Modelo("Santa Madre Laura Montoya", "26/05/1974 - 21/10/1949", R.drawable.santalaura));
        mylist.add(new Modelo("San Juan Pablo II", "18/05/1920 - 02/04/2005", R.drawable.sanjuanpablo));
        mylist.add(new Modelo("San Josemaría Escrivá de Balaguer", "09/01/1902 - 26/06/1975", R.drawable.sanjosemaria));
        mylist.add(new Modelo("Santa Clara de Asis", "16/07/1194 - 11/08/1253", R.drawable.santaclara));
        mylist.add(new Modelo("San Antonio de Padua", "15/08/1195 - 13/06/1231", R.drawable.sanantonio));
        myadapter= new listAdapter(MainActivity.this,R.layout.item_row,mylist);
        myListView.setAdapter(myadapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "Elemento seleccionado: " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("nombre", myadapter.getItem(position).getNombre());
        intent.putExtra("imagenview", myadapter.getItem(position).getImagenview());
        startActivity(intent);
    }
}