package com.example.refood;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class editar_perfil extends Configuraciones {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextContactNumber;
    private EditText editTextAddress;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

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

            // Aquí puedes agregar la lógica para guardar los datos editados.
            // Por ejemplo, puedes guardarlos en una base de datos o enviarlos a un servidor.

            Toast.makeText(editar_perfil.this, "Perfil actualizado", Toast.LENGTH_SHORT).show();
        });
    }
}