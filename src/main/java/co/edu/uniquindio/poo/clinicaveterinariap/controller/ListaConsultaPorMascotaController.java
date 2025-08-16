package co.edu.uniquindio.poo.clinicaveterinariap.controller;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Consulta;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Secretaria;

import java.util.List;

public class ListaConsultaPorMascotaController {
    private App app;
    private Secretaria secretaria;

    public List<Consulta> hallarHistorial(String id){
        return secretaria.hallarlistaConsultasMascota(id);
    }
    public void abrirSecretaria(){
        app.openCrudSecretaria(secretaria);
    }
    public void setApp(App app) {
        this.app = app;
    }

}
