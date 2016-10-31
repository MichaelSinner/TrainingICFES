package com.example.michaelsinner.sabergo.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.michaelsinner.sabergo.Adapters.CursorAdapterAdmin;
import com.example.michaelsinner.sabergo.Data.AdministradorContract;
import com.example.michaelsinner.sabergo.Data.AdministradorDBHelper;
import com.example.michaelsinner.sabergo.R;

public class ListaAdministradores extends AppCompatActivity {


    private ListView lvListaAdministadores;
    private AdministradorDBHelper dbHelper;
    CursorAdapterAdmin adapter;
    public static final String EXTRA_ADMIN_ID = "extra_admin_id";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_administradores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvListaAdministadores = (ListView) findViewById(R.id.lvListaAdmin);
        dbHelper = AdministradorDBHelper.getInstance(getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+AdministradorContract.AdministradorEntry.TABLE_NAME,null);
        adapter = new CursorAdapterAdmin(this, cursor);
        lvListaAdministadores.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAddAdministrador();
            }
        });

        lvListaAdministadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) adapter.getItem(i);

                String currentAdminID = currentItem.getString(currentItem.getColumnIndex(AdministradorContract.AdministradorEntry._ID));
                String currentAdminName = currentItem.getString(currentItem.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE));
                String currentAdminColegio = currentItem.getString(currentItem.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_COLEGIO));
                String currentAdminCorreo = currentItem.getString(currentItem.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO));
                String currentAdminUser = currentItem.getString(currentItem.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_USER));
                String currentAdminPassword = currentItem.getString(currentItem.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_PASSWORD));

                Intent modify_intent = new Intent(getApplicationContext(), DetailsAdmin.class);
                modify_intent.putExtra("adminId", currentAdminID);
                modify_intent.putExtra("adminNombre", currentAdminName);
                modify_intent.putExtra("adminColegio", currentAdminColegio);
                modify_intent.putExtra("adminCorreo", currentAdminCorreo);
                modify_intent.putExtra("adminUsuario", currentAdminUser);
                modify_intent.putExtra("adminContraseña", currentAdminPassword);

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
        Cursor aircraftCursor = db.rawQuery("SELECT  * FROM " + AdministradorContract.AdministradorEntry.TABLE_NAME, null);
        adapter.changeCursor(aircraftCursor);

    }

    public void showAddAdministrador()
    {
        Intent toAddAdministrador = new Intent(ListaAdministradores.this, AddAdministrador.class);
        startActivity(toAddAdministrador);
    }
    private void showDetailsAdmin(String adminID)
    {
        Intent toDetailsAdministrador = new Intent(ListaAdministradores.this, DetailsAdmin.class);
        toDetailsAdministrador.putExtra(EXTRA_ADMIN_ID,adminID);
        startActivity(toDetailsAdministrador);
    }


}
