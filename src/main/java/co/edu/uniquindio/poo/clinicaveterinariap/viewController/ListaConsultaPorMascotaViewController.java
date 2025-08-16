package co.edu.uniquindio.poo.clinicaveterinariap.viewController;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.controller.ListaConsultaPorMascotaController;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Consulta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaConsultaPorMascotaViewController {
    private ListaConsultaPorMascotaController controller;
    private App app;
    private ListaConsultaPorMascotaController listaConsultaPorMascotaController;

    @FXML
    private Button btnRegresar, btnCargar;
    @FXML
    private TextField txtId;
    @FXML
    private TableView<Consulta> tbvConsultas;
    @FXML
    void onRegresar(){
        irASecretaria();
    }
    @FXML
    private void irASecretaria(){
        listaConsultaPorMascotaController.abrirSecretaria();
    }
    @FXML
    void onCargar(){
        cargarLista();
    }
    @FXML
    private void cargarLista(){
        String id = txtId.getText();
        listaConsultaPorMascotaController.hallarHistorial(id);
    }

    public void setApp(App app) {
        this.app = app;
    }
    public void setListaConsultaPorMascotaController(ListaConsultaPorMascotaController listaConsultaPorMascotaController) {
        this.listaConsultaPorMascotaController = listaConsultaPorMascotaController;
    }
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
}
