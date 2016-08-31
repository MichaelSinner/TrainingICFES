package com.example.michaelsinner.trainingicfes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnEntrar;
    Button btnAcercaDe;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);
        btnAcercaDe = (Button) findViewById(R.id.btnAcercaDe);
        btnAcercaDe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnEntrar:
                Intent puente1 = new Intent(MainActivity.this,Login.class);
                startActivity(puente1);
                break;

            case R.id.btnAcercaDe:

                break;
        }
    }
}
