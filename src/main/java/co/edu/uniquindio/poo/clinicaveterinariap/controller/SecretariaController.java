package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Secretaria;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Veterinaria;

public class SecretariaController {
    private App app;
    private Secretaria secretaria;
    private Veterinaria veterinaria;

    public void setApp(App app) {
        this.app = app;
    }
    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
    public void regresarAlPrimary(){
        app.openViewPrincipal();
    }
    public void irAlRegistroMascota(){
        app.openRegistroMascota(secretaria);
    }
    public void irAlRegistroVeterinario(){
        app.openRegistroVeterinario(secretaria);
    }
    public void irAlRegistroPropietario(){
        app.openRegistroPropietario(secretaria);
    }
    public void agendarCita(){
        app.openRegistroCita(secretaria);
    }
    public void abrirCantMascotasEspecie(){
        app.openListaMascotaPorEspecie();
    }
    public void abrirListaConsultaMascota(){
        app.openListaConsultaPorMascota();
    }
}
