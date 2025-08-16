package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Propietario;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Secretaria;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Veterinaria;

import java.util.List;

public class RegistroPropietarioController {
    private Secretaria secretaria;
    private App app;
    public Veterinaria veterinaria;

    public RegistroPropietarioController(Veterinaria veterinaria){
        this.veterinaria = veterinaria;
    }

    public List<Propietario> obtenerListaPropietarios() {
        return veterinaria.getListPropietarios();
    }

    public void regresarASecretaria(){
        app.openCrudSecretaria(secretaria);
    }
    public boolean agregarPropietario(Propietario propietario) {
        secretaria.agregarPropietario(propietario);
        return true;
    }
    public boolean actualizarPropietario(String id, Propietario propietario) {
        secretaria.actualizarPropietario(id, propietario);
        return true;
    }
    public boolean eliminarPropietario(String id) {
        secretaria.eliminarPropietario(id);
        return true;
    }

    public void setVeterinaria(Veterinaria veterinaria){
        this.veterinaria = veterinaria;
    }
    public void setSecretaria(Secretaria secretaria){
        this.secretaria = secretaria;
    }
    public void setApp(App app){
        this.app = app;
    }
}
