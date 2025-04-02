package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class EditaPerfil extends Configuraciones {

ImageButton btncasa,btnconfiguracion,btneditperfil;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextContactNumber;
    private EditText editTextAddress;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarperfil);

        editTextAddress = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextContactNumber = findViewById(R.id.editTextContactNumber);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String contactNumber = editTextContactNumber.getText().toString();
            String address = editTextAddress.getText().toString();



            Toast.makeText(EditaPerfil.this, "Perfil actualizado", Toast.LENGTH_SHORT).show();
        });
        btnconfiguracion = findViewById(R.id.btnConfiguraciones);
        btnconfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent configuraciones = new Intent(EditaPerfil.this, Configuraciones.class);
                startActivity(configuraciones);
            }
        });

       btncasa =findViewById(R.id.imgcasa);
        btnconfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent casa = new Intent(EditaPerfil.this, Menu.class);
                startActivity(casa);
            }
        });

    }
}