package io.devexpert.enlaza2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AbecedarioActivity extends AppCompatActivity {

    private int currentVocalIndex = 0; // Índice para las vocales
    private TextView textViewVocal;
    private ImageView imageViewVocal;
    private ProgressBar progressBar;
    private Button btnNextVocal;

    // Listas de vocales y las imágenes correspondientes
    private String[] vocales = {"A", "E", "I", "O", "U"};
    private int[] images = {
            R.drawable.vocal_a, R.drawable.vocal_e, R.drawable.vocal_i, R.drawable.vocal_o, R.drawable.vocal_u
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abecedario);

        // Inicializar las vistas
        textViewVocal = findViewById(R.id.textViewVocal);
        imageViewVocal = findViewById(R.id.imageViewVocal);
        progressBar = findViewById(R.id.progressBar);
        btnNextVocal = findViewById(R.id.btnNextVocal);

        // Inicializamos con la primera vocal
        updateVocal();

        // Configuramos el botón "Siguiente" para avanzar entre las vocales
        btnNextVocal.setOnClickListener(view -> {
            if (currentVocalIndex < vocales.length - 1) {
                currentVocalIndex++;
                updateVocal();
            } else {
                // Iniciar el examen después de terminar con las vocales
                Intent intent = new Intent(AbecedarioActivity.this, ExamenVocabularioActivity.class);
                startActivity(intent);
                finish();  // Cierra la actividad actual
            }
        });
    }

    // Método para actualizar la letra, la imagen y la barra de progreso
    private void updateVocal() {
        textViewVocal.setText(vocales[currentVocalIndex]);
        imageViewVocal.setImageResource(images[currentVocalIndex]);
        progressBar.setProgress((int) ((currentVocalIndex + 1) / (float) vocales.length * progressBar.getMax()));


    }
}

