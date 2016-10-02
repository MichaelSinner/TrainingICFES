package com.example.michaelsinner.trainingicfes;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity{

    TextView tvTitulo;
    Button btnMenuPreguntas, btnIniciarPartida, btnLogros, btnMenuEstudiantes ;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        mp = MediaPlayer.create(this,R.raw.audio_button4);

        btnMenuPreguntas = (Button) findViewById(R.id.btnMenuPreguntas);
        btnMenuPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toMenuPreguntas = new Intent(MenuPrincipal.this, MenuPreguntas.class);
                startActivity(toMenuPreguntas);
            }
        });

        btnIniciarPartida = (Button) findViewById(R.id.btnIniciar);
        btnIniciarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toIniciarPartida = new Intent(MenuPrincipal.this, MenuPartida.class);
                startActivity(toIniciarPartida);
            }
        });

        btnMenuEstudiantes = (Button) findViewById(R.id.btnMenuEstudiantes);
        btnMenuEstudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toMenuEstudiantes = new Intent(MenuPrincipal.this, MenuEstudiante.class);
                startActivity(toMenuEstudiantes);
            }
        });

        btnLogros = (Button) findViewById(R.id.btnVerLogros);
        btnLogros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toLogros = new Intent(MenuPrincipal.this, Logros.class);
                startActivity(toLogros);
            }
        });


        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        tvTitulo.setTypeface(fuente);
    }


}
