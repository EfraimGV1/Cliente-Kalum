package org.efraim.testo;

import org.efraim.testo.Controllers.VentanaCarreraTecnicaAddUpdateController;
import org.efraim.testo.Controllers.VentanaCarreraTecnicaController;
import org.efraim.testo.Controllers.VentanaClaseAddUpdateController;
import org.efraim.testo.Controllers.VentanaClaseController;
import org.efraim.testo.Controllers.VentanaHorarioAddUpdateController;
import org.efraim.testo.Controllers.VentanaHorarioController;
import org.efraim.testo.Controllers.VentanaInstructorAddUpdateController;
import org.efraim.testo.Controllers.VentanaInstructorController;
import org.efraim.testo.Controllers.VentanaPrincipalController;
import org.efraim.testo.Controllers.VentanaSalonAddUpdateController;
import org.efraim.testo.Controllers.VentanaSalonController;
import org.efraim.testo.models.Clase;

import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;

public class App extends Application {
    private Stage escenarioPrincipal;
    private final String PAQUETE_VISTAS = "/org/efraim/testo/Views/";

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {

        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("Kalum v1.0.0");
        mostrarVentanaPrincipal();
        this.escenarioPrincipal.show();
    }

    public void mostrarVentanaPrincipal() {
        try {
            VentanaPrincipalController ventanaPrincipalView = (VentanaPrincipalController) cambiarEscena(
                    "VentanaPrincipalView.fxml", 640, 400);
            ventanaPrincipalView.setDirectorEscenas(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaSalon() {
        try {
            VentanaSalonController ventanaSalonView = (VentanaSalonController) cambiarEscena("SalonView.fxml", 600,
                    400);
            ventanaSalonView.setDirectorEscenas(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaSalonAddUpdate() {
        try {
            VentanaSalonAddUpdateController ventanaSalonAddUpdate = (VentanaSalonAddUpdateController) cambiarEscena(
                    "VentanaSalonAddUpdateView.fxml", 640, 400);
            ventanaSalonAddUpdate.setDirectorEscenas(this);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void mostrarVentanaCarrera() {
        try {
            VentanaCarreraTecnicaController ventanacarreraView = (VentanaCarreraTecnicaController) cambiarEscena(
                    "CarreraTecnicaView.fxml", 640, 400);
            ventanacarreraView.setDirectorEscenas(this);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void mostrarVentanaCarreraAddUpdate() {
        try {
            VentanaCarreraTecnicaAddUpdateController ventanacarreraAddUpdate = (VentanaCarreraTecnicaAddUpdateController) cambiarEscena(
                    "VentanaCarreraTecnicaAddUpdateView.fxml", 640, 400);
            ventanacarreraAddUpdate.setDirectorEscenas(this);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void mostrarVentanaInstructor(){
        try {
            VentanaInstructorController ventanaInstructorView = (VentanaInstructorController) cambiarEscena("InstructorView.fxml", 640, 400);
            ventanaInstructorView.setDirectorEscenas(this);                        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarVentanaInstructorAddUpdate() {
        try {
            VentanaInstructorAddUpdateController ventanaInstructorAddUpdate = (VentanaInstructorAddUpdateController) cambiarEscena(
                    "VentanaInstructorAddUpdate.fxml", 645, 500);
            ventanaInstructorAddUpdate.setDirectorEscenas(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void mostrarVentanaHorario(){
        try {
            VentanaHorarioController ventanaHorarioView = (VentanaHorarioController) cambiarEscena("HorarioView.fxml", 640, 400);
            ventanaHorarioView.setDirectorEscenas(this);                        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarVentanaHorarioAddUpdate() {
        try {
            VentanaHorarioAddUpdateController ventanaHorarioAddUpdateView = (VentanaHorarioAddUpdateController) cambiarEscena(
                    "VentanaHorarioAddUpdate.fxml", 600, 400);
            ventanaHorarioAddUpdateView.setDirectorEscenas(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarVentanaClase() {
        try {
            VentanaClaseController ventanaClaseView = (VentanaClaseController) cambiarEscena("ClaseView.fxml", 871,
                    519);
            ventanaClaseView.setDirectorEscenas(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarVentanaClaseAddUpdate() {
        try {
            VentanaClaseAddUpdateController ventanaClaseAddUpdate = (VentanaClaseAddUpdateController) cambiarEscena(
                    "VentanaClaseAddUpdate.fxml", 570, 545);
            ventanaClaseAddUpdate.setDirectorEscenas(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarVentanaClaseAddUpdate(Clase clase) {
        try {
            VentanaClaseAddUpdateController ventanaClaseAddUpdate = (VentanaClaseAddUpdateController) cambiarEscena(
                    "VentanaClaseAddUpdate.fxml", 570, 545);
            ventanaClaseAddUpdate.setDirectorEscenas(this);
            ventanaClaseAddUpdate.setClase(clase);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




        public Initializable cambiarEscena(String escena, int ancho, int alto) throws IOException {
            Initializable resultado = null;
            FXMLLoader cargadorFXML = new FXMLLoader();
            InputStream archivoFXML = App.class.getResourceAsStream(PAQUETE_VISTAS + escena);
            cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
            cargadorFXML.setLocation(App.class.getResource(PAQUETE_VISTAS + escena));
            Scene miEscena = new Scene((AnchorPane) cargadorFXML.load(archivoFXML), ancho, alto);
            this.escenarioPrincipal.setScene(miEscena);
            this.escenarioPrincipal.sizeToScene();
            resultado = (Initializable) cargadorFXML.getController();
            return resultado;
        }
}