package com.example.michaelsinner.trainingicfes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AgregarPreguntas extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spnArea;
    Spinner spnCompetencia;
    ArrayAdapter<String> aaArea, aaCompetenciaA,aaClear;
    String [] opcionesArea = new String[]{"Lectura Critica","Matemáticas","Sociales y ciudadanas","Ciencias Naturales","Ingles"};
    String [] opcionesCompetenciasA = new String[]{"Identificar y entender contenidos de un texto","Comprender como se articulan las partes de un texto","Reflexionar y evaluar contenido de un texto"};
    String [] opcionesCompetenciasB = new String[]{"Lectura Critica","Matemáticas","Sociales y ciudadanas","Ciencias Naturales","Ingles"};
    String [] opcionesCompetenciasC = new String[]{"Lectura Critica","Matemáticas","Sociales y ciudadanas","Ciencias Naturales","Ingles"};
    String [] opcionesCompetenciasD = new String[]{"Lectura Critica","Matemáticas","Sociales y ciudadanas","Ciencias Naturales","Ingles"};
    String [] opcionesCompetenciasE = new String[]{"Lectura Critica","Matemáticas","Sociales y ciudadanas","Ciencias Naturales","Ingles"};
    String [] opcClear = new String[0];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_preguntas);

        spnArea = (Spinner) findViewById(R.id.spnArea);
        spnCompetencia = (Spinner) findViewById(R.id.spnCompetencia);
        spnArea.setOnItemSelectedListener(this);
        spnCompetencia.setOnItemSelectedListener(this);

        aaArea = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opcionesArea);
        aaCompetenciaA = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opcionesCompetenciasA);
        aaClear = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opcClear);

        spnArea.setAdapter(aaArea);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId())
        {
            case R.id.spnArea:
                int seleccion = spnArea.getSelectedItemPosition();
                if (seleccion == 1)
                {
                    spnCompetencia.setAdapter(aaCompetenciaA);
                }else{
                    spnCompetencia.setAdapter(aaClear);
                }


                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
