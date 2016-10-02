package com.example.michaelsinner.trainingicfes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AgregarPreguntas extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spnArea, spnCompetencia;

    ArrayAdapter<String> aaArea, aaCompetenciaA, aaClear, aaCompetenciaB, aaCompetenciaC, aaCompetenciaD, aaCompetenciaE;
    String [] opcionesArea = new String[]{"Lectura Critica","Matemáticas","Sociales y ciudadanas","Ciencias Naturales","Ingles"};
    String [] opcionesCompetenciasA = new String[]{"Identificar y entender contenidos de un texto","Comprender como se articulan las partes de un texto","Reflexionar y evaluar contenido de un texto"};
    String [] opcionesCompetenciasB = new String[]{"Interpretación y representación","Formulación y ejecución","Argumentación"};
    String [] opcionesCompetenciasC = new String[]{"Pensamiento social","Interpretación y analisis de perspectivas","Pensamiento reflexivo y sistemático"};
    String [] opcionesCompetenciasD = new String[]{"Uso comprensivo del conocimiento científico","Explicación de fenómenos","Indagación"};
    String [] opcionesCompetenciasE = new String[]{"Parte1","Parte2","Parte3","Parte4","Parte5","Parte6","Parte7","Parte8"};
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
        aaCompetenciaB = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opcionesCompetenciasB);
        aaCompetenciaC = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opcionesCompetenciasC);
        aaCompetenciaD = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opcionesCompetenciasD);
        aaCompetenciaE = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opcionesCompetenciasE);
        aaClear = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opcClear);

        spnArea.setAdapter(aaArea);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId())
        {
            case R.id.spnArea:
                int seleccion = spnArea.getSelectedItemPosition();

                if (seleccion == 0)
                    spnCompetencia.setAdapter(aaCompetenciaA);
                else if (seleccion == 1)
                    spnCompetencia.setAdapter(aaCompetenciaB);
                else if(seleccion == 2)
                    spnCompetencia.setAdapter(aaCompetenciaC);
                else if(seleccion == 3)
                    spnCompetencia.setAdapter(aaCompetenciaD);
                else if(seleccion == 4)
                    spnCompetencia.setAdapter(aaCompetenciaE);


                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
