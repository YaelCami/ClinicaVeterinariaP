package co.edu.uniquindio.poo.clinicaveterinariap.viewController;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.controller.RegistroCitaController;
import co.edu.uniquindio.poo.clinicaveterinariap.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroCitaViewController {
    private App app;
    private RegistroCitaController registroCitaController;

    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;
    @FXML
    private TextField txtIdCita, txtConsultorio;
    @FXML
    private Button btnRegistrar, btnRegresar;
    @FXML
    private ComboBox<Veterinario> cbxVeterinario;
    @FXML
    private ComboBox<Mascota> cbxMascota;
    @FXML
    private ComboBox<Sede> cbxSede;
    @FXML
    private ComboBox<Hora> cbxHora;
    @FXML
    private DatePicker dtpFecha;

    @FXML
    void onRegresar(){
        regresarASecretaria();
    }
    @FXML
    private void regresarASecretaria(){
        registroCitaController.regresar();
    }
    @FXML
    void onRegistrar(){
        registrarCita();
    }
    @FXML
    private void registrarCita(){
        try{
            Cita cita = buildCita();
            if(cita == null){
                mostrarAlerta("Error", "Completa todos los campos");
                return;
            }
            if(registroCitaController.agregarCita(cita)){
                limpiarCampos();
                mostrarAlerta("Exito", "Cita agregada correctamente");
            } else {
                mostrarAlerta("Error", "No se pudo registrar la cita correctamente");
            }
        } catch (Exception e){
            mostrarAlerta("Error", "Datos invalidos" + e.getMessage());
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
        cbxSede.getItems().addAll(Sede.values());
        cargarEventos();
    }
    private void cargarMascotas(){
        cbxMascota.getItems().clear();
        cbxMascota.getItems().addAll(registroCitaController.obtenerMascotas());
        cbxMascota.setConverter(new StringConverter<Mascota>() {
            @Override
            public String toString(Mascota mascota) {
                return mascota != null ? mascota.getNombre() : "";
            }
            @Override
            public Mascota fromString(String string) {
                return null;
            }
        });
    }
    private void cargarVeterinarios(){
        cbxVeterinario.getItems().clear();
        cbxVeterinario.getItems().addAll(registroCitaController.obtenerVeterinarios());
        cbxVeterinario.setConverter(new StringConverter<Veterinario>() {
            @Override
            public String toString(Veterinario veterinario) {
                return veterinario != null ? veterinario.getNombre() : "";
            }
            @Override
            public Veterinario fromString(String string) {
                return null;
            }
        });
    }
    private void cargarEventos() {
        dtpFecha.valueProperty().addListener((obs, oldDate, newDate) -> {
            Veterinario vetSeleccionado = cbxVeterinario.getValue();
            System.out.println("DEBUG - Seleccionado veterinario: " + vetSeleccionado);
            if (newDate != null && registroCitaController != null && vetSeleccionado != null) {
                List<Hora> horas = registroCitaController.obtenerHorasVeterinario(vetSeleccionado.getId(), newDate);
                System.out.println("DEBUG - Horas recibidas: " + horas);
                cbxHora.getItems().setAll(horas);
            }
        });

        cbxVeterinario.valueProperty().addListener((obs, oldVet, newVet) -> {
            LocalDate fechaSeleccionada = dtpFecha.getValue();
            if (newVet != null && fechaSeleccionada != null && registroCitaController != null) {
                List<Hora> horas = registroCitaController.obtenerHorasVeterinario(newVet.getId(), fechaSeleccionada);
                cbxHora.getItems().setAll(horas);
            }
        });
    }
    private Cita buildCita() {
        String id = txtIdCita.getText();
        Hora hora = cbxHora.getValue();
        Sede sede = cbxSede.getValue();
        String consultorio = txtConsultorio.getText();
        LocalDate fecha = dtpFecha.getValue();
        Veterinario veterinario = cbxVeterinario.getValue();
        Mascota mascota = cbxMascota.getValue();
        Cita cita = new Cita(id, fecha, hora, sede, consultorio, mascota, veterinario);
        if (cita == null) {
            return null;
        }
        return cita;
    }

    public void setApp(App app){
        this.app = app;
    }
    public void setRegistroCitaController(RegistroCitaController registroCitaController){
        this.registroCitaController = registroCitaController;
        cargarMascotas();
        cargarVeterinarios();
    }
    private void limpiarCampos(){
        txtIdCita.clear();
        txtConsultorio.clear();
        cbxHora.setValue(null);
        cbxSede.setValue(null);
        cbxVeterinario.setValue(null);
        cbxMascota.setValue(null);
    }

}