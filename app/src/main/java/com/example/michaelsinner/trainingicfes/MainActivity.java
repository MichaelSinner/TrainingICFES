package com.example.michaelsinner.trainingicfes;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnEntrar;
    Button btnAcercaDe;
    TextView tvTitulo;
    MediaPlayer mp1,mp2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp1 = MediaPlayer.create(this,R.raw.audio_buton);
        mp2 = MediaPlayer.create(this,R.raw.audio_button2);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp1.start();
                Intent toLogin = new Intent(MainActivity.this,Login.class);
                startActivity(toLogin);
            }
        });

        btnAcercaDe = (Button) findViewById(R.id.btnAcercaDe);
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                Intent toAcercaDe = new Intent(MainActivity.this,AcercaDe.class);
                startActivity(toAcercaDe);
            }
        });

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        tvTitulo.setTypeface(fuente);



    }




}
