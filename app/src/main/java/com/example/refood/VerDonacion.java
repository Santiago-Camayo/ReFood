package com.example.refood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerDonacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_donacion);

        // Obtener los datos enviados desde la actividad anterior
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Extraer los datos de la donación
            String nombre = extras.getString("nombre", "");
            String contacto = extras.getString("contacto", "");
            String descripcion = extras.getString("descripcion", "");
            String nota = extras.getString("nota", "");
            String metodo = extras.getString("metodo", "");

            // Mostrar los datos en las vistas correspondientes
            ((TextView) findViewById(R.id.nombreDonante)).setText(nombre);
            ((TextView) findViewById(R.id.descripcionDonacion)).setText(descripcion);
            ((TextView) findViewById(R.id.webUbicacion)).setText(metodo);
            ((TextView) findViewById(R.id.emailContacto)).setText(contacto);

            // Configurar el botón de chat para abrir WhatsApp
            findViewById(R.id.botonChat).setOnClickListener(v -> {
                try {
                    // Intenta abrir WhatsApp con el número de contacto
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://wa.me/" + contacto));
                    startActivity(intent);
                } catch (Exception e) {
                    // Si falla, muestra un mensaje de error
                    Toast.makeText(this, "No se pudo abrir WhatsApp", Toast.LENGTH_SHORT).show();
                }
            });

            // Configurar el botón de llamar para abrir el marcador telefónico
            findViewById(R.id.botonLlamar).setOnClickListener(v -> {
                // Abrir el marcador con el número de contacto
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + contacto));
                startActivity(intent);
            });
        }
    }
}