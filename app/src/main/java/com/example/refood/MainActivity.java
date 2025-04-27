package com.example.refood;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




public class MainActivity extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageView logo;
    private static final int SPLASH_DURATION = 3000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ocultar la barra de navegación y la barra de estado para modo inmersivo
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Inicializar vistas
        backgroundImage = findViewById(R.id.background_image);
        logo = findViewById(R.id.logo);

        // Hacer las vistas visibles antes de animar
        backgroundImage.setVisibility(View.VISIBLE);
        logo.setVisibility(View.VISIBLE);

        // Cargar y empezar la animación del fondo
        Animation backgroundAnim = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        backgroundImage.startAnimation(backgroundAnim);

        // Delay corto antes de iniciar la animación del logo
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cargar y empezar la animación combinada del logo
                Animation logoAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.logo_animation);
                logo.startAnimation(logoAnim);
            }
        }, 300); // Pequeño retraso para que no empiecen exactamente al mismo tiempo

        // Configurar la transición a la siguiente actividad después del tiempo establecido
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, IniciarSesion.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);
    }
}