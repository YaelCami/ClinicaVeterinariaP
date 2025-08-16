module co.edu.uniquindio.poo.clinicaveterinariap {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.clinicaveterinariap to javafx.fxml;
    exports co.edu.uniquindio.poo.clinicaveterinariap;
    exports co.edu.uniquindio.poo.clinicaveterinariap.viewController;
    opens co.edu.uniquindio.poo.clinicaveterinariap.viewController to javafx.fxml;

}