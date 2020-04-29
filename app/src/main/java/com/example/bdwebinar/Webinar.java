package com.example.bdwebinar;

public class Webinar {

    public String nombre;
    public String conferencista;
    public String fecha;
    public String link;

    public Webinar(String nombre, String conferencista, String fecha, String link) {
        this.nombre = nombre;
        this.conferencista = conferencista;
        this.fecha = fecha;
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConferencista() {
        return conferencista;
    }

    public void setConferencista(String conferencista) {
        this.conferencista = conferencista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLink(){ return link; }

    public void setLink(String link){ this.link = link; }

    @Override
    public String toString() {
        return "registrosWebinar{" +
                "nombre='" + nombre + '\'' +
                ", conferencista='" + conferencista + '\'' +
                ", fecha='" + fecha + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
