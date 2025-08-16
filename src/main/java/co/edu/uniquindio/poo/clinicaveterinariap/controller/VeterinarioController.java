package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.*;

import java.util.List;

public class VeterinarioController {
    private App app;
    private Veterinario veterinario;
    public Veterinaria veterinaria;

    public void regresarAlPrimary(){
        app.openViewPrincipal();
    }
    public boolean registrarConsulta(Consulta consulta){
        veterinario.agregarConsulta(consulta);
        return true;
    }
    public List<Mascota> obtenerListaMascotas(){
        return veterinaria.getListMascotas();
    }
    public List<Tratamiento> obtenerListaTratamientos(){
        return veterinaria.getListTratamientos();
    }
    public VeterinarioController(Veterinaria veterinaria){
        this.veterinaria = veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria){
        this.veterinaria = veterinaria;
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
