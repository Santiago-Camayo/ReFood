package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Menu extends AppCompatActivity {

    Button btndonar,btnrecibir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btndonar = findViewById(R.id.botonDonar);
        btndonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donar = new Intent(Menu.this, Donador.class);
                startActivity(donar);
            }
        });
        btnrecibir = findViewById(R.id.botonrecibir);
        btnrecibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recibir = new Intent(Menu.this,Publicaciones.class);
                startActivity(recibir);
            }
        });

    }
}