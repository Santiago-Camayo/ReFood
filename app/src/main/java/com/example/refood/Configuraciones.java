package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Configuraciones extends AppCompatActivity {

    private Switch switchNotificaciones;

    ImageButton botonhome,btneditperfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuraciones);

        switchNotificaciones = findViewById(R.id.switch_notificaciones);
        btneditperfil = findViewById(R.id.btnperfil);
        botonhome = findViewById(R.id.homeButton);

        // Establecer un listener para el Switch
        switchNotificaciones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Notificaciones encendidas
                    Toast.makeText(Configuraciones.this, "Notificaciones encendidas", Toast.LENGTH_SHORT).show();
                } else {
                    // Notificaciones apagadas
                    Toast.makeText(Configuraciones.this, "Notificaciones apagadas", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btneditperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Configuraciones.this, MisDonaciones.class);
                startActivity(intent);
            }
        });

        // Manejar el clic para volver al menú
        botonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Configuraciones.this, android.R.menu.class); // Reemplaza MainActivity con la clase de tu menú principal
                startActivity(intent);
            }
        });
    }
}