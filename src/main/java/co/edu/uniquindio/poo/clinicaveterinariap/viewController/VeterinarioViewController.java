package co.edu.uniquindio.poo.clinicaveterinariap.viewController;

import co.edu.uniquindio.poo.clinicaveterinariap.App;
import co.edu.uniquindio.poo.clinicaveterinariap.controller.VeterinarioController;
import co.edu.uniquindio.poo.clinicaveterinariap.model.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class VeterinarioViewController {
    private VeterinarioController veterinarioController;
    private App app;
    private Veterinario veterinario;
    public void setVeterinarioController(VeterinarioController veterinarioController){
        this.veterinarioController = veterinarioController;
        if(veterinarioController.obtenerListaMascotas() != null){
            cbxMascota.getItems().addAll(veterinarioController.obtenerListaMascotas());
        } else {
            System.out.println("No se encontro el Lista de Mascotas");
        }
        if (veterinarioController.obtenerListaTratamientos() != null){
            cbxTratamiento.getItems().addAll(veterinarioController.obtenerListaTratamientos());
        } else{
            System.out.println("No se encontro el Lista de Tratamientos");
        }
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblIdCita, lblIdConsulta, lblNombre;
    @FXML
    private Button btnRegresar, btnRegistrar;
    @FXML
    private ComboBox<Mascota> cbxMascota;
    @FXML
    private ComboBox<Hora> cbxHora;
    @FXML
    private ComboBox<Tratamiento> cbxTratamiento;
    @FXML
    private TextArea txaMotivo, txaDiagnostico;
    @FXML
    private DatePicker dtpFecha;
    @FXML
    void onRegresar(){
        regresarAlPrincipal();
    }
    @FXML
    private void regresarAlPrincipal(){
        veterinarioController.regresarAlPrimary();
    }
    @FXML
    void onRegistrar(){
        registrarConsulta();
    }
    private void registrarConsulta(){
        try{
            Consulta consulta = buildConsulta();
            if(consulta == null){
                mostrarAlerta("Errorcito","Por fa completa todos los campos");
                return;
            }
            if(veterinarioController.registrarConsulta(consulta)){
                mostrarAlerta("Exito","Agregado exitosamente");
            } else{
                mostrarAlerta("Error", "No se pudo agregar la consulta");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private Consulta buildConsulta(){
        String id = lblIdCita.getText();
        LocalDate fecha = dtpFecha.getValue();
        Hora hora = cbxHora.getValue();
        String motivo = txaMotivo.getText();
        String diagnostico = txaDiagnostico.getText();

        Mascota mascota = cbxMascota.getValue();
        Tratamiento tratamiento = cbxTratamiento.getValue();
        Consulta consulta = new Consulta(id,mascota,fecha,hora,motivo,diagnostico,veterinario);
        return consulta;
    }

    public void initialize(){

        cbxMascota.setConverter(new StringConverter<Mascota>() {
            @Override
            public String toString(Mascota mascota) {
                return mascota != null ? mascota.getNombre() : "";
            }

            @Override
            public Mascota fromString(String s) {
                return null;
            }
        });

        cbxTratamiento.setConverter(new StringConverter<Tratamiento>() {
            @Override
            public String toString(Tratamiento tratamiento) {
                return tratamiento != null ? tratamiento.getMedicamento() : "";
            }

            @Override
            public Tratamiento fromString(String s) {
                return null;
            }
        });

    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
        lblNombre.setText(veterinario.getNombre());
    }
    public void setApp(App app) {
        this.app = app;
    }

}
