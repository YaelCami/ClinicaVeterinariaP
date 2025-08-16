package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.*;



public class PrimaryController {
    private Veterinaria veterinaria;
    private App app;

    public PrimaryController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }
    public void setApp(App app) {
        this.app = app;
    }

    public boolean redireccionarSegunId(String id){
        System.out.println("Buscando secretaria con id: " + id);
        Secretaria secretaria = veterinaria.buscarSecretaria(id);
        if(secretaria != null){
            System.out.println("Secretaria encontrada: " + secretaria.getNombre());
            app.openCrudSecretaria(secretaria);
            return true;
        }

        System.out.println("Buscando veterinario con id: " + id);
        Veterinario veterinario = veterinaria.buscarVeterinario(id);
        if(veterinario != null){
            System.out.println("Veterinario encontrado: " + veterinario.getNombre());
            app.openCrudVeterinario(veterinario);
            return true;
        }

        System.out.println("No se encontró secretaria ni veterinario con ese id");
        return false;
    }


}
