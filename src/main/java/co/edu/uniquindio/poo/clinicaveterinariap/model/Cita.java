package co.edu.uniquindio.poo.clinicaveterinariap.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cita {
    private String id;
    private LocalDate fecha;
    private Hora hora;
    private Sede sede;
    private String consultorio;
    private Mascota mascota;
    private Veterinario veterinario;


    public Cita(String id, LocalDate fecha, Hora hora, Sede sede, String consultorio, Mascota mascota, Veterinario veterinario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.sede = sede;
        this.consultorio = consultorio;
        this.mascota = mascota;

        this.veterinario = veterinario;

    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", sede=" + sede +
                ", consultorio='" + consultorio + '\'' +
                ", mascota=" + mascota +
                ", veterinario=" + veterinario +
                '}';
    }
}

