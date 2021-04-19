package org.iesch.alberto.a14_recyclerview;

public class Restaurante {

    private String nombre;
    private String direccion;
    private String urlPhoto;
    private float valoracion;

    public Restaurante(String nombre, String direccion, String urlPhoto, float valoracion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.urlPhoto = urlPhoto;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
}
