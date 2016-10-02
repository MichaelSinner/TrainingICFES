package com.example.michaelsinner.trainingicfes;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AcercaDe extends AppCompatActivity
{

    TextView acercade;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        acercade = (TextView) findViewById(R.id.tvComentario);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        acercade.setTypeface(fuente);
    }


}
