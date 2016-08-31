package com.example.michaelsinner.trainingicfes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener{

    Button btnAgregarPreguntas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnAgregarPreguntas = (Button) findViewById(R.id.btnAgregarPreguntas);
        btnAgregarPreguntas.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnAgregarPreguntas:
                Intent puente3 = new Intent(MenuPrincipal.this,MenuPreguntas.class);
                startActivity(puente3);
                break;
        }
    }
}
