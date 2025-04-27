package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Donador extends AppCompatActivity {

    // Referencias a los elementos de la interfaz
    private EditText establishmentName;    // Campo para el nombre del donante
    private EditText contactNumber;        // Campo para el número de contacto
    private EditText productDescription;   // Campo para la descripción de productos
    private EditText note;                 // Campo para notas adicionales
    private RadioGroup deliveryMethodGroup; // Grupo de radio buttons para método de entrega
    private Button btnSiguiente;           // Botón para enviar el formulario
    private String metodoEntrega = "";     // Almacena el método de entrega seleccionado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donador);

        // Inicializar referencias a las vistas del layout
        establishmentName = findViewById(R.id.establishmentName);
        contactNumber = findViewById(R.id.contactNumber);
        productDescription = findViewById(R.id.productDescription);
        note = findViewById(R.id.note);
        deliveryMethodGroup = findViewById(R.id.deliveryMethodGroup);
        btnSiguiente = findViewById(R.id.btnsiguiente);

        // Configurar listener para el grupo de radio buttons
        // Detecta cuando el usuario selecciona un método de entrega
        deliveryMethodGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.recojerenubi) {
                // Si selecciona "Recoger en ubicación"
                metodoEntrega = "Recoger en ubicación";
            } else if (checkedId == R.id.hacerenvio) {
                // Si selecciona "Envío a domicilio"
                metodoEntrega = "Envío a domicilio";
            }
        });

        // Configurar listener para el botón "Siguiente"
        btnSiguiente.setOnClickListener(v -> {
            // Verificar que todos los campos necesarios estén completos
            if (validateFields()) {
                // Crear un nuevo objeto Donacion con los datos ingresados
                Donacion nuevaDonacion = new Donacion(
                        establishmentName.getText().toString(),
                        contactNumber.getText().toString(),
                        productDescription.getText().toString(),
                        note.getText().toString(),
                        metodoEntrega
                );

                // Guardar la donación en la lista estática
                DonacionesData.ListaDonaciones.add(nuevaDonacion);

                // Mostrar mensaje de éxito
                Toast.makeText(this, "Donación registrada con éxito", Toast.LENGTH_SHORT).show();

                // Ir a la actividad de publicaciones
                startActivity(new Intent(Donador.this, Publicaciones.class));
                finish(); // Cerrar esta actividad
            }
        });
    }

    /**
     * Valida que los campos requeridos estén completos
     * @return true si todos los campos están completos, false en caso contrario
     */
    private boolean validateFields() {
        // Verificar que el nombre no esté vacío
        if (establishmentName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre del donante", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Verificar que el contacto no esté vacío
        if (contactNumber.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese un número de contacto", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Verificar que la descripción no esté vacía
        if (productDescription.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese una descripción", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Verificar que se haya seleccionado un método de entrega
        if (metodoEntrega.isEmpty()) {
            Toast.makeText(this, "Seleccione un método de entrega", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true; // Todos los campos están completos
    }
}