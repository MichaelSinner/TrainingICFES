package com.example.michaelsinner.sabergo.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.michaelsinner.sabergo.R;

public class Login extends AppCompatActivity
{

    Button btnIngresar;
    TextView tvTitulo;
    EditText usuario, password;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mp = MediaPlayer.create(this,R.raw.audio_button4);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable userString, passString;
                userString = usuario.getText();
                passString = password.getText();

                if (validarLog(userString.toString(),passString.toString()))
                {
                    mp.start();
                    Toast toastLoginTrue = Toast.makeText(getApplicationContext(),"Bienvenido "+userString,Toast.LENGTH_LONG);
                    toastLoginTrue.show();

                    if(userString.toString().equals("michi"))
                    {
                        Intent toMenuPrincipalE = new Intent(Login.this,MenuPartida.class);
                        startActivity(toMenuPrincipalE);
                    }
                    if(userString.toString().equals("ana")){
                        Intent toMenuPrincipalA = new Intent(Login.this,MenuPrincipalAdmin.class);
                        startActivity(toMenuPrincipalA);
                    }

                }else{
                    Toast toastLoginError = Toast.makeText(getApplicationContext(),"Error al Ingresar, digite correctamente su usuario y contraseña.",Toast.LENGTH_LONG);
                    toastLoginError.show();
                }
            }
        });

        usuario = (EditText) findViewById(R.id.etUsuario);
        password = (EditText) findViewById(R.id.etContraseña);

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        tvTitulo.setTypeface(fuente);
    }

    public boolean validarLog(String user, String password)
    {
        return user.equals("michi") && password.equals("1234") || user.equals("ana") && password.equals("1234");
    }

}
