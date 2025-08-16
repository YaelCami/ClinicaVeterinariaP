package co.edu.uniquindio.poo.clinicaveterinariap.viewController;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.controller.RegistroPropietarioController;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Propietario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroPropietarioViewController {
    private App app;
    private RegistroPropietarioController registroPropietarioController;
    ObservableList<Propietario> listPropietarios = FXCollections.observableArrayList();
    Propietario selectedPropietario;

    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private TableView<Propietario> tbvGestionPropietario;
    @FXML
    private Button btnRegresar, btnEliminar, btnActualizar, btnAgregar;
    @FXML
    private TextField txtNombre, txtDireccion, txtTelefono, txtId;
    @FXML
    private TableColumn<Propietario, String> tbcNombre, tbcId, tbcDireccion, tbcTelefono;

    @FXML
    void onRegresar() {
        regresarASecretaria();
    }

    @FXML
    void onAgregar() {
        agregarPropietario();
    }

    @FXML
    void onActualizar() {
        if (selectedPropietario != null) {
            try {
                Propietario nuevoPropietario = buildPropietario();
                if (selectedPropietario == null) {
                    mostrarAlerta("Error", "Por favor completa todos los campos.");
                    return;
                }
                boolean actualizado = registroPropietarioController.actualizarPropietario(selectedPropietario.getId(), nuevoPropietario);
                if (actualizado) {
                    int index = listPropietarios.indexOf(selectedPropietario);
                    listPropietarios.set(index, nuevoPropietario);
                    limpiarCampos();
                    mostrarAlerta("Exito", "Propietario actualizado correctamente");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar correctamente.");
                }
            } catch (Exception e) {
                mostrarAlerta("Error", "Datos invalidos:" + e.getMessage());
            }
        } else {
            mostrarAlerta("Atencion", "Selecciona un propietario para actualizar.");
        }
    }

    @FXML
    void onEliminar() {
        if (selectedPropietario != null) {
            boolean eliminado = registroPropietarioController.eliminarPropietario(selectedPropietario.getId());
            if (eliminado) {
                listPropietarios.remove(selectedPropietario);
                limpiarCampos();
                mostrarAlerta("Exito", "Propietario eliminado correctamente");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar al propietario correctamente");
            }
        } else {
            mostrarAlerta("Atencion", "Selecciona a un priopietario para eliminar");
        }
    }

    @FXML
    public void regresarASecretaria() {
        registroPropietarioController.regresarASecretaria();
    }

    private void agregarPropietario() {
        try {
            Propietario propietario = buildPropietario();
            if (propietario == null) {
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }
            if (registroPropietarioController.agregarPropietario(propietario)) {
                listPropietarios.add(propietario);
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar al propietario correctamente");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos invalidos:" + e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void initialize(){
        tbcNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcTelefono.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcDireccion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDireccion()));
        tbvGestionPropietario.setItems(listPropietarios);
        listenerSelection();
    }

    private Propietario buildPropietario(){
        String nombre = txtNombre.getText();
        String id = txtId.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        Propietario propietario = new Propietario(nombre, id, telefono, direccion);
        if (propietario == null){
            return null;
        }
        return propietario;
    }

    public void setRegistroPropietarioController(RegistroPropietarioController registroPropietarioController) {
        this.registroPropietarioController = registroPropietarioController;
        obtenerPropietarios();
    }

    public void obtenerPropietarios(){
        List<Propietario> propietarios = registroPropietarioController.obtenerListaPropietarios();
        if(propietarios != null){
            listPropietarios.setAll(propietarios);
            tbvGestionPropietario.setItems(listPropietarios);
        } else {
            tbvGestionPropietario.getItems().clear();
        }

    }

    private void listenerSelection(){
        tbvGestionPropietario.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedPropietario = newSelection;
            mostrarInformacionPropietario(selectedPropietario);
        });
    }

    private void mostrarInformacionPropietario( Propietario propietario){
        if(propietario != null){
            txtNombre.setText(propietario.getNombre());
            txtId.setText(propietario.getId());
            txtTelefono.setText(propietario.getTelefono());
            txtDireccion.setText(propietario.getDireccion());
        }
    }

    private void limpiarCampos(){
        txtNombre.clear();
        txtId.clear();
        txtTelefono.clear();
        txtDireccion.clear();
    }
}
