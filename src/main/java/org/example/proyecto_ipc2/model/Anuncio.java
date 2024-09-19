package org.example.proyecto_ipc2.model;
import java.util.Date;
public class Anuncio {
    private int id;
    private String tipo;  // "Texto", "Texto e Imagen", "Video"
    private String contenido;  // El texto del anuncio o URL del video/imagen
    private Date fechaInicio;
    private Date fechaFin;
    private double precio;

    // Constructor
    public Anuncio(int id, String tipo, String contenido, Date fechaInicio, Date fechaFin, double precio) {
        this.id = id;
        this.tipo = tipo;
        this.contenido = contenido;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
