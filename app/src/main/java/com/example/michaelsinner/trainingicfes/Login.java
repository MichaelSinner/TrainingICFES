package com.example.michaelsinner.trainingicfes;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener
{

    Button btnIngresar;
    TextView tvTitulo;
    EditText usuario, password;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);

        usuario = (EditText) findViewById(R.id.etUsuario);

        password = (EditText) findViewById(R.id.etContraseña);

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Sanlabello.ttf");
        tvTitulo.setTypeface(fuente);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnIngresar:

                Editable userString, passString;
                userString = usuario.getText();
                passString = password.getText();

                if (validarLog(userString.toString(),passString.toString()))
                {
                    Toast toastLoginTrue = Toast.makeText(getApplicationContext(),"Bienvenido "+userString,Toast.LENGTH_LONG);
                    toastLoginTrue.show();
                    Intent puente2 = new Intent(Login.this,MenuPrincipal.class);
                    startActivity(puente2);
                }else{
                    Toast toastLoginError = Toast.makeText(getApplicationContext(),"Error al Ingresar, digite correctamente su usuario y contraseña.",Toast.LENGTH_LONG);
                    toastLoginError.show();
                }
                break;

        }

    }

    public boolean validarLog(String user, String password)
    {
        return user.equals("michi") && password.equals("1234");
    }
}
