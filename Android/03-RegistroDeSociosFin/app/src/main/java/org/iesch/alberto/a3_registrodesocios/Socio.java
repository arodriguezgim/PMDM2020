package org.iesch.alberto.a3_registrodesocios;

import android.os.Parcel;
import android.os.Parcelable;

public class Socio implements Parcelable {
    private String name;
    private String lastName;
    private String nickName;
    private String edad;
    private String direccion;
    private String ciudad;

    public Socio(String name, String lastName, String nickName, String edad, String direccion, String ciudad) {
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.edad = edad;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    protected Socio(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        nickName = in.readString();
        edad = in.readString();
        direccion = in.readString();
        ciudad = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeString(nickName);
        dest.writeString(edad);
        dest.writeString(direccion);
        dest.writeString(ciudad);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Socio> CREATOR = new Parcelable.Creator<Socio>() {
        @Override
        public Socio createFromParcel(Parcel in) {
            return new Socio(in);
        }

        @Override
        public Socio[] newArray(int size) {
            return new Socio[size];
        }
    };
}