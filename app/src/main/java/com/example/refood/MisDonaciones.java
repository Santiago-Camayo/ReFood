package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MisDonaciones extends AppCompatActivity {

    ImageButton btnconfiguracion,btnmisdonaciones,btncasa;
    ListView listaproductos;

    String [] donaciones ={"Donacion1","Donacion2","donacion3","donacion4","donacion5","donacion6","donacion7"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_donaciones);

        btnconfiguracion =findViewById(R.id.btnConfiguraciones);
        btnconfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confi = new Intent(MisDonaciones.this, Configuraciones.class);
                startActivity(confi);
            }
        });
        btnmisdonaciones =findViewById(R.id.btnperfil);
        btnmisdonaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(MisDonaciones.this, MisDonaciones.class);
                startActivity(profile);
            }
        });

        btncasa = findViewById(R.id.btnhome);
        btncasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent casa = new Intent(MisDonaciones.this, Menu.class);
                startActivity(casa);
            }
        });

        listaproductos =findViewById(R.id.listproductos);
        ArrayAdapter<String>  adaplistproductos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,donaciones);
        listaproductos.setAdapter(adaplistproductos);


    }
}

