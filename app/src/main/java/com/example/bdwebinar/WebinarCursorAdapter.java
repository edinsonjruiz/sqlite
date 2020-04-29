package com.example.bdwebinar;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class WebinarCursorAdapter extends CursorAdapter {
    public WebinarCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.dato_webi, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombre = (TextView) view.findViewById(R.id.txtnombres);
        TextView conferencista = (TextView) view.findViewById(R.id.txtaconferencista);
        TextView fecha = (TextView) view.findViewById(R.id.txtfecha);
        TextView link = (TextView) view.findViewById(R.id.txtlink);
        // Extract properties from cursor
        String nom = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String conf = cursor.getString(cursor.getColumnIndexOrThrow("conferencista"));
        String fec= cursor.getString(cursor.getColumnIndexOrThrow("fecha"));
        String lin = cursor.getString(cursor.getColumnIndexOrThrow("link"));
        // Populate fields with extracted properties
        nombre.setText(nom);
        conferencista.setText(conf);
        fecha.setText(fec);
        link.setText(lin);

    }
}
