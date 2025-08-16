package co.edu.uniquindio.poo.clinicaveterinariap.viewController;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.controller.ListaMascotaPorEspecieController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaMascotaPorEspecieViewController {
    private App app;
    private ListaMascotaPorEspecieController controller;

    @FXML
    private Button btnRegresar;
    @FXML
    private Label lblPerro, lblGato, lblAve, lblOtro;
    @FXML
    void onRegresar(){
        irASecretaria();
    }
    @FXML
    private void irASecretaria(){
        controller.irASecretaria();
    }
    public void initialize(){
        int cantPerros = numPerros();
        int cantGatos = numGatos();
        int cantAve = numAves();
        int cantOtro = numOtros();
        lblPerro.setText(String.valueOf(cantPerros));
        lblGato.setText(String.valueOf(cantGatos));
        lblAve.setText(String.valueOf(cantAve));
        lblOtro.setText(String.valueOf(cantOtro));
    }
    private int numPerros(){
        int cantPerros = controller.cantPerros();
        return cantPerros;
    }
    private int numGatos(){
        int cantGatos = controller.cantGatos();
        return cantGatos;
    }
    private int numAves(){
        int cantAves = controller.cantAves();
        return cantAves;
    }
    private int numOtros(){
        int cantOtros = controller.cantOtros();
        return cantOtros;
    }

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }
    public void setListaMascotaPorEspecieController(ListaMascotaPorEspecieController controller) {
        this.controller = controller;
    }
}
