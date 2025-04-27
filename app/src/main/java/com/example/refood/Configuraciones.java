package com.example.refood;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Configuraciones extends AppCompatActivity {

    private Switch switchNotificaciones;

    ImageButton botonhome,btneditperfil;

    View editarperfil;
    LinearLayout btnelminarperfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuraciones);

        switchNotificaciones = findViewById(R.id.switch_notificaciones);


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
        btneditperfil = findViewById(R.id.btnperfil);
        btneditperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Configuraciones.this, MisDonaciones.class);
                startActivity(intent);
            }
        });

        botonhome = findViewById(R.id.homeButton);
        botonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Configuraciones.this, Menu.class);
                startActivity(intent);
            }
        });

        editarperfil = findViewById(R.id.Texteditarperfil);
        editarperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Configuraciones.this, MisDonaciones.class);
                startActivity(intent);
            }
        });

        btnelminarperfil=findViewById(R.id.btnelminarperfil);
        btnelminarperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogoconfirmacion();
            }
        });

    }
    private void Dialogoconfirmacion() {
        new AlertDialog.Builder(this)
                .setTitle("Eliminar cuenta") // Título del diálogo
                .setMessage("¿Estás seguro de que quieres eliminar tu cuenta? Esta acción es irreversible y perderás todos tus datos asociados.") // Mensaje
                .setPositiveButton("Sí, eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // --- EL USUARIO HIZO CLIC EN "SÍ, ELIMINAR" ---
                        Log.d("Configuraciones", "Usuario confirmó eliminación.");

                        // *** --- PUNTO DE INTEGRACIÓN PARA TU AMIGO --- ***
                        // *** Aquí es donde tu amigo DEBE agregar el código para llamar al backend ***
                        // *** usando Volley para eliminar la cuenta en la base de datos SQL.    ***
                        // *** Una vez que la eliminación en el backend sea exitosa, DEBE:      ***
                        // *** 1. Limpiar los datos de sesión locales del usuario en la app.      ***
                        // *** 2. Redirigir al usuario a la pantalla de inicio de sesión/principal.***
                        // ***************************************************************************

                        Toast.makeText(Configuraciones.this, "Procediendo a eliminar cuenta...", Toast.LENGTH_SHORT).show();
                        // Llama a la función real de eliminación aquí (que tu amigo implementará)
                        // Por ahora, solo mostraremos un log/toast indicando que la acción ocurriría.
                        Log.i("Configuraciones", "!!! Llama a la función de eliminación del backend AQUÍ !!!");
                        // Ejemplo: deleteAccountInBackendUsingVolley(); // <-- Tu amigo implementará esta llamada
                    }
                })
                .setNegativeButton("No, cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // --- EL USUARIO HIZO CLIC EN "NO, CANCELAR" ---
                        Log.d("Configuraciones", "Usuario canceló eliminación.");
                        dialog.dismiss(); // Cierra el diálogo sin hacer nada más
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert) // Opcional: un icono de advertencia
                .show(); // Muestra el diálogo
    }
}