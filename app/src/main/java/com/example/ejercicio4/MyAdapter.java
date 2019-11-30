package com.example.ejercicio4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{


    private Context context;
    private ArrayList<Imagen> Elementos;

    public MyAdapter(Context context, ArrayList<Imagen> elementos){
        super();
        this.Elementos = elementos;
        this.context = context;
    }


    @Override
    public int getCount() {
        return Elementos.size();
    }

    @Override
    public Object getItem(int position) {
        return Elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Elementos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = LayoutInflater.from(context).
                inflate(R.layout.two_lines,parent,false);

        TextView name = rowView.findViewById(R.id.Name);
        TextView id = rowView.findViewById(R.id.Id);
        TextView price = rowView.findViewById(R.id.price);
        TextView provider = rowView.findViewById(R.id.provider);
        TextView delivery = rowView.findViewById(R.id.Delivery);

        ImageView icon = rowView.findViewById(R.id.imagen);

        name.setText(Elementos.get(position).getName());
        Integer _id = Elementos.get(position).getId();
        id.setText(Integer.toString(_id));
        price.setText(String.valueOf(Elementos.get(position).getPrice()));
        provider.setText(Elementos.get(position).getProvider());

        Picasso.get().load(Elementos.get(position).getThumb_url()).into(icon);

        return rowView;
    }
}
