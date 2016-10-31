package com.example.michaelsinner.sabergo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.michaelsinner.sabergo.R;

public class MenuPrincipalAdmin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnModificarAdmin;
    private Button btnModificarAlumnos;
    private Button btnModificarPreguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutAdmin);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_Admin);
        navigationView.setNavigationItemSelectedListener(this);

        btnModificarAdmin = (Button) findViewById(R.id.btnModificarAdmin);
        btnModificarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toListaAdmin = new Intent(MenuPrincipalAdmin.this, ListaAdministradores.class);
                startActivity(toListaAdmin);
            }
        });

        btnModificarAlumnos = (Button) findViewById(R.id.btnModificarAlumnos);
        btnModificarAlumnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toListaAlumnos = new Intent(MenuPrincipalAdmin.this, ListaAlumnos.class);
                startActivity(toListaAlumnos);
            }
        });

        btnModificarPreguntas = (Button) findViewById(R.id.btnModificarPreguntas);
        btnModificarPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toListaPreguntas = new Intent(MenuPrincipalAdmin.this, ListaPreguntas.class);
                startActivity(toListaPreguntas);
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutAdmin);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent toListaAdministradores = new Intent(MenuPrincipalAdmin.this, ListaAdministradores.class);
            startActivity(toListaAdministradores);
        } else if (id == R.id.nav_gallery) {
            Intent toListaAlumnos = new Intent(MenuPrincipalAdmin.this, ListaAlumnos.class);
            startActivity(toListaAlumnos);
        } else if (id == R.id.nav_slideshow) {
            Intent toListaPreguntas = new Intent(MenuPrincipalAdmin.this, ListaPreguntas.class);
            startActivity(toListaPreguntas);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutAdmin);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
