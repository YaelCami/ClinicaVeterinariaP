package co.edu.uniquindio.poo.clinicaveterinariap.viewController;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.controller.SecretariaController;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Secretaria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SecretariaViewController {
    private App app;
    private SecretariaController secretariaController;
    private Secretaria secretaria;

    public void setSecretariaController(SecretariaController secretariaController) {
        this.secretariaController = secretariaController;
    }
    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    private Button btnRegresar, btnRegistrarMascota, btnRegistrarPropietario, btnRegistrarVeterinario, btnAgendarCita, btnConsultasMascotas, btnMascotasPorEspecie;
    @FXML
    void onRegresar(){
        abrirPrimary();
    }
    @FXML
    void onConsultasMasc(){
        irAHistorialPorMAsc();
    }
    @FXML
    void onMascEspecie(){
        irACantMascotasPorEspecie();
    }
    @FXML
    private void irACantMascotasPorEspecie(){
        secretariaController.abrirCantMascotasEspecie();
    }
    @FXML
    private void irAHistorialPorMAsc(){
        secretariaController.abrirListaConsultaMascota();
    }
    @FXML
    private void abrirPrimary(){
        secretariaController.regresarAlPrimary();
    }
    @FXML
    void onRegistrarMascota(){
        abrirRegistroMascota();
    }
    @FXML
    private void abrirRegistroMascota(){
        secretariaController.irAlRegistroMascota();
    }
    @FXML
    void onRegistrarPropietario(){
        abrirRegistroPropietario();
    }
    @FXML
    void abrirRegistroPropietario(){
        secretariaController.irAlRegistroPropietario();
    }
    @FXML
    void onRegistrarVeterinario(){
        abrirRegistroVeterinario();
    }
    @FXML
    private void abrirRegistroVeterinario(){
        secretariaController.irAlRegistroVeterinario();
    }
    @FXML
    void onAgendarCita(){
        abrirAgendarCita();
    }
    @FXML
    private void abrirAgendarCita(){
        secretariaController.agendarCita();
    }
}
