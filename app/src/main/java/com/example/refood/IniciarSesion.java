package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class IniciarSeccion extends AppCompatActivity {

    ImageButton btnback;
    Button btnsiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_seccion);

        btnback = findViewById(R.id.btnatras);
        btnsiguiente = findViewById(R.id.btningresar);
        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(IniciarSeccion.this, Menu.class);
                startActivity(siguiente);

            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(IniciarSeccion.this, MainActivity.class);
                startActivity(back);

            }
        });

    }
}