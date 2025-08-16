package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Secretaria;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Veterinaria;

public class RegistroCitaController {
    private App app;
    private Secretaria secretaria;
    private Veterinaria veterinaria;

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
