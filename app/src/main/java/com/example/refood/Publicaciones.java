package com.example.refood;

import android.annotation.SuppressLint;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;


public class Publicaciones extends AppCompatActivity {

    ImageButton btnconfiguracion,btneditperfil,btncasa;
    private RecyclerView recyclerView;     // RecyclerView para mostrar las donaciones
    private DonacionAdapter adapter;       // Adaptador para el RecyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);

        // Inicializar el RecyclerView
        recyclerView = findViewById(R.id.listaalimentos);

        // Configurar el LayoutManager (cómo se muestran los elementos)
        // GridLayoutManager con 2 columnas crea una cuadrícula de 2 columnas
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Crear y configurar el adaptador con la lista de donaciones
        adapter = new DonacionAdapter(this, DonacionesData.ListaDonaciones);
        recyclerView.setAdapter(adapter);





        btnconfiguracion =findViewById(R.id.btnConfiguraciones);
        btnconfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confi = new Intent(Publicaciones.this, Configuraciones.class);
                startActivity(confi);
            }
        });
        btneditperfil =findViewById(R.id.btnperfil);
        btneditperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(Publicaciones.this, MisDonaciones.class);
                startActivity(profile);
            }
        });

        btncasa = findViewById(R.id.btnhome);
        btncasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent casa = new Intent(Publicaciones.this, Menu.class);
                startActivity(casa);
            }
        });


    }
}

