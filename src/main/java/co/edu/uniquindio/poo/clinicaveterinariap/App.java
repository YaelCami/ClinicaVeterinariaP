package co.edu.uniquindio.poo.clinicaveterinariap;

import co.edu.uniquindio.poo.clinicaveterinariap.controller.*;
import co.edu.uniquindio.poo.clinicaveterinariap.model.*;
import co.edu.uniquindio.poo.clinicaveterinariap.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class App extends Application {
    private Stage primaryStage;
    private Veterinaria veterinaria = new Veterinaria("Uq", "Cra 7 #30-20", Sede.SEDE1);
    public Veterinaria getVeterinaria() {
        return veterinaria;
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Consultas");
        openViewPrincipal();
    }

    public void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudPrimary.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            PrimaryController primaryController = new PrimaryController(veterinaria);
            primaryViewController.setPrimaryController(primaryController);
            primaryViewController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
    public void openCrudSecretaria(Secretaria secretaria) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudSecretaria.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            SecretariaViewController secretariaViewController = loader.getController();
            SecretariaController secretariaController = new SecretariaController();
            secretariaController.setApp(this);
            secretariaController.setSecretaria(secretaria);
            secretariaViewController.setSecretariaController(secretariaController);
            secretariaViewController.setSecretaria(secretaria);
            secretariaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudVeterinario(Veterinario veterinario) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("registroConsulta.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            VeterinarioViewController veterinarioViewController = loader.getController();
            VeterinarioController veterinarioController = new VeterinarioController(veterinaria);
            veterinarioController.setApp(this);
            veterinarioController.setVeterinario(veterinario);
            veterinarioViewController.setVeterinarioController(veterinarioController);
            veterinarioViewController.setVeterinario(veterinario);
            veterinarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openRegistroMascota(Secretaria secretaria) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("registroMascota.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RegistroMascotaViewController registroMascotaViewController = loader.getController();
            RegistroMascotaController registroMascotaController = new RegistroMascotaController(veterinaria);
            registroMascotaController.setSecretaria(secretaria);
            registroMascotaController.setApp(this);
            registroMascotaViewController.setRegistroMascotaController(registroMascotaController);
            registroMascotaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openRegistroVeterinario(Secretaria secretaria) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("registroVeterinario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RegistroVeterinarioViewController registroVeterinarioViewController = loader.getController();
            RegistroVeterinarioController registroVeterinarioController = new RegistroVeterinarioController(veterinaria);
            registroVeterinarioController.setSecretaria(secretaria);
            registroVeterinarioController.setApp(this);
            registroVeterinarioViewController.setRegistroVeterinarioController(registroVeterinarioController);
            registroVeterinarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openRegistroPropietario(Secretaria secretaria) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("registroPropietario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RegistroPropietarioViewController registroPropietarioViewController = loader.getController();
            RegistroPropietarioController registroPropietarioController = new RegistroPropietarioController(veterinaria);
            registroPropietarioController.setSecretaria(secretaria);
            registroPropietarioController.setApp(this);
            registroPropietarioViewController.setRegistroPropietarioController(registroPropietarioController);
            registroPropietarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openRegistroCita(Secretaria secretaria) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("RegistroCita.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RegistroCitaViewController registroCitaViewController = loader.getController();
            RegistroCitaController registroCitaController = new RegistroCitaController(veterinaria);
            registroCitaController.setSecretaria(secretaria);
            registroCitaController.setApp(this);
            registroCitaViewController.setRegistroCitaController(registroCitaController);
            registroCitaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openListaMascotaPorEspecie() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("listaMascotasPorEspecie.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ListaMascotaPorEspecieViewController listaMascotaPorEspecieViewController = loader.getController();
            ListaMascotaPorEspecieController listaMascotaPorEspecieController = new ListaMascotaPorEspecieController();
            listaMascotaPorEspecieController.setApp(this);
            listaMascotaPorEspecieViewController.setListaMascotaPorEspecieController(listaMascotaPorEspecieController);
            listaMascotaPorEspecieViewController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openListaConsultaPorMascota() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("listaConsultaPorMascota.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ListaConsultaPorMascotaViewController listaConsultaPorMascotaViewController = loader.getController();
            ListaConsultaPorMascotaController listaConsultaPorMascotaController = new ListaConsultaPorMascotaController();
            listaConsultaPorMascotaController.setApp(this);
            listaConsultaPorMascotaViewController.setListaConsultaPorMascotaController(listaConsultaPorMascotaController);
            listaConsultaPorMascotaViewController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void inicializarData() {
        Secretaria secretaria1 = new Secretaria("Susana", "123", 4000000, "3anios");
        Veterinario veterinario1 = new Veterinario("Pachito", "134", "Gnu vl3", Especialidad.EXOTICOS);
        Veterinario veterinario2 = new Veterinario("Javier Solano", "890", "gnv340", Especialidad.GRANDES);
        Veterinario veterinario3 = new Veterinario("Nicola Baquero", "765", "grwe", Especialidad.PEQUENIOS);
        Veterinario veterinario4 = new Veterinario("Sandra Valencia", "456", "Veterinaria", Especialidad.EXOTICOS);
        veterinario1.setVeterinaria(veterinaria);
        veterinario2.setVeterinaria(veterinaria);
        veterinario3.setVeterinaria(veterinaria);
        veterinario4.setVeterinaria(veterinaria);
        secretaria1.setVeterinaria(veterinaria);
        Propietario propietario1 = new Propietario("Samuel", "333", "312", "Cra 5");
        Mascota mascota1 = new Mascota("Palermo", "Caniche", 2, "309", Especie.PERRO, propietario1);
        Cita cita1 = new Cita("3366", LocalDate.of(2025,8,25), Hora.CUARTACITA4A6PM, Sede.SEDE1, "Ceiva", mascota1, veterinario1);
        Tratamiento tratamiento1 = new Tratamiento("Paracetamol", "081jk", "una diaria", "2 meses");
        Tratamiento tratamiento2 = new Tratamiento("Acetaminofen", "39lq", "dos pastillas diarias", "una semana");
        Tratamiento tratamiento3 = new Tratamiento("Amoxicilina", "6yu", "una dia de por medio", "dos semanas");
        Tratamiento tratamiento4 = new Tratamiento("ivermectina", "ek90", "diaria", "8 meses");
        veterinaria.agregarPropietario(propietario1);
        veterinaria.agregarVeterinario(veterinario1);
        veterinaria.agregarVeterinario(veterinario2);
        veterinaria.agregarVeterinario(veterinario3);
        veterinaria.agregarVeterinario(veterinario4);
        veterinaria.agregarSecretaria(secretaria1);
        veterinaria.agregarMascota(mascota1);
        veterinaria.agregarCita( cita1);
        veterinaria.agregarTratamiento(tratamiento1);
        veterinaria.agregarTratamiento(tratamiento2);
        veterinaria.agregarTratamiento(tratamiento3);
        veterinaria.agregarTratamiento(tratamiento4);
        System.out.println("DEBUG - Lista de secretarias en veterinaria:");
        for (Secretaria s : veterinaria.getListSecretarias()) {
            System.out.println(" -> " + s.getId() + " - " + s.getNombre());
        }

    }
}