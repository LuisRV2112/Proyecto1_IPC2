package org.example.proyecto_ipc2.model;

public class Revista {
    private int id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private Integer autor;
    private double costoPorDia;
    private int likes;

    // Constructor
    public Revista(int id, String titulo, String descripcion, String categoria, String autor, double costoPorDia) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.autor = autor;
        this.costoPorDia = costoPorDia;
        this.likes = 0;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = Integer.valueOf(autor);
    }

    public double getCostoPorDia() {
        return costoPorDia;
    }

    public void setCostoPorDia(double costoPorDia) {
        this.costoPorDia = costoPorDia;
    }

    public int getLikes() {
        return likes;
    }

    public void addLike() {
        this.likes++;
    }
}
