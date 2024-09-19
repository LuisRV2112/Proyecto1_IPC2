package org.example.proyecto_ipc2.model;
import java.util.Date;
public class Suscripcion {
    private Suscriptor suscriptor;
    private Revista revista;
    private Date fechaSuscripcion;

    // Constructor
    public Suscripcion(Suscriptor suscriptor, Revista revista, Date fechaSuscripcion) {
        this.suscriptor = suscriptor;
        this.revista = revista;
        this.fechaSuscripcion = fechaSuscripcion;
    }

    // Getters y Setters
    public Suscriptor getSuscriptor() {
        return suscriptor;
    }

    public void setSuscriptor(Suscriptor suscriptor) {
        this.suscriptor = suscriptor;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    public Date getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(Date fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }
}
