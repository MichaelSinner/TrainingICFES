package com.example.michaelsinner.sabergo;


import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.michaelsinner.sabergo.Activities.About;
import com.example.michaelsinner.sabergo.Activities.Login;
import com.example.michaelsinner.sabergo.Activities.SignUp;
import com.example.michaelsinner.sabergo.Data.AdministradorDBHelper;

public class Main extends AppCompatActivity
{
    Button btnEntrar;
    Button btnAcercaDe;
    Button btnRegistrar;
    TextView tvTitulo;
    MediaPlayer mp1,mp2;
    AdministradorDBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp1 = MediaPlayer.create(this,R.raw.audio_buton);
        mp2 = MediaPlayer.create(this,R.raw.audio_button2);

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        tvTitulo.setTypeface(fuente);





        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp1.start();
                Intent toLogin = new Intent(Main.this, Login.class);
                startActivity(toLogin);
            }
        });

        btnAcercaDe = (Button) findViewById(R.id.btnAcercaDe);
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                Intent toAcercaDe = new Intent(Main.this,About.class);
                startActivity(toAcercaDe);
            }
        });

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                Intent toSIgunup = new Intent(Main.this, SignUp.class);
                startActivity(toSIgunup);
            }
        });





    }


}

