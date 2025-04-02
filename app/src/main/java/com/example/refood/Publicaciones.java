package com.example.refood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Publicaciones extends AppCompatActivity {
    CardView publicacion1;
    CardView publicacion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);

        publicacion1 = findViewById(R.id.publicacion1);
        publicacion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent publicacion1Intent = new Intent(Publicaciones.this, VerDonacion.class);
                startActivity(publicacion1Intent);
            }
        });

        // Optionally add click listener for publicacion2 as well
        publicacion2 = findViewById(R.id.publicacion2);
        // Add click listener if needed
    }
}