package com.example.firebaserecycler.models;

public class NotaModel {

    private String id;
    private String titulo;
    private String descripcion;
    private String archivoUrl;
    private String tipoArchivo;

    public NotaModel() {} // Requerido por Firebase

    public NotaModel(String id, String titulo, String descripcion, String archivoUrl, String tipoArchivo) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.archivoUrl = archivoUrl;
        this.tipoArchivo = tipoArchivo;
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

    public String getArchivoUrl() {
        return archivoUrl;
    }

    public void setArchivoUrl(String archivoUrl) {
        this.archivoUrl = archivoUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }
}
