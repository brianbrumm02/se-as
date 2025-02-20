package io.devexpert.enlaza2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_leccion3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leccion3);


        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.leccion3_video;  // Asegúrate de tener este archivo en 'raw'
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();


        Button regresarButton = findViewById(R.id.regresarButtonn);
        regresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_leccion3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Button iniciarExamenButton = findViewById(R.id.iniciarExamenButton);
        iniciarExamenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_leccion3.this, activity_examen.class);
                startActivity(intent);  // Iniciar la actividad del examen
            }
        });
    }

    // Método para ir a la siguiente lección (si es necesario)
    public void goToNextLesson(View view) {
        // Puedes agregar aquí la lógica para ir a la siguiente lección si corresponde
    }
}

