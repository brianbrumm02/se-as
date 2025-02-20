package io.devexpert.enlaza2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_examen extends AppCompatActivity {

    private int puntaje = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);


        TextView pregunta = findViewById(R.id.pregunta);
        Button respuesta1 = findViewById(R.id.respuesta1);
        Button respuesta2 = findViewById(R.id.respuesta2);
        Button respuesta3 = findViewById(R.id.respuesta3);
        Button respuesta4 = findViewById(R.id.respuesta4);
        Button botonEnviar = findViewById(R.id.botonEnviar);


        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                puntaje++;
                Toast.makeText(activity_examen.this, "¡Correcto!", Toast.LENGTH_SHORT).show();
            }
        });

        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Respuesta incorrecta
                Toast.makeText(activity_examen.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            }
        });

        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Respuesta incorrecta
                Toast.makeText(activity_examen.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            }
        });

        respuesta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity_examen.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            }
        });
        Button regresarButton = findViewById(R.id.regresarButtonn);
        regresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para regresar al menú principal
                Intent intent = new Intent(activity_examen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensaje = "Tu puntaje es: " + puntaje + " de 1";
                Toast.makeText(activity_examen.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });

    }
}
