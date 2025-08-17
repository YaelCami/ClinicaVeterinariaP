package co.edu.uniquindio.poo.clinicaveterinariap.viewController;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.controller.RegistroMascotaController;
import co.edu.uniquindio.poo.clinicaveterinariap.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroMascotaViewController {
    private App app;
    private RegistroMascotaController registroMascotaController;
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    Mascota selectedMascota;


    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;
    @FXML
    private Button btnRegresar, btnAgregar, btnActualizar, btnEliminar, btnCancelar;
    @FXML
    private TextField txtEdad, txtId, txtRaza, txtNombre;
    @FXML
    private TableView<Mascota> tbvRegistroMascota;
    @FXML
    private TableColumn<Mascota, Integer> tbcEdad;
    @FXML
    private TableColumn<Mascota, String> tbcNombre, tbcId, tbcRaza;
    @FXML
    private TableColumn<Mascota, Especie> tbcEspecie;
    @FXML
    private ComboBox<Especie> cbxEspecie;
    @FXML
    private ComboBox<Propietario> cbxPropietario;
    @FXML
    void onRegresar(){
        regresarASecretaria();
    }
    @FXML
    void onAgregar(){
        agregarMascota();
    }
    @FXML
    void onActualizar(){
        if (selectedMascota != null) {
            try {
                Mascota nuevaMascota = buildMascota();
                if (selectedMascota == null) {
                    mostrarAlerta("Error", "Por favor completa todos los campos.");
                    return;
                }
                boolean actualizado = registroMascotaController.actualizarMascota(selectedMascota.getId(), nuevaMascota);
                if (actualizado) {
                    int index = listMascotas.indexOf(selectedMascota);
                    listMascotas.set(index, nuevaMascota);
                    limpiarCampos();
                    mostrarAlerta("Exito", "Mascota actualizado correctamente");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar correctamente.");
                }
            } catch (Exception e) {
                mostrarAlerta("Error", "Datos invalidos:" + e.getMessage());
            }
        } else {
            mostrarAlerta("Atencion", "Selecciona una mascota para actualizar.");
        }
    }
    @FXML
    void onEliminar(){
        if (selectedMascota != null) {
            boolean eliminado = registroMascotaController.eliminarMascota(selectedMascota.getId());
            if (eliminado) {
                listMascotas.remove(selectedMascota);
                limpiarCampos();
                mostrarAlerta("Exito", "Mascota eliminado correctamente");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar ala mascota correctamente");
            }
        } else {
            mostrarAlerta("Atencion", "Selecciona a una mascota para eliminar");
        }
    }
    @FXML
    private void regresarASecretaria(){
        registroMascotaController.regresarSecretaria();
    }
    @FXML
    private void agregarMascota(){
        try {
            Mascota mascota = buildMascota();
            if (mascota == null) {
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }
            if (registroMascotaController.agregarMascota(mascota)) {
                listMascotas.add(mascota);
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo agregar ala mascota correctamente");
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
        tbcRaza.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getRaza()));
        tbcEspecie.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getEspecie()));
        tbcEdad.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getEdad()));
        tbvRegistroMascota.setItems(listMascotas);
        cbxEspecie.getItems().addAll(Especie.values());
        listenerSelection();
    }

    private void cargarPropietarios() {
        cbxPropietario.getItems().clear();
        cbxPropietario.getItems().addAll(registroMascotaController.obtenerPropietarios());
        cbxPropietario.setConverter(new StringConverter<Propietario>() {
            @Override
            public String toString(Propietario propietario) {
                return propietario != null ? propietario.getNombre() : "";
            }

            @Override
            public Propietario fromString(String string) {
                return null;
            }
        });
    }

    private Mascota buildMascota(){
        String nombre = txtNombre.getText();
        String id = txtId.getText();
        String raza = txtRaza.getText();
        int edad = Integer.parseInt(txtEdad.getText().trim());
        Especie especie = cbxEspecie.getValue();
        Propietario propietario = cbxPropietario.getValue();
        Mascota mascota = new Mascota(nombre, raza, edad, id, especie, propietario);
        if (mascota == null){
            return null;
        }
        return mascota;
    }
    public void setApp(App app){
        this.app = app;
    }
    public void setRegistroMascotaController(RegistroMascotaController registroMascotaController){
        this.registroMascotaController = registroMascotaController;
        cargarPropietarios();
        obtenerMascotas();
    }
    public void obtenerMascotas(){
        List<Mascota> mascotas = registroMascotaController.obtenerMascotas();
        if(mascotas !=null){
            listMascotas.setAll(mascotas);
            tbvRegistroMascota.setItems(listMascotas);
        } else {
            tbvRegistroMascota.getItems().clear();
        }
    }
    private void listenerSelection(){
        tbvRegistroMascota.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            selectedMascota = newSelection;
            mostrarInformacion(selectedMascota);
        });
    }
    private void mostrarInformacion( Mascota mascota){
        if(mascota != null){
            txtNombre.setText(mascota.getNombre());
            txtId.setText(mascota.getId());
            txtRaza.setText(mascota.getRaza());
            txtEdad.setText(String.valueOf(mascota.getEdad()));
            cbxEspecie.setValue(mascota.getEspecie());
            cbxPropietario.setValue(mascota.getPropietario());
        }
    }
    private void limpiarCampos(){
        txtNombre.clear();
        txtId.clear();
        txtRaza.clear();
        cbxEspecie.setValue(null);
        cbxPropietario.setValue(null);
    }

}
