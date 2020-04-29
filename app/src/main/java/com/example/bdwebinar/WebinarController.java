package com.example.bdwebinar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class WebinarController {

    private BaseDatos db;

    public WebinarController(Context context) {
        this.db = new BaseDatos(context);
    }

    public long agregarWebinar(Webinar e){
        try{

            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefDB.col_nombre,e.nombre);
            valores.put(DefDB.col_conferencista,e.conferencista);
            valores.put(DefDB.col_fecha,e.fecha);
            valores.put(DefDB.col_link,e.link);
            long id = database.insert(DefDB.tabla_est,null,valores);
            return id;
        }
        catch (Exception ex){
            System.out.println("Error al insertar");
            return 0;
        }
    }

    public boolean buscarWebinar(String nombre){
        String[] args = new String[] {nombre};
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query(DefDB.tabla_est, null, "nombre=?", args, null, null, null);
        if (c.getCount()>0) {
            database.close();
            return true;
        }
        else{
            database.close();
            return false;}

    }

    public void eliminar(String nom){
            SQLiteDatabase database = db.getReadableDatabase();
            database.execSQL("DELETE FROM registroswebinar where nombre=?", new String[]{nom});
    }


    public Cursor allWebinar() {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur = database.rawQuery("select nombre as _id, conferencista, fecha, link from registrosWebinar", null);
            return cur;
        } catch (Exception ex) {
            System.out.println("Error al consultar");
            return null;
        }
    }

}