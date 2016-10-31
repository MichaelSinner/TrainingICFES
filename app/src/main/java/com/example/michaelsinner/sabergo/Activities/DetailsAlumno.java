package com.example.michaelsinner.sabergo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.michaelsinner.sabergo.Data.Alumno;
import com.example.michaelsinner.sabergo.Data.AlumnoDBHelper;
import com.example.michaelsinner.sabergo.R;

public class DetailsAlumno extends AppCompatActivity {
    private EditText etNombre;
    private EditText etColegio;
    private EditText etCorreo;
    private EditText etUsuario;
    private EditText etPassword;
    private Button btnActualizar;
    private Button btnEliminar;
    private Alumno alumno;

    private AlumnoDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_alumno);

        etNombre = (EditText) findViewById(R.id.etNombreAlumnoEdit);
        etColegio = (EditText) findViewById(R.id.etColegioAlumnoEdit);
        etCorreo = (EditText) findViewById(R.id.etCorreoAlumnoEdit);
        etUsuario = (EditText) findViewById(R.id.etUserAlumnoEdit);
        etPassword = (EditText) findViewById(R.id.etContraseñaAlumnoEdit);


        Intent intent = getIntent();
        final String currentAlumnID = intent.getStringExtra("alumnoId");
        String currentAlumnName = intent.getStringExtra("alumnoNombre");
        String currentAlumnColegio = intent.getStringExtra("alumnoColegio");
        String currentAlumnCorreo = intent.getStringExtra("alumnoCorreo");
        String currentAlumnUser = intent.getStringExtra("alumnoUsuario");
        String currentAlumnPassword = intent.getStringExtra("alumnoContraseña");

        etNombre.setText(currentAlumnName);
        etColegio.setText(currentAlumnColegio);
        etCorreo.setText(currentAlumnCorreo);
        etUsuario.setText(currentAlumnUser);
        etPassword.setText(currentAlumnPassword);



        dbHelper = AlumnoDBHelper.getInstance(getApplicationContext());



        btnActualizar = (Button) findViewById(R.id.btnEditarAlumno);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean error = false;

                String nombre = etNombre.getText().toString();
                String colegio = etColegio.getText().toString();
                String correo = etCorreo.getText().toString();
                String user = etUsuario.getText().toString();
                String password = etPassword.getText().toString();


                if (TextUtils.isEmpty(nombre)) {
                    etNombre.setError(getString(R.string.field_error));
                    error = true;
                }

                if (TextUtils.isEmpty(colegio)) {
                    etColegio.setError(getString(R.string.field_error));
                    error = true;
                }
                if (TextUtils.isEmpty(correo)) {
                    etCorreo.setError(getString(R.string.field_error));
                    error = true;
                }
                if (TextUtils.isEmpty(user)) {
                    etUsuario.setError(getString(R.string.field_error));
                    error = true;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError(getString(R.string.field_error));
                    error = true;
                }

                if (error) {
                    return;
                }

                alumno = new Alumno(nombre,correo,colegio,user,password);

                dbHelper.updateAlumno(alumno , currentAlumnID);
                startActivity(toListaAlumnos());
            }
        });

        btnEliminar = (Button) findViewById(R.id.btnEliminarAdmin);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteAlumno(currentAlumnID);
                startActivity(toListaAlumnos());
            }
        });
    }

    public Intent toListaAlumnos(){
        Intent toLista = new Intent(DetailsAlumno.this, ListaAlumnos.class);
        return toLista;
    }

}
