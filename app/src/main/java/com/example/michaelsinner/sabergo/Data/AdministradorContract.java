package com.example.michaelsinner.sabergo.Data;

import android.provider.BaseColumns;

/**
 * Created by Michael Sinner on 26/10/2016.
 */

public class AdministradorContract
{

    private AdministradorContract(){}

    public static abstract class AdministradorEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "administrador";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CORREO = "correo";
        public static final String COLUMN_NAME_COLEGIO = "colegio";
        public static final String COLUMN_NAME_USER = "user";
        public static final String COLUMN_NAME_PASSWORD = "password";

    }



}
