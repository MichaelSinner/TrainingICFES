package com.example.michaelsinner.sabergo.Data;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by Michael Sinner on 26/10/2016.
 */

public class Administrador
{

    private String ID;
    private String Nombre;
    private String Correo;
    private String Colegio;
    private String User;
    private String Password;
    private int tipoUsuario = 1;

    public Administrador(String nombre, String correo, String colegio, String user, String password)
    {
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setColegio(colegio);
        this.setUser(user);
        this.setPassword(password);
    }

    public Administrador(){}

    public Administrador(Cursor cursor)
    {
        ID = cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_ID));
        Nombre = cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE));
        Correo = cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO));
        Colegio = cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_COLEGIO));
        User = cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_USER));
        Password = cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_PASSWORD));

    }

    public ContentValues toContentValues()
    {
        ContentValues values = new ContentValues();
        //values.put(AdministradorContract.AdministradorEntry._ID, ID);
        values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE, Nombre);
        values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_COLEGIO, Colegio);
        values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO, Correo);
        values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_USER, User);
        values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_PASSWORD, Password);
        return values;

    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getColegio() {
        return Colegio;
    }

    public void setColegio(String colegio) {
        Colegio = colegio;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
