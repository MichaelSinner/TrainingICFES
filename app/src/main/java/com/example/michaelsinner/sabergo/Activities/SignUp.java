package com.example.michaelsinner.sabergo.Activities;

import android.app.Activity;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.michaelsinner.sabergo.Data.Administrador;
import com.example.michaelsinner.sabergo.Data.AdministradorDBHelper;
import com.example.michaelsinner.sabergo.Data.Alumno;
import com.example.michaelsinner.sabergo.Data.AlumnoDBHelper;
import com.example.michaelsinner.sabergo.R;

public class SignUp extends AppCompatActivity {

    private AlumnoDBHelper dbHelper;

    String AdminID;
    Button btnRegistrarAlumno;
    EditText etNombre;
    EditText etColegio;
    EditText etCorreo;
    EditText etUsuario;
    EditText etContraseña;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnRegistrarAlumno = (Button) findViewById(R.id.btnRegistrar);
        etNombre = (EditText) findViewById(R.id.etNombreEstudiante);
        etColegio = (EditText) findViewById(R.id.etColegioEstudiante);
        etCorreo = (EditText) findViewById(R.id.etCorreoEstudiante);
        etUsuario = (EditText) findViewById(R.id.etUsuarioEstudiante);
        etContraseña = (EditText) findViewById(R.id.etContraseñaEstudiante);

        btnRegistrarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAlumno();
            }
        });

        dbHelper = AlumnoDBHelper.getInstance(getApplicationContext());

        // Carga de datos
        if (AdminID != null) {
            loadAdmin();
        }


    }

    private void loadAdmin()
    {
        new SignUp.GetAlumnoByIdTask().execute();
    }

    private class GetAlumnoByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return dbHelper.getAlumnoById(AdminID);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                showAlumno(new Alumno(cursor));
            } else {
                showLoadError();

            }
        }

    }
    private void showLoadError() {
        Toast toastError = Toast.makeText(getApplicationContext(),"Error al Editar nueva información",Toast.LENGTH_LONG);
        toastError.show();
    }

    private void showAlumno(Alumno alumno) {
        etNombre.setText(alumno.getNombre());
        etColegio.setText(alumno.getColegio());
        etCorreo.setText(alumno.getCorreo());
        etUsuario.setText(alumno.getUser());
        etContraseña.setText(alumno.getPassword());
    }

    public void saveAlumno()
    {
        boolean error = false;

        String nombre = etNombre.getText().toString();
        String colegio = etColegio.getText().toString();
        String correo = etCorreo.getText().toString();
        String user = etUsuario.getText().toString();
        String password = etContraseña.getText().toString();


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
            etContraseña.setError(getString(R.string.field_error));
            error = true;
        }

        if (error) {
            return;
        }

        Alumno admin = new Alumno(nombre,correo,colegio,user,password);

        new SignUp.AddEditAlumnoTask().execute(admin);
    }

    private class AddEditAlumnoTask extends AsyncTask<Alumno, Void, Boolean>
    {

        @Override
        protected Boolean doInBackground(Alumno... alumnos) {
            if (AdminID != null) {
                return dbHelper.updateAlumno(alumnos[0], AdminID) > 0;

            } else {
                return dbHelper.saveAlumno(alumnos[0]) > 0;
            }

        }

        @Override
        protected void onPostExecute(Boolean result) {
            showAdminsScreen(result);
        }
    }

    private void showAdminsScreen(Boolean requery) {
        if (!requery) {
            showAddEditError();

            this.setResult(Activity.RESULT_CANCELED);
        } else {
            this.setResult(Activity.RESULT_OK);
        }

        this.finish();
    }

    private void showAddEditError() {
        Toast toastError = Toast.makeText(getApplicationContext(),"Error al agregar nueva información",Toast.LENGTH_LONG);
        toastError.show();
    }
}
