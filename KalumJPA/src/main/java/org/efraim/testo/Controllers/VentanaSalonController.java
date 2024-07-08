package org.efraim.testo.Controllers;

import java.util.List;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

import org.efraim.testo.App;
import org.efraim.testo.db.Conexion;
import org.efraim.testo.models.Salon;




public class VentanaSalonController implements Initializable {

    private ObservableList<Salon> listaSalones;
    private App directorEscenas;

    @FXML
    private TableView<Salon> tblSalon;
    @FXML
    private TableColumn<Salon, String> colSalon;
    @FXML
    private TableColumn<Salon, String> colDescripcion;
    @FXML
    private TableColumn<Salon, Number> colCapacidad;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        listaSalones = FXCollections
                .observableArrayList((List<Salon>) Conexion.getInstancia().findAll("Salon.findAll"));
        this.tblSalon.setItems(listaSalones);

        this.colSalon.setCellValueFactory(cellSalon -> cellSalon.getValue().nombreSalon());
        this.colDescripcion.setCellValueFactory(cellDescripcion -> cellDescripcion.getValue().descripcion());
        this.colCapacidad.setCellValueFactory(cellCapacidad -> cellCapacidad.getValue().capacidad());
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public void mostrarVentanaPrincipal() {
        this.directorEscenas.mostrarVentanaPrincipal();
    }
    public void mostrarVentanaSalonAddUpdate() {
        this.directorEscenas.mostrarVentanaSalonAddUpdate();
    }

}