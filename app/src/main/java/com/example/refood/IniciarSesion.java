package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class IniciarSesion extends AppCompatActivity {

    private TextInputLayout contenedorEmail;
    private TextInputLayout contenedorPassword;
    private TextInputEditText campoEmail;
    private TextInputEditText campoPassword;
    private MaterialButton botonIniciarSesion;
    private MaterialButton botonRegistrarse;
    private MaterialButton botonOlvidoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        contenedorEmail = findViewById(R.id.email_layout);
        contenedorPassword = findViewById(R.id.password_layout);
        campoEmail = findViewById(R.id.email_edit_text);
        campoPassword = findViewById(R.id.password_edit_text);
        botonIniciarSesion = findViewById(R.id.login_button);
        botonRegistrarse = findViewById(R.id.register_button);
        botonOlvidoPassword = findViewById(R.id.forgot_password_button);

        // El listener del botón solo llama a intentarIniciarSesion
        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentarIniciarSesion();
            }
        });

        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(IniciarSesion.this, Registro.class);
                startActivity(registro);
            }
        });

        botonOlvidoPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegación a la pantalla de recuperación de contraseña
                Toast.makeText(IniciarSesion.this, "Recuperación de contraseña", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void intentarIniciarSesion() {
        // Limpiar errores anteriores
        contenedorEmail.setError(null);
        contenedorPassword.setError(null);

        String email = campoEmail.getText().toString().trim();
        String password = campoPassword.getText().toString().trim();

        boolean cancelar = false;
        View vistaEnfocada = null;

        // Validar contraseña
        if (password.isEmpty()) {
            contenedorPassword.setError(getString(R.string.error_field_required));
            vistaEnfocada = campoPassword;
            cancelar = true;
        }

        // Validar email
        if (email.isEmpty()) {
            contenedorEmail.setError(getString(R.string.error_field_required));
            vistaEnfocada = campoEmail;
            cancelar = true;
        } else if (!esEmailValido(email)) {
            contenedorEmail.setError(getString(R.string.error_invalid_email));
            vistaEnfocada = campoEmail;
            cancelar = true;
        }

        if (cancelar) {
            // Hay errores, enfoca el primer campo con error
            vistaEnfocada.requestFocus();
        } else {
            // Si no hay errores, se llama directamente a navegarAlMenu()
            navegarAlMenu();
        }
    }

    private boolean esEmailValido(String email) {
        // Puedes mejorar esta validación
        return email.contains("@") && email.contains(".");
    }

    private void navegarAlMenu() {
        // Crea un Intent para iniciar la actividad Menu
        Intent menu = new Intent(IniciarSesion.this, Menu.class);
        startActivity(menu);
        finish(); // Opcional: Cierra la actividad actual para que el usuario no pueda volver atrás con el botón "atrás"
    }
}