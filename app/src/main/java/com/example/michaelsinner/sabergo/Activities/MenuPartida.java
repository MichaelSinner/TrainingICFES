package com.example.michaelsinner.sabergo.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.michaelsinner.sabergo.R;

public class MenuPartida extends AppCompatActivity
{
    Button btnIniciarPartida, btnSimulacro, btnAsteroides;
    TextView tvTitulo;
    MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_partida);
        mp = MediaPlayer.create(this,R.raw.audio_button4);

        btnIniciarPartida = (Button) findViewById(R.id.btnIniciar);
        btnIniciarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toPartidaDiagnostico = new Intent(MenuPartida.this, Diagnostico.class);
                startActivity(toPartidaDiagnostico);
            }
        });

        btnSimulacro = (Button) findViewById(R.id.btnSimulacro);
        btnSimulacro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent toPartidaSimulacro = new Intent(MenuPartida.this , Simulacro.class);
                startActivity(toPartidaSimulacro);
            }
        });

        btnAsteroides = (Button) findViewById(R.id.btnAsteroides);
        btnAsteroides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();

            }
        });

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        tvTitulo.setTypeface(fuente);
    }



}
