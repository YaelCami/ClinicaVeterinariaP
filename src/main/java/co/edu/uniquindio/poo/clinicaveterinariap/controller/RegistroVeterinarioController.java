package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Secretaria;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Veterinaria;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Veterinario;

import java.util.List;

public class RegistroVeterinarioController {
    private App app;
    private Secretaria secretaria;
    public Veterinaria veterinaria;

    public RegistroVeterinarioController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }
    public boolean agregarVeterinario(Veterinario veterinario) {
        secretaria.agregarVeterinario(veterinario);
        return true;
    }
    public boolean eliminarVeterinario(String id) {
        secretaria.eliminarVeterinario(id);
        return true;
    }
    public boolean actualizarVeterinario(String id,Veterinario veterinario) {
        secretaria.actualizarVeterinario(id, veterinario);
        return true;
    }
    public void regresarASecretaria(){
        app.openCrudSecretaria(secretaria);
    }
    public List<Veterinario> obtenerListaVeterinarios() {
        if (secretaria.getListVeterinarios() != null) {
            return secretaria.getListVeterinarios();
        } else {
            System.out.println("No se encontro nada en esta lista");
        }
        return null;
    }
    public void setVeterinaria(Veterinaria veterinaria){
        this.veterinaria = veterinaria;
    }
    public void setApp(App app){
        this.app = app;
    }
    public void setSecretaria(Secretaria secretaria){
        this.secretaria = secretaria;
    }
}
