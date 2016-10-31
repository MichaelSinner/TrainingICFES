package com.example.michaelsinner.sabergo.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Michael Sinner on 26/10/2016.
 */

public class AdministradorDBHelper extends SQLiteOpenHelper
{


    static AdministradorDBHelper dbHelper;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Administrador.db";


    public static synchronized AdministradorDBHelper getInstance(Context context)
    {
        if(dbHelper == null) {
            dbHelper = new AdministradorDBHelper(context.getApplicationContext());
        }
        return dbHelper;
    }

    public AdministradorDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db)
    {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_SAMPLE_ENTRIE1);
        sqLiteDatabase.execSQL(SQL_SAMPLE_ENTRIE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addAdmin(Administrador admin) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_ID, admin.getID());
            values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE, admin.getNombre());
            values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO, admin.getCorreo());
            values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_COLEGIO, admin.getColegio());
            values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_USER, admin.getUser());
            values.put(AdministradorContract.AdministradorEntry.COLUMN_NAME_PASSWORD, admin.getPassword());

            db.insertOrThrow(AdministradorContract.AdministradorEntry.TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("DB", "Error while trying to add admin to database", e);
        } finally {
            db.endTransaction();
        }
    }

    // Get all posts in the database
    public ArrayList<Administrador> getAllAdministradores() {
        ArrayList<Administrador> administradores = new ArrayList<>();

        String ADMIN_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        AdministradorContract.AdministradorEntry.TABLE_NAME);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(ADMIN_SELECT_QUERY, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    Administrador admin = new Administrador();
                    admin.setID(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_ID)));
                    admin.setNombre(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE)));
                    admin.setCorreo(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO)));
                    admin.setColegio(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_COLEGIO)));
                    admin.setUser(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_USER)));
                    admin.setPassword(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_PASSWORD)));

                    administradores.add(admin);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("DB", "Error while trying to get Administrador from database",e);
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return administradores;
    }

    public int updateAdmin(Administrador admin, String adminId)
    {
        return getWritableDatabase().update(
                AdministradorContract.AdministradorEntry.TABLE_NAME,
                admin.toContentValues(),
                AdministradorContract.AdministradorEntry._ID + " LIKE ?",
                new String[]{adminId}
        );
    }

    public Cursor getAdminById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                AdministradorContract.AdministradorEntry.TABLE_NAME,
                null,
                AdministradorContract.AdministradorEntry._ID + " LIKE ?",
                new String[]{lawyerId},
                null,
                null,
                null);
        return c;
    }

    public long saveAdmin(Administrador admin)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                AdministradorContract.AdministradorEntry.TABLE_NAME,
                null,
                admin.toContentValues());

    }

    public int deleteAdmin(String AdminId) {
        return getWritableDatabase().delete(
                AdministradorContract.AdministradorEntry.TABLE_NAME,
                AdministradorContract.AdministradorEntry._ID + " LIKE ?",
                new String[]{AdminId});
    }









    private static final String TEXT_TYPE = " TEXT NOT NULL";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AdministradorContract.AdministradorEntry.TABLE_NAME + " (" +
                    AdministradorContract.AdministradorEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
                    AdministradorContract.AdministradorEntry.COLUMN_NAME_COLEGIO + TEXT_TYPE + COMMA_SEP +
                    AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO + TEXT_TYPE + COMMA_SEP +
                    AdministradorContract.AdministradorEntry.COLUMN_NAME_USER + TEXT_TYPE + COMMA_SEP +
                    AdministradorContract.AdministradorEntry.COLUMN_NAME_PASSWORD + TEXT_TYPE +
                    ")";



    private static final String SQL_SAMPLE_ENTRIE1 =
            "INSERT INTO  " + AdministradorContract.AdministradorEntry.TABLE_NAME + " VALUES (" +
                    "1, 'Ana Sotelo', 'Colegio Panamericano', 'anasotelo@uan.edu.co', 'ana', '1234'" +
                    " ); COMMIT;";
    private static final String SQL_SAMPLE_ENTRIE2 =
            "INSERT INTO  " + AdministradorContract.AdministradorEntry.TABLE_NAME + " VALUES (" +
                    "2, 'Michael Peñaloza','IED Julio Garavito Armero', 'mipenaloza@uan.edu.co', 'michi', '1234'" +
                    " ); COMMIT;";
    /*
    private static final String SQL_SAMPLE_ENTRIE3 =
            "INSERT INTO  " + AdministradorContract.AdministradorEntry.TABLE_NAME + " VALUES (" +
                    "3, 'Dassault Falcon 20', '1963'" +
                    " ); COMMIT;";
     */

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AdministradorContract.AdministradorEntry.TABLE_NAME;
}
