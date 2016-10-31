package com.example.michaelsinner.sabergo.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.michaelsinner.sabergo.Data.Administrador;
import com.example.michaelsinner.sabergo.Data.AdministradorDBHelper;
import com.example.michaelsinner.sabergo.R;

public class DetailsAdmin extends AppCompatActivity
{

    private EditText etNombre;
    private EditText etColegio;
    private EditText etCorreo;
    private EditText etUsuario;
    private EditText etPassword;
    private Button btnActualizar;
    private Button btnEliminar;
    private Administrador admin;

    private AdministradorDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_admin);

        etNombre = (EditText) findViewById(R.id.etNombreAdminEdit);
        etColegio = (EditText) findViewById(R.id.etColegioAdminEdit);
        etCorreo = (EditText) findViewById(R.id.etCorreoAdminEdit);
        etUsuario = (EditText) findViewById(R.id.etUserAdminEdit);
        etPassword = (EditText) findViewById(R.id.etContraseñaAdminEdit);


        Intent intent = getIntent();
        final String currentAdminID = intent.getStringExtra("adminId");
        String currentAdminName = intent.getStringExtra("adminNombre");
        String currentAdminColegio = intent.getStringExtra("adminColegio");
        String currentAdminCorreo = intent.getStringExtra("adminCorreo");
        String currentAdminUser = intent.getStringExtra("adminUsuario");
        String currentAdminPassword = intent.getStringExtra("adminContraseña");

        etNombre.setText(currentAdminName);
        etColegio.setText(currentAdminColegio);
        etCorreo.setText(currentAdminCorreo);
        etUsuario.setText(currentAdminUser);
        etPassword.setText(currentAdminPassword);



        dbHelper = AdministradorDBHelper.getInstance(getApplicationContext());



        btnActualizar = (Button) findViewById(R.id.btnEditarAdmin);
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

                admin = new Administrador(nombre,correo,colegio,user,password);

                dbHelper.updateAdmin(admin,currentAdminID);
                startActivity(toListaAdministrador());
            }
        });

        btnEliminar = (Button) findViewById(R.id.btnEliminarAdmin);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteAdmin(currentAdminID);
                startActivity(toListaAdministrador());
            }
        });
    }

    public Intent toListaAdministrador(){
        Intent toLista = new Intent(DetailsAdmin.this, ListaAdministradores.class);
        return toLista;
    }


}
