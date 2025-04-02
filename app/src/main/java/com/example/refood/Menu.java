package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private ImageButton btnConfiguraciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnConfiguraciones = findViewById(R.id.btnConfiguraciones);

        btnConfiguraciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Configuraciones.class);
                startActivity(intent);
            }
        });
    }
}