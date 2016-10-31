package com.example.michaelsinner.sabergo.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.michaelsinner.sabergo.Data.AdministradorContract;
import com.example.michaelsinner.sabergo.R;

/**
 * Created by Michael Sinner on 30/10/2016.
 */

public class CursorAdapterAlumno extends CursorAdapter{

    public CursorAdapterAlumno(Context context, Cursor cursor)
    {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_lista_alumnos, viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView tvNombreAlumno = (TextView) view.findViewById(R.id.tvNombreAlumno);
        TextView tvCorreoAlumno = (TextView) view.findViewById(R.id.tvCorreoAlumno);


        String nombreAdmin = cursor.getString(cursor.getColumnIndexOrThrow(AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE));
        String correoAdmin = cursor.getString(cursor.getColumnIndexOrThrow(AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO));


        tvNombreAlumno.setText(nombreAdmin);
        tvCorreoAlumno.setText(correoAdmin);

    }
}
