package com.example.am2_m1_adaptadores_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class listAdapter extends ArrayAdapter<Modelo> {

    private List<Modelo> myList;
    private Context myContext;
    private int resourceLayout;

    public listAdapter(@NonNull Context context, int resource, List<Modelo> objects) {
        super(context, resource, objects);

        this.myList = objects;
        this.myContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null)
            view = LayoutInflater.from(myContext).inflate(resourceLayout, null);

        Modelo modelo = myList.get(position);

        ImageView imageView = view.findViewById(R.id.imagenview);
        imageView.setImageResource(modelo.getImagenview());

        TextView textoNombre = view.findViewById(R.id.textvnombre);
        textoNombre.setText(modelo.getNombre());

        TextView textoFcha = view.findViewById(R.id.txtvfchNacimiento);
        textoFcha.setText(modelo.getFchNacimiento());

        return view;
    }
}
