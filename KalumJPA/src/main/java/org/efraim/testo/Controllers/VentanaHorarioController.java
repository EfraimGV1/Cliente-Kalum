package org.efraim.testo.Controllers;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.efraim.testo.App;
import org.efraim.testo.db.Conexion;
import org.efraim.testo.models.Horario;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class VentanaHorarioController implements Initializable{
    private App directorEscenas;
    private ObservableList<Horario> listaHorarios;

    @FXML
    private TableView<Horario> tblHorario;
    @FXML
    private TableColumn<Horario, String> colHorarioInicio;
    @FXML
    private TableColumn<Horario, String> ColHorarioFInal;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DateFormat horarioFormat = new SimpleDateFormat("HH:mm");

        listaHorarios = FXCollections
                .observableArrayList((List<Horario>) Conexion.getInstancia().findAll("Horario.findAll"));
        this.tblHorario.setItems(listaHorarios);

        this.colHorarioInicio.setCellValueFactory(cellHorarioInicio -> new ReadOnlyStringWrapper(
                horarioFormat.format(cellHorarioInicio.getValue().getHorarioInicio())));
        this.ColHorarioFInal.setCellValueFactory(cellHorarioFinal -> new ReadOnlyStringWrapper(
                horarioFormat.format(cellHorarioFinal.getValue().getHorarioFinal())));
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
    public void mostrarVentanaHorarioAddUpdate() {
        this.directorEscenas.mostrarVentanaHorarioAddUpdate();
    }
    
    
}