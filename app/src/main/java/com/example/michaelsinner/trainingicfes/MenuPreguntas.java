package com.example.michaelsinner.trainingicfes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPreguntas extends AppCompatActivity implements View.OnClickListener
{
    Button btnAgregarPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_preguntas);
        btnAgregarPregunta = (Button) findViewById(R.id.btnAgregarPreguntas);
        btnAgregarPregunta.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnAgregarPreguntas:
                Intent puente4 = new Intent(MenuPreguntas.this,AgregarPreguntas.class);
                startActivity(puente4);
                break;
        }
    }
}
