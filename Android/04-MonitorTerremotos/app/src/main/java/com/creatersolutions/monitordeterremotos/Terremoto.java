package com.creatersolutions.monitordeterremotos;

public class Terremoto {

    private String magnitud;
    private String lugar;

    // Parte B: 2 - Creamos un constructor y los getters
    public Terremoto(String magnitud, String lugar) {
        this.magnitud = magnitud;
        this.lugar = lugar;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public String getLugar() {
        return lugar;
    }
}
