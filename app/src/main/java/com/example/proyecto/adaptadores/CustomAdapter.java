package com.example.proyecto.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.R;
import com.example.proyecto.entity.Musica;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements View.OnClickListener{
    LayoutInflater inflater;
    ArrayList<Musica> model;
    private  View.OnClickListener listener;
    public CustomAdapter(Context context, ArrayList<Musica>model){
        this.inflater = LayoutInflater.from( context );
        this.model = model;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_view, parent, false );
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void aetOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getNombre();
        String descripcion = model.get(position).getDescripcion();
        int imagen = model.get(position).getImagenid();
        holder.nombres.setText(nombre);
        holder.descripcion.setText(descripcion);
        holder.imagen.setImageResource(imagen);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombres,descripcion;
        ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            nombres = itemView.findViewById(R.id.titulo);
            descripcion = itemView.findViewById(R.id.descripcion);
            imagen = itemView.findViewById(R.id.imagen_music);
        }
    }
}
