package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Secretaria;

public class ListaMascotaPorEspecieController {
    private App app;
    private Secretaria secretaria;

    public int cantPerros(){
        return secretaria.cantidadPerros();
    }
    public int cantGatos(){
        return secretaria.cantidadGatos();
    }
    public int cantAves(){
        return secretaria.cantidadAves();
    }
    public int cantOtros(){
        return secretaria.cantidadAves();
    }
    public void irASecretaria(){
        app.openCrudSecretaria(secretaria);
    }
    public void setApp(App app) {
        this.app = app;
    }
}
