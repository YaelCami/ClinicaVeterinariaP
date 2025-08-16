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
        Secretaria secretaria1 = new Secretaria("Susana", "128", 4000000, "3años");
        secretaria1.setVeterinaria(veterinaria);
        Veterinario veterinario1 = new Veterinario("Pachito", "134", "Gnu vl3", Especialidad.EXOTICOS);
        veterinario1.setVeterinaria(veterinaria);
        Propietario propietario1 = new Propietario("Joselito", "333", "312", "Cra 5");
        Mascota mascota1 = new Mascota("Mordu", "Pitbull", "3", "369", Especie.PERRO, propietario1 );
        veterinaria.agregarPropietario(propietario1);
        veterinaria.agregarVeterinario(veterinario1);
        veterinaria.agregarSecretaria(secretaria1);
        System.out.println("DEBUG - Lista de secretarias en veterinaria:");
        for (Secretaria s : veterinaria.getListSecretarias()) {
            System.out.println(" -> " + s.getId() + " - " + s.getNombre());
        }

    }

}
