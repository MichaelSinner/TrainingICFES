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
import com.example.michaelsinner.sabergo.R;

public class AddAdministrador extends AppCompatActivity
{
    private AdministradorDBHelper dbHelper;

    String AdminID;
    Button btnRegistrarAdmin;
    EditText etNombre;
    EditText etColegio;
    EditText etCorreo;
    EditText etUsuario;
    EditText etContraseña;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_administrador);

        btnRegistrarAdmin = (Button) findViewById(R.id.btnRegistrarAdmin);
        etNombre = (EditText) findViewById(R.id.etNombreAdmin);
        etColegio = (EditText) findViewById(R.id.etColegioAdmin);
        etCorreo = (EditText) findViewById(R.id.etCorreoAdmin);
        etUsuario = (EditText) findViewById(R.id.etUserAdmin);
        etContraseña = (EditText) findViewById(R.id.etContraseñaAdmin);

        btnRegistrarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAdmin();
            }
        });

        dbHelper = AdministradorDBHelper.getInstance(getApplicationContext());

        // Carga de datos
        if (AdminID != null) {
            loadAdmin();
        }


    }

    private void loadAdmin()
    {
        new GetAdminByIdTask().execute();
    }

    private class GetAdminByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return dbHelper.getAdminById(AdminID);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                showAdmin(new Administrador(cursor));
            } else {
                showLoadError();

            }
        }

    }
    private void showLoadError() {
        Toast toastError = Toast.makeText(getApplicationContext(),"Error al Editar nueva información",Toast.LENGTH_LONG);
        toastError.show();
    }

    private void showAdmin(Administrador admin) {
        etNombre.setText(admin.getNombre());
        etColegio.setText(admin.getColegio());
        etCorreo.setText(admin.getCorreo());
        etUsuario.setText(admin.getUser());
        etContraseña.setText(admin.getPassword());
    }

    public void saveAdmin()
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

        Administrador admin = new Administrador(nombre,correo,colegio,user,password);

        new AddEditAdminTask().execute(admin);
    }

    private class AddEditAdminTask extends AsyncTask<Administrador, Void, Boolean>
    {

        @Override
        protected Boolean doInBackground(Administrador... administradors) {
            if (AdminID != null) {
                return dbHelper.updateAdmin(administradors[0], AdminID) > 0;

            } else {
                return dbHelper.saveAdmin(administradors[0]) > 0;
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
