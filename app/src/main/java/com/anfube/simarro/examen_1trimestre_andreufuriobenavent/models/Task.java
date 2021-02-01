package com.anfube.simarro.examen_1trimestre_andreufuriobenavent.models;

import java.io.Serializable;

public class Task implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    private boolean esImportante;
    private boolean hecha;

    public Task(int id, String nombre, String descripcion, boolean esImportante, boolean hecha) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esImportante = esImportante;
        this.hecha = hecha;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEsImportante() {
        return esImportante;
    }

    public void setEsImportante(boolean esImportante) {
        this.esImportante = esImportante;
    }

    public boolean isHecha() {
        return hecha;
    }

    public void setHecha(boolean hecha) {
        this.hecha = hecha;
    }
}
