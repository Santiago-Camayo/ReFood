package com.example.refood;

import android.annotation.SuppressLint;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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


public class Publicaciones extends AppCompatActivity {
    CardView btnpublicacion1;
    CardView btnpublicacion2;
    ImageButton btnconfiguracion,btneditperfil,btncasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);

        btnpublicacion1 = findViewById(R.id.publicacion1);
        btnpublicacion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent publicacion1= new Intent(Publicaciones.this, VerDonacion.class);
                startActivity(publicacion1);
            }
        });

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
                Intent profile = new Intent(Publicaciones.this, EditaPerfil.class);
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

