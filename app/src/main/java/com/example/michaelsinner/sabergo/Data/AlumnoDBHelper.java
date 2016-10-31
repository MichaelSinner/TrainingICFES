package com.example.michaelsinner.sabergo.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Michael Sinner on 30/10/2016.
 */

public class AlumnoDBHelper extends SQLiteOpenHelper {

    static AlumnoDBHelper dbHelper;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Alumno.db";


    public static synchronized AlumnoDBHelper getInstance(Context context)
    {
        if(dbHelper == null) {
            dbHelper = new AlumnoDBHelper(context.getApplicationContext());
        }
        return dbHelper;
    }

    public AlumnoDBHelper(Context context)
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

    public void addAlumn(Alumno alumno) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_ID, alumno.getID());
            values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_NOMBRE, alumno.getNombre());
            values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_CORREO, alumno.getCorreo());
            values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_COLEGIO, alumno.getColegio());
            values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_USER, alumno.getUser());
            values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_PASSWORD, alumno.getPassword());

            db.insertOrThrow(AlumnoContract.AlumnoEntry.TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("DB", "Error while trying to add admin to database", e);
        } finally {
            db.endTransaction();
        }
    }

    // Get all posts in the database
    public ArrayList<Alumno> getAllAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();

        String ADMIN_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        AdministradorContract.AdministradorEntry.TABLE_NAME);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(ADMIN_SELECT_QUERY, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    Alumno alumno = new Alumno();
                    alumno.setID(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_ID)));
                    alumno.setNombre(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE)));
                    alumno.setCorreo(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO)));
                    alumno.setColegio(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_COLEGIO)));
                    alumno.setUser(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_USER)));
                    alumno.setPassword(cursor.getString(cursor.getColumnIndex(AdministradorContract.AdministradorEntry.COLUMN_NAME_PASSWORD)));

                    alumnos.add(alumno);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("DB", "Error while trying to get Alumno from database",e);
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return alumnos;
    }

    public int updateAlumno(Alumno alumno, String alumnoId)
    {
        return getWritableDatabase().update(
                AlumnoContract.AlumnoEntry.TABLE_NAME,
                alumno.toContentValues(),
                AdministradorContract.AdministradorEntry._ID + " LIKE ?",
                new String[]{alumnoId}
        );
    }

    public Cursor getAlumnoById(String alumnoID) {
        Cursor c = getReadableDatabase().query(
                AlumnoContract.AlumnoEntry.TABLE_NAME,
                null,
                AlumnoContract.AlumnoEntry._ID + " LIKE ?",
                new String[]{alumnoID},
                null,
                null,
                null);
        return c;
    }

    public long saveAlumno(Alumno alumno)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                AlumnoContract.AlumnoEntry.TABLE_NAME,
                null,
                alumno.toContentValues());

    }

    public int deleteAlumno(String alumnoID) {
        return getWritableDatabase().delete(
                AlumnoContract.AlumnoEntry.TABLE_NAME,
                AlumnoContract.AlumnoEntry._ID + " LIKE ?",
                new String[]{alumnoID});
    }









    private static final String TEXT_TYPE = " TEXT NOT NULL";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AlumnoContract.AlumnoEntry.TABLE_NAME + " (" +
                    AlumnoContract.AlumnoEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    AlumnoContract.AlumnoEntry.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
                    AlumnoContract.AlumnoEntry.COLUMN_NAME_COLEGIO + TEXT_TYPE + COMMA_SEP +
                    AlumnoContract.AlumnoEntry.COLUMN_NAME_CORREO + TEXT_TYPE + COMMA_SEP +
                    AlumnoContract.AlumnoEntry.COLUMN_NAME_USER + TEXT_TYPE + COMMA_SEP +
                    AlumnoContract.AlumnoEntry.COLUMN_NAME_PASSWORD + TEXT_TYPE +
                    ")";



    private static final String SQL_SAMPLE_ENTRIE1 =
            "INSERT INTO  " + AlumnoContract.AlumnoEntry.TABLE_NAME + " VALUES (" +
                    "1, 'Paula Peñaloza', 'Colegio Parroquia Sanata Isabel De Hungria', 'pava@gmail.com', 'pava', '1234'" +
                    " ); COMMIT;";
    private static final String SQL_SAMPLE_ENTRIE2 =
            "INSERT INTO  " + AlumnoContract.AlumnoEntry.TABLE_NAME + " VALUES (" +
                    "2, 'Santiago Vasquez','IED Julio Garavito Armero', 'satan@hotmail.com', 'satan', '1234'" +
                    " ); COMMIT;";
    /*
    private static final String SQL_SAMPLE_ENTRIE3 =
            "INSERT INTO  " + AdministradorContract.AdministradorEntry.TABLE_NAME + " VALUES (" +
                    "3, 'Dassault Falcon 20', '1963'" +
                    " ); COMMIT;";
     */

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AlumnoContract.AlumnoEntry.TABLE_NAME;
}
