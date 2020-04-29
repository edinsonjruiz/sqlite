package com.example.bdwebinar;

public class DefDB {

    public static final String nameDb = "Webinar";
    public static final String tabla_est = "registrosWebinar";
    public static final String col_nombre = "nombre";
    public static final String col_conferencista = "conferencista";
    public static final String col_fecha = "fecha";
    public static final String col_link = "link";

    public static final String create_tabla_web = "CREATE TABLE IF NOT EXISTS " + DefDB.tabla_est + " (" +
            DefDB.col_nombre + " text," +
            DefDB.col_conferencista + " text," +
            DefDB.col_fecha + " text," +
            DefDB.col_link + " text"+
            ");";

}
