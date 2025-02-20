package io.devexpert.enlaza2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ExamenVocabularioActivity extends AppCompatActivity {

    private int currentVocalIndex = 0;
    private int score = 0;

    private ImageView imageViewVocal;
    private ProgressBar progressBar;
    private RadioGroup radioGroupOptions;
    private TextView examTitle;
    private Button btnSubmitAnswer;

    private String[] vocales = {"A", "E", "I", "O", "U"};
    private int[] images = {
            R.drawable.vocal_a, R.drawable.vocal_e, R.drawable.vocal_i, R.drawable.vocal_o, R.drawable.vocal_u
    };
    private String[] correctAnswers = {"A", "E", "I", "O", "U"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_vocabulario);

        // Inicializar las vistas
        imageViewVocal = findViewById(R.id.imageViewVocal);
        progressBar = findViewById(R.id.progressBar);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        examTitle = findViewById(R.id.examTitle);
        btnSubmitAnswer = findViewById(R.id.btnSubmitAnswer);

        // Inicializar con la primera vocal
        updateVocal();

        // Configurar el botón para enviar respuesta
        btnSubmitAnswer.setOnClickListener(view -> submitAnswer());
    }

    private void updateVocal() {
        // Actualizar la imagen de la vocal
        imageViewVocal.setImageResource(images[currentVocalIndex]);
        // Cambiar el título del examen
        examTitle.setText("¿Cuál es esta letra?");
        // Actualizar el progreso
        progressBar.setProgress((int) ((currentVocalIndex + 1) / (float) vocales.length * progressBar.getMax()));

        // Verificar el progreso (opcional, para depuración)
        Toast.makeText(this, "Progreso: " + (currentVocalIndex + 1) + "/5", Toast.LENGTH_SHORT).show();
    }

    private void submitAnswer() {
        // Obtener el ID de la opción seleccionada
        int selectedRadioButtonId = radioGroupOptions.getCheckedRadioButtonId();
        if (selectedRadioButtonId == -1) {
            // No se seleccionó ninguna respuesta
            Toast.makeText(this, "Por favor, selecciona una opción", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtener la respuesta seleccionada
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String selectedAnswer = selectedRadioButton.getText().toString();

        // Verificar si la respuesta es correcta
        if (selectedAnswer.equals(correctAnswers[currentVocalIndex])) {
            score++;  // Incrementar la puntuación si la respuesta es correcta
        }

        // Avanzar al siguiente examen
        if (currentVocalIndex < vocales.length - 1) {
            currentVocalIndex++;
            updateVocal();  // Actualizar la vocal y el progreso
        } else {
            // Examen terminado, mostrar puntuación
            Toast.makeText(this, "Examen terminado. Puntuación: " + score + "/5", Toast.LENGTH_LONG).show();
            finish();  // Cierra la actividad
        }
    }
}
