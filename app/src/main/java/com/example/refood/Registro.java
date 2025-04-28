package com.example.refood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;

public class Registro extends AppCompatActivity {
    // Declaración de variables
    ImageButton btnback;
    TextView btnsave;
    EditText etNombre, etApellido, etCorreo, etContrasena, etTelefono, etFecha, etGenero;
    RequestQueue requestQueue;
    private static final String URL1 = "http://Refood.42web.io/android/save.php"; // Cambiado a HTTPS
    private static final String TAG = "Registro"; // Tag para logs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Inicialización de Volley
        requestQueue = Volley.newRequestQueue(this);

        // Inicialización de vistas
        initViews();

        // Configuración del botón de guardar
        setupSaveButton();

        // Configuración del botón de atrás
        btnback.setOnClickListener(v -> onBackPressed());
    }

    private void initViews() {
        etNombre = findViewById(R.id.etnombre);
        etApellido = findViewById(R.id.etapellido);
        etCorreo = findViewById(R.id.etcorreo);
        etContrasena = findViewById(R.id.etcontrasena);
        etTelefono = findViewById(R.id.ettelefono);
        etFecha = findViewById(R.id.etfecha);
        etGenero = findViewById(R.id.etgenero);
        btnback = findViewById(R.id.btnatras);
        btnsave = findViewById(R.id.btnguardar);
    }

    private void setupSaveButton() {
        btnsave.setOnClickListener(v -> {
            // Obtener valores de los campos
            String nombre = etNombre.getText().toString().trim();
            String apellido = etApellido.getText().toString().trim();
            String correo = etCorreo.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();
            String telefono = etTelefono.getText().toString().trim();
            String fecha = etFecha.getText().toString().trim();
            String genero = etGenero.getText().toString().trim();

            // Validar campos
            if (!validateFields(nombre, apellido, correo, contrasena, telefono, fecha, genero)) {
                return;
            }

            // Enviar datos al servidor
            registerUser(nombre, apellido, correo, contrasena, telefono, fecha, genero);
        });
    }

    private boolean validateFields(String nombre, String apellido, String correo,
                                   String contrasena, String telefono, String fecha, String genero) {
        // Validar campos vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() ||
                contrasena.isEmpty() || telefono.isEmpty() || fecha.isEmpty() || genero.isEmpty()) {
            showToast("Todos los campos son obligatorios");
            return false;
        }

        // Validar formato de email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            showToast("Ingrese un correo electrónico válido");
            return false;
        }

        // Validar formato de teléfono (10 dígitos)
        if (!telefono.matches("\\d{10}")) {
            showToast("Teléfono debe contener exactamente 10 dígitos");
            return false;
        }

        return true;
    }

    private void registerUser(String nombre, String apellido, String correo,
                              String contrasena, String telefono, String fecha, String genero) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registrando...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        // Agregar logs para depuración
        Log.d(TAG, "Enviando solicitud a: " + URL1);
        Log.d(TAG, "Datos: nombre=" + nombre + ", apellido=" + apellido +
                ", correo=" + correo + ", telefono=" + telefono);

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                response -> handleResponse(response, progressDialog),
                error -> handleError(error, progressDialog)) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                headers.put("User-Agent", "RefoodApp/1.0 Android");
                // Agregar cabeceras CORS
                headers.put("Accept", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", nombre);
                params.put("apellido", apellido);
                params.put("correo", correo);
                params.put("contrasena", contrasena);
                params.put("telefono", telefono);
                params.put("fecha", fecha);
                params.put("genero", genero);
                // Opcional: parámetros que pueden ser útiles aunque no se usen
                params.put("tipodonacion", "");
                params.put("cantidad", "0");
                params.put("descripcion", "");
                return params;
            }
        };

        // Configurar una política de reintento más tolerante
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                15000,  // 15 segundos de timeout
                2,      // 2 reintentos máximos
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));

        // Añadir la solicitud a la cola
        requestQueue.add(stringRequest);
    }

    private void handleResponse(String response, ProgressDialog progressDialog) {
        progressDialog.dismiss();

        // Registrar la respuesta bruta para depuración
        Log.d(TAG, "Respuesta del servidor: " + response);

        // Verificar si la respuesta parece ser HTML en lugar de JSON
        if (response.contains("<") && response.contains(">")) {
            showToast("Error: El servidor ha devuelto una respuesta HTML en lugar de JSON");
            Log.e(TAG, "El servidor devolvió HTML en lugar de JSON: " + response);
            return;
        }

        try {
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.getString("status").equals("success")) {
                showToast(jsonResponse.getString("message"));
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                showToast("Error: " + jsonResponse.getString("message"));
            }
        } catch (JSONException e) {
            Log.e(TAG, "Error al analizar JSON", e);
            showToast("Error en formato de respuesta del servidor");
        }
    }

    private void handleError(VolleyError error, ProgressDialog progressDialog) {
        progressDialog.dismiss();
        String errorMsg = "Error de conexión";

        if (error.networkResponse != null) {
            errorMsg += " (Código: " + error.networkResponse.statusCode + ")";
            try {
                String responseBody = new String(error.networkResponse.data, "utf-8");
                Log.e(TAG, "Respuesta de error detallada: " + responseBody);
                showToast(errorMsg + ": " + responseBody);
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG, "Error al decodificar respuesta", e);
                showToast(errorMsg);
            }
        } else if (error instanceof TimeoutError) {
            Log.e(TAG, "Error de timeout");
            showToast("Tiempo de espera agotado. Verifica tu conexión");
        } else if (error instanceof NoConnectionError) {
            Log.e(TAG, "Error de conexión");
            showToast("No se pudo conectar al servidor. Verifica tu conexión a internet");
        } else if (error.getMessage() != null) {
            Log.e(TAG, "Error message: " + error.getMessage());
            showToast(errorMsg + ": " + error.getMessage());
        } else {
            Log.e(TAG, "Error desconocido de conexión", error);
            showToast(errorMsg);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}