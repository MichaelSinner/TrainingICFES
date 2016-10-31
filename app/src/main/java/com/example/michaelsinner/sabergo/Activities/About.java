package com.example.michaelsinner.sabergo.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.michaelsinner.sabergo.R;

public class About extends AppCompatActivity
{

    TextView tvAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tvAbout = (TextView) findViewById(R.id.tvComentario);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        tvAbout.setTypeface(fuente);
    }
}
