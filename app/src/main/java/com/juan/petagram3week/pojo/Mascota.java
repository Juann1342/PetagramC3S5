package com.juan.petagram3week.pojo;

public class Mascota {
    public String nombre;
    public int foto;
    public String rating;
    public int id;

    public Mascota() {
    }

    public Mascota(String nombre, int foto, String rating, int id){
        this.nombre=nombre;
        this.foto=foto;
        this.rating=rating;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
