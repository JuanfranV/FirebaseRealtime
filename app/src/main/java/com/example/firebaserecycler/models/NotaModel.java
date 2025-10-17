package com.example.firebaserecycler.models;

public class NotaModel {

    private String id;
    private String titulo;
    private String contenido;
    private long fecha;

    public NotaModel() {} // Constructor vacío para Firebase

    public NotaModel(String id, String titulo, String contenido, long fecha) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }
}
