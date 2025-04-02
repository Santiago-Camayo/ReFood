package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Donador extends AppCompatActivity {
    Button btnsiguiente;
    ImageButton btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donador);
        btnsiguiente = findViewById(R.id.btnsiguiente);
        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(Donador.this, MisDonaciones.class);
                startActivity(siguiente);
            }
        });

        btnvolver = findViewById(R.id.btnatras);
        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras = new Intent(Donador.this, Menu.class);
                startActivity(atras);
            }
        });


    }
}