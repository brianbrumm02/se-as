package io.devexpert.enlaza2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método para iniciar las lecciones (ya está como estaba)
    public void startLessons(View view) {
        Intent intent = new Intent(MainActivity.this, Leccion1Activity.class);
        startActivity(intent);
    }

    // Método para ir a la actividad Abecedario
    public void goToAbecedarioActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AbecedarioActivity.class); // Inicia AbecedarioActivity
        startActivity(intent);
    }
}
