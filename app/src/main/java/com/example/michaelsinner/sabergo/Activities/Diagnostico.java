package com.example.michaelsinner.sabergo.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.michaelsinner.sabergo.R;

public class Diagnostico extends AppCompatActivity
{

    CheckBox cbxOpcionA, cbxOpcionB, cbxOpcionC, cbxOpcionD;
    MediaPlayer mp;
    Button btnAceptar;
    int seleccion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);


        cbxOpcionA = (CheckBox) findViewById(R.id.cbxOpcionA);
        cbxOpcionA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(cbxOpcionA.isChecked())
                {
                    cbxOpcionB.setChecked(false);
                    cbxOpcionC.setChecked(false);
                    cbxOpcionD.setChecked(false);
                    seleccion = 1;
                }
            }
        });



        cbxOpcionB = (CheckBox) findViewById(R.id.cbxOpcionB);
        cbxOpcionB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(cbxOpcionB.isChecked())
                {
                    cbxOpcionA.setChecked(false);
                    cbxOpcionC.setChecked(false);
                    cbxOpcionD.setChecked(false);
                    seleccion = 2;
                }
            }
        });

        cbxOpcionC = (CheckBox) findViewById(R.id.cbxOpcionC);
        cbxOpcionC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(cbxOpcionC.isChecked())
                {
                    cbxOpcionA.setChecked(false);
                    cbxOpcionB.setChecked(false);
                    cbxOpcionD.setChecked(false);
                    seleccion = 3;
                }
            }
        });
        cbxOpcionD = (CheckBox) findViewById(R.id.cbxOpcionD);
        cbxOpcionD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cbxOpcionD.isChecked())
                {
                    cbxOpcionA.setChecked(false);
                    cbxOpcionB.setChecked(false);
                    cbxOpcionC.setChecked(false);
                    seleccion = 4;
                }
            }
        });

        mp = MediaPlayer.create(this, R.raw.audio_button3);

        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                if(validarRespuesta(seleccion)) {
                    Intent toResultado = new Intent(Diagnostico.this, MenuPartida.class);
                    startActivity(toResultado);
                }else{
                    Toast toastLoginError = Toast.makeText(getApplicationContext(),"Respuesta erronea",Toast.LENGTH_LONG);
                    toastLoginError.show();

                }

            }
        });

    }

    public boolean validarRespuesta(int seleccion)
    {
        boolean respuesta;
        if (seleccion == 3){
            respuesta = true;
        }else{
            respuesta = false;
        }
        return respuesta;
    }




}

