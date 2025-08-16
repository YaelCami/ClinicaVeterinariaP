package co.edu.uniquindio.poo.clinicaveterinariap.model;

import java.util.List;

public class Mascota {
    private String nombre;
    private String raza;
    private int edad;
    private String id;
    private Especie especie;
    private Propietario propietario;
    private List<Consulta> listConsultas;

    public Mascota(String nombre, String raza, int edad, String id, Especie especie, Propietario propietario){
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.id = id;
        this.especie = especie;
        this.propietario = propietario;
    }


    public List<Consulta> getListConsultas() {
        return listConsultas;
    }

    public void setListConsultas(List<Consulta> listConsultas) {
        this.listConsultas = listConsultas;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", id='" + id + '\'' +
                ", especie=" + especie +
                ", propietario=" + propietario +
                ", listConsultas=" + listConsultas +
                '}';
    }
}



