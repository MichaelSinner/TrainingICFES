package com.example.michaelsinner.sabergo.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.michaelsinner.sabergo.Adapters.CursorAdapterAlumno;
import com.example.michaelsinner.sabergo.Data.AdministradorContract;
import com.example.michaelsinner.sabergo.Data.AlumnoContract;
import com.example.michaelsinner.sabergo.Data.AlumnoDBHelper;
import com.example.michaelsinner.sabergo.R;

public class ListaAlumnos extends AppCompatActivity {

    private ListView lvListaAlumnos;
    private AlumnoDBHelper dbHelper;
    CursorAdapterAlumno adapter;
    public static final String EXTRA_ALUMNO_ID = "extra_alumno_id";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alumnos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvListaAlumnos = (ListView) findViewById(R.id.lvListaAlumnos);
        dbHelper = AlumnoDBHelper.getInstance(getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ AlumnoContract.AlumnoEntry.TABLE_NAME, null);
        adapter = new CursorAdapterAlumno(this, cursor);
        lvListaAlumnos.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAddAlumno();
            }
        });

        lvListaAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) adapter.getItem(i);

                String currentAdminID = currentItem.getString(currentItem.getColumnIndex(AlumnoContract.AlumnoEntry._ID));
                String currentAdminName = currentItem.getString(currentItem.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_NOMBRE));
                String currentAdminColegio = currentItem.getString(currentItem.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_COLEGIO));
                String currentAdminCorreo = currentItem.getString(currentItem.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_CORREO));
                String currentAdminUser = currentItem.getString(currentItem.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_USER));
                String currentAdminPassword = currentItem.getString(currentItem.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_PASSWORD));

                Intent modify_intent = new Intent(getApplicationContext(), DetailsAlumno.class);
                modify_intent.putExtra("alumnoId", currentAdminID);
                modify_intent.putExtra("alumnoNombre", currentAdminName);
                modify_intent.putExtra("alumnoColegio", currentAdminColegio);
                modify_intent.putExtra("alumnoCorreo", currentAdminCorreo);
                modify_intent.putExtra("alumnoUsuario", currentAdminUser);
                modify_intent.putExtra("alumnoContraseña", currentAdminPassword);

                startActivity(modify_intent);


                // showDetailsAdmin(currentAdminID);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList(null);
    }

    public void refreshList(View v) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor aircraftCursor = db.rawQuery("SELECT  * FROM " + AlumnoContract.AlumnoEntry.TABLE_NAME, null);
        adapter.changeCursor(aircraftCursor);

    }

    public void showAddAlumno()
    {
        Intent toAddAlumno = new Intent(ListaAlumnos.this, SignUp.class);
        startActivity(toAddAlumno);
    }



}
