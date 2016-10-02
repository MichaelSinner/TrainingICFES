package com.example.michaelsinner.trainingicfes;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuEstudiante extends AppCompatActivity
{
    TextView tvTitulo;
    Button btnAgregarEstudiante, btnEditarEstudiante, btnEliminarEstudiante;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_estudiante);

        mp = MediaPlayer.create(this, R.raw.audio_button4);

        btnAgregarEstudiante = (Button) findViewById(R.id.btnAgregarEstudiante);
        btnAgregarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();

            }
        });

        btnEditarEstudiante = (Button) findViewById(R.id.btnEditarEstudiante);
        btnEditarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toEditarEstudiante = new Intent(MenuEstudiante.this,EditarEstudiante.class);
                startActivity(toEditarEstudiante);

            }
        });

        btnEliminarEstudiante = (Button) findViewById(R.id.btnEliminarEstudiante);
        btnEliminarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toEliminarEstudiante = new Intent(MenuEstudiante.this,EliminarEstudiante.class);
                startActivity(toEliminarEstudiante);

            }
        });
    }
}
