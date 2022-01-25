package com.example.proyecto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyecto.adaptadores.CustomAdapter;
import com.example.proyecto.entity.Musica;

import java.util.ArrayList;

public class CommunityFragment extends Fragment {

    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    ArrayList<Musica> listaMusica;
    public CommunityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        recyclerView = view.findViewById(R.id.ListRecycleview);
        listaMusica = new ArrayList<>();
        cargarlist();
        mostrar_data();
        return view;

    }

    private void mostrar_data() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        customAdapter = new CustomAdapter(getContext(),listaMusica);
        recyclerView.setAdapter(customAdapter);
        customAdapter.aetOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre= listaMusica.get(recyclerView.getChildAdapterPosition(view)).getNombre();
                Toast.makeText(getContext() , "selecciono:"+nombre, Toast.LENGTH_SHORT ).show();
            }
        } );

    }

    public void cargarlist(){
        listaMusica.add(new Musica("muse", "descripcion",R.drawable.muse));
        listaMusica.add(new Musica("ADCD", "descripcion",R.drawable.acdc));
        listaMusica.add(new Musica("Aerosmith", "descripcion",R.drawable.aerosmith));
        listaMusica.add(new Musica("Axel_rose", "descripcion",R.drawable.axel_rose));
        listaMusica.add(new Musica("can'stop", "descripcion",R.drawable.red_hot_chili_peppers));
        listaMusica.add(new Musica("twisted", "descripcion",R.drawable.twisted_sister));
    }
}