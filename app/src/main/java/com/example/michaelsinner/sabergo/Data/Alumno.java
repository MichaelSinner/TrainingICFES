package com.example.michaelsinner.sabergo.Data;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by Michael Sinner on 30/10/2016.
 */

public class Alumno
{

    private String ID;
    private String Nombre;
    private String Correo;
    private String Colegio;
    private String User;
    private String Password;
    private final int tipoUsuario = 2;

    public Alumno(String nombre, String colegio, String correo,String user, String password)
    {
        this.setNombre(nombre);
        this.setColegio(colegio);
        this.setCorreo(correo);
        this.setUser(user);
        this.setPassword(password);
    }

    public Alumno(){}

    public Alumno(Cursor cursor)
    {
        setID(cursor.getString(cursor.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_ID)));
        setNombre(cursor.getString(cursor.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_NOMBRE)));
        setCorreo(cursor.getString(cursor.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_CORREO)));
        setColegio(cursor.getString(cursor.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_COLEGIO)));
        setUser(cursor.getString(cursor.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_USER)));
        setPassword(cursor.getString(cursor.getColumnIndex(AlumnoContract.AlumnoEntry.COLUMN_NAME_PASSWORD)));
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        //values.put(AlumnoContract.AlumnoEntry._ID, ID);
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_NOMBRE, getNombre());
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_COLEGIO, getColegio());
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_CORREO, getCorreo());
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_USER, getUser());
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_PASSWORD, getPassword());
        return values;
    }

    // Getters and Setters

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
}
