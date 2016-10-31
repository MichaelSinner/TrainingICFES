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
 * Created by Michael Sinner on 26/10/2016.
 */

public class CursorAdapterAdmin extends CursorAdapter{

    public CursorAdapterAdmin(Context context, Cursor cursor)
    {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.items_lista_admin, viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView tvNombreAdmin = (TextView) view.findViewById(R.id.tvNombreAdmin);
        TextView tvCorreoAdmin = (TextView) view.findViewById(R.id.tvCorreoAdmin);


        String nombreAdmin = cursor.getString(cursor.getColumnIndexOrThrow(AdministradorContract.AdministradorEntry.COLUMN_NAME_NOMBRE));
        String correoAdmin = cursor.getString(cursor.getColumnIndexOrThrow(AdministradorContract.AdministradorEntry.COLUMN_NAME_CORREO));


        tvNombreAdmin.setText(nombreAdmin);
        tvCorreoAdmin.setText(correoAdmin);

    }

}
