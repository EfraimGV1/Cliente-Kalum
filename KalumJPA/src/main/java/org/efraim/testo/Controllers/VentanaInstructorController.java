package org.efraim.testo.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.efraim.testo.App;
import org.efraim.testo.db.Conexion;
import org.efraim.testo.models.Instructor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;


public class VentanaInstructorController implements Initializable {

    private App directorEscenas;
    private ObservableList<Instructor> listaInstructores;

    @FXML private TableView<Instructor> tblInstructor;
    @FXML private TableColumn<Instructor,String> colApellidos;
    @FXML private TableColumn<Instructor,String> colNombres;
    @FXML private TableColumn<Instructor,String> colTelefonos;
    @FXML private TableColumn<Instructor,String> colDireccion;
    @FXML private TableColumn<Instructor,String> colFoto;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaInstructores = FXCollections.observableArrayList((List<Instructor>)Conexion.getInstancia().findAll("Instructor.findAll"));
        
        this.tblInstructor.setItems(listaInstructores);

        this.colApellidos.setCellValueFactory(cellApellidos -> cellApellidos.getValue().apellidos());
        this.colNombres.setCellValueFactory(cellNombres -> cellNombres.getValue().nombres());
        this.colTelefonos.setCellValueFactory(cellTelefonos -> cellTelefonos.getValue().telefono());
        this.colDireccion.setCellValueFactory(cellDireccion -> cellDireccion.getValue().direccion());
        this.colFoto.setCellValueFactory(cellTelefono -> cellTelefono.getValue().foto());
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public void mostrarVentanaPrincipal(){

        this.directorEscenas.mostrarVentanaPrincipal();

    }
    public void mostrarVentanaInstructorAddUpdate() {
        this.directorEscenas.mostrarVentanaInstructorAddUpdate();
    }
}
