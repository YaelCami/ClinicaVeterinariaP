package co.edu.uniquindio.poo.clinicaveterinariap.viewController;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.controller.RegistroVeterinarioController;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Especialidad;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Propietario;
import co.edu.uniquindio.poo.clinicaveterinariap.model.Veterinario;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroVeterinarioViewController {
    private App app;
    private RegistroVeterinarioController registroVeterinarioController;
    ObservableList<Veterinario> listVeterinarios = FXCollections.observableArrayList();
    Veterinario selectedVeterinario;

    @FXML
    private URL location;
    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private TableView<Veterinario> tbvGestionVeterinarios;
    @FXML
    private Button btnRegresar, btnEliminar, btnActualizar, btnAgregar;
    @FXML
    private ComboBox<Especialidad> cbxEspecialidad;
    @FXML
    private TableColumn<Veterinario, String> tbcNombre, tbcNumLicencia, tbcId;
    @FXML
    private TableColumn<Veterinario, Especialidad> tbcEspecialidad;
    @FXML
    private TextField txtNombre, txtNumLicencia, txtId;

    @FXML
    void onRegresar(){
        regresarASecretaria();
    }
    @FXML
    void onAgregar(){
        agregarVeterinario();
    }
    @FXML
    void onActualizar(){
        if (selectedVeterinario !=null){
            try{
                Veterinario nuevoVeterinario = buildVeterinario();
                if (selectedVeterinario == null){
                    mostrarAlerta("Error", "Por favor completa todos los campos.");
                    return;
                }
                boolean actualizado = registroVeterinarioController.actualizarVeterinario(selectedVeterinario.getId(), nuevoVeterinario);
                if (actualizado){
                    int index = listVeterinarios.indexOf(selectedVeterinario);
                    listVeterinarios.set(index, nuevoVeterinario);
                    limpiarCampos();
                    mostrarAlerta("Exito", "Veterinario actualizado correctamente.");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar correctamente.");
                }
            }catch (Exception e){
                mostrarAlerta("Error", "Datos invalidos:" + e.getMessage());
            }
        } else {
            mostrarAlerta("Atencion", "Selecciona un veterinario para actualizar.");
        }
    }
    @FXML
    void onEliminar(){
        if (selectedVeterinario !=null){
            boolean eliminado = registroVeterinarioController.eliminarVeterinario(selectedVeterinario.getId());
            if (eliminado){
                listVeterinarios.remove(selectedVeterinario);
                limpiarCampos();
                mostrarAlerta("Exito", "Veterinario eliminado correctamente");
            } else {
                mostrarAlerta("Error","No se pudo eliminar al veterinario correctamente");
            }
        } else{
            mostrarAlerta("Atencion", "Selecciona a un veterinario para eliminar");
        }
    }
    @FXML
    public void regresarASecretaria(){
        registroVeterinarioController.regresarASecretaria();
    }
    private void agregarVeterinario(){
        try{
            Veterinario veterinario = buildVeterinario();
            if (veterinario == null){
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }
            if (registroVeterinarioController.agregarVeterinario(veterinario)){
                listVeterinarios.add(veterinario);
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar al veterinario correctamente" );
            }
        } catch (Exception e){
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
        tbcNumLicencia.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getLicencia()));
        tbcEspecialidad.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getEspecialidad()));
        tbvGestionVeterinarios.setItems(listVeterinarios);
        cbxEspecialidad.getItems().addAll(Especialidad.values());
        listenerSelection();
    }

    private Veterinario buildVeterinario(){
        String nombre = txtNombre.getText();
        String id = txtId.getText();
        String numLicencia = txtNumLicencia.getText();
        Especialidad especialidad = cbxEspecialidad.getValue();
        Veterinario veterinario = new Veterinario(nombre, id, numLicencia, especialidad);
        if (veterinario == null){
            return null;
        }
        return veterinario;
    }

    public void setRegistroVeterinarioController(RegistroVeterinarioController registroVeterinarioController){
        this.registroVeterinarioController = registroVeterinarioController;
        obtenerVeterinarios();
    }

    public void obtenerVeterinarios(){
        List<Veterinario> veterinarios = registroVeterinarioController.obtenerListaVeterinarios();
        if(veterinarios != null){
            listVeterinarios.setAll(veterinarios);
            tbvGestionVeterinarios.setItems(listVeterinarios);
        } else {
            tbvGestionVeterinarios.getItems().clear();
        }
    }

    private void listenerSelection(){
        tbvGestionVeterinarios.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedVeterinario = newSelection;
            mostrarInformacionVeterinario(selectedVeterinario);
        });
    }

    private void mostrarInformacionVeterinario(Veterinario veterinario){
        if (veterinario != null){
            txtNombre.setText(veterinario.getNombre());
            txtId.setText(veterinario.getId());
            txtNumLicencia.setText(veterinario.getLicencia());
            cbxEspecialidad.setValue(veterinario.getEspecialidad());
        }
    }

    private void limpiarCampos(){
        txtNombre.clear();
        txtId.clear();
        txtNumLicencia.clear();
        cbxEspecialidad.setValue(null);
    }



}