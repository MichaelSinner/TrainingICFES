package com.example.michaelsinner.trainingicfes;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuPreguntas extends AppCompatActivity
{
    Button btnAgregarPregunta, btnEditarPregunta, btnEliminarPregunta;
    MediaPlayer mp;
    TextView tvTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_preguntas);

        mp = MediaPlayer.create(this,R.raw.audio_button4);

        btnAgregarPregunta = (Button) findViewById(R.id.btnAgregarPreguntas);
        btnAgregarPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toAgregarPregunta = new Intent(MenuPreguntas.this,AgregarPreguntas.class);
                startActivity(toAgregarPregunta);
            }
        });

        btnEditarPregunta = (Button) findViewById(R.id.btnEditarPreguntas);
        btnEditarPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toEditarPregunta = new Intent(MenuPreguntas.this, EditarPregunta.class);
                startActivity(toEditarPregunta);
            }
        });

        btnEliminarPregunta = (Button) findViewById(R.id.btnEliminarPreguntas);
        btnEliminarPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toEliminarPregunta = new Intent(MenuPreguntas.this, EliminarPregunta.class);
                startActivity(toEliminarPregunta);
            }
        });

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        tvTitulo.setTypeface(fuente);
    }


}
