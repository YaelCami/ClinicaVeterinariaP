package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.*;

import java.time.LocalDate;
import java.util.List;

public class RegistroCitaController {
    private App app;
    private Secretaria secretaria;
    private Veterinaria veterinaria;

    public List<Hora> obtenerHorasVeterinario(String id, LocalDate newDate){
        return veterinaria.disponibilidadVeterinario(id, newDate);
    }
    public void regresar(){
        app.openCrudSecretaria(secretaria);
    }
    public boolean agregarCita(Cita cita){
        secretaria.agregarCita(cita);
        return true;
    }
    public List<Mascota> obtenerMascotas(){
        return veterinaria.getListMascotas();
    }
    public List<Veterinario> obtenerVeterinarios(){
        return veterinaria.getListVeterinarios();
    }
    public RegistroCitaController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public void setSecretaria(Secretaria secretaria){
        this.secretaria = secretaria;
    }
    public void setApp(App app){
        this.app = app;
    }
    public void setVeterinaria(Veterinaria veterinaria){
        this.veterinaria = veterinaria;
    }
}