package org.efraim.testo.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import org.efraim.testo.App;
import org.efraim.testo.db.Conexion;
import org.efraim.testo.models.CarreraTecnica;

public class VentanaCarreraTecnicaAddUpdateController implements Initializable {
    private App directorEscenas;
    private CarreraTecnica carrera;
    @FXML
    private TextField txtNombreCarrera;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void cancelar() {
        this.directorEscenas.mostrarVentanaCarrera();
    }

    public void guardar() {
        if (txtNombreCarrera.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Carrera");
            alert.setHeaderText(null);
            alert.setContentText("Error, Campos tienen que ser llenados");
            alert.initOwner(null);
            alert.show();
        } else {
            if (carrera != null) {
                carrera.setNombreCarrera(txtNombreCarrera.getText());
                Conexion.getInstancia().modificar(carrera);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Carrera");
                alert.setHeaderText(null);
                alert.setContentText("Registo Modificado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaCarrera();
            } else {
                carrera = new CarreraTecnica();
                carrera.setCarreraId(UUID.randomUUID().toString());
                carrera.setNombreCarrera(txtNombreCarrera.getText());
                Conexion.getInstancia().agregar(carrera);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Carrera");
                alert.setHeaderText(null);
                alert.setContentText("Carrera nueva almacenada Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaCarrera();

            }

        }
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public CarreraTecnica getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraTecnica carrera) {
        this.carrera = carrera;
        this.txtNombreCarrera.setText(carrera.getNombreCarrera());

    }

    
}