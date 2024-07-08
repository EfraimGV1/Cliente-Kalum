package org.efraim.testo.Controllers;

import org.efraim.testo.db.Conexion;
import org.efraim.testo.App;
import org.efraim.testo.models.CarreraTecnica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class VentanaCarreraTecnicaController implements Initializable {

    private ObservableList<CarreraTecnica> listaCarreras;
    private App directorEscenas;

    @FXML
    private TableView<CarreraTecnica> tblCarreraTecnica;
    @FXML
    private TableColumn<CarreraTecnica, String> colNombreCarrera;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaCarreras = FXCollections
        .observableArrayList((List<CarreraTecnica>) Conexion.getInstancia().findAll("CarreraTecnica.findAll"));
        this.tblCarreraTecnica.setItems(listaCarreras);

        this.colNombreCarrera.setCellValueFactory(cellCarrera -> cellCarrera.getValue().nombreCarrera());

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
    public void mostrarVentanaCarreraAddUpdate() {
        this.directorEscenas.mostrarVentanaCarreraAddUpdate();
    }


    }

