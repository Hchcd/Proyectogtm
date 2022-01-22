/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaban;

/**
 *
 * @author Usuario
 */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BaseDato extends Application {

    @Override
    public void start(Stage primaryStage) {
                
        //****************************************************
        //CREAR LOS CONTROLES
        //****************************************************
        Label LblTitulo = new Label("BASE DE DATOS DE USUARIOS");
        
        Image img = new Image ("sistemaban/ilustracions/bank.png");
        ImageView imgbase = new ImageView(img);
        
        imgbase.setFitWidth(100);
        imgbase.setPreserveRatio(true);
        imgbase.setSmooth(true);
        imgbase.setCache(true);
        
        TableView<Datos> tblclientes = new TableView<>();
     
        Button BtnEliminar  = new Button("Eliminar Usuario");
        
        //Setear botones
        BtnEliminar.setDefaultButton(true);
        
        
        //tblclientes.getColumns().addAll(getColfecha(),getColNombres(),getColApellidos(),getColtele(),getColdirecc(),getColciuda(),getColmonto());
        
        
        //******************************************************
        //Acciones
        //******************************************************
        
        BtnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        
        BtnEliminar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/delete.png",40,40,true,true)));
        //tblclientes.setMaxWidth(800);
        LblTitulo.setFont(Font.font("verdana",FontWeight.BLACK,FontPosture.REGULAR, 13));

        
        GridPane root = new GridPane();
        GridPane root2 = new GridPane();
        GridPane root3 = new GridPane();
        GridPane root4 = new GridPane(); 
        
        root.setHgap(10); //Espacio horizontal
        root.setVgap(8); //Espacio vertical
        
        root2.setHgap(5);
        root2.setVgap(8);
        root2.add(tblclientes,25,2);
        
        
        root3.setHgap(10);
        root3.setVgap(8);
        root3.add(imgbase,1,1);
        root3.add(LblTitulo,5,1);
        
        root4.setHgap(10);
        root4.setVgap(8);
        root4.add(BtnEliminar,18,1);
        
        root.addRow(0, root3);
        root.addRow(1, root2);
        root.addRow(2, root4);
        
        
       
    
        
        
        Scene scene = new Scene(root, 500, 350);
        
        primaryStage.setTitle("Base de datos USUARIOS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * 
     * public TableColumn<Datos,String> getColfecha() {
        TableColumn<Datos,Integer>  colCodigo = new TableColumn<>("Codigo");
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        return colfecha;
    }
    public TableColumn<Datos,String> getColNombres() {
        TableColumn<Datos,String>  colApellidosN = new TableColumn<>("Apellidos/Nombres");
        colApellidosN.setCellValueFactory(new PropertyValueFactory<>("ApellidosN"));
        return colNombres;
    }
    public TableColumn<Datos,String> getColApellidos() {
        TableColumn<Datos,String>  colExperiencia = new TableColumn<>("Experiencia");
        colExperiencia.setCellValueFactory(new PropertyValueFactory<>("Experiencia"));
        return colApellidos;
    }
    public TableColumn<Datos,Integer> getColtele() {
        TableColumn<Datos,String>  colSemestre = new TableColumn<>("Semestre");
        colSemestre.setCellValueFactory(new PropertyValueFactory<>("Semestre"));
        return coltele;
    }
    public TableColumn<Datos,String> getColdirecc() {
        TableColumn<Datos,String>  colCarrera = new TableColumn<>("Carrera");
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("Carrera"));
        return coldirecc;
    }
    public TableColumn<Datos,String> getColciuda() {
        TableColumn<Datos,String>  colFacultad = new TableColumn<>("Facultad");
        colFacultad.setCellValueFactory(new PropertyValueFactory<>("Facultad"));
        return colciuda;
    }
    public TableColumn<Datos,Float> getColmonto() {
        TableColumn<Datos,String>  colTrabaja = new TableColumn<>("Trabaja");
        colTrabaja.setCellValueFactory(new PropertyValueFactory<>("Trabaja"));
        return colmonto;
    } 
     */
    
    
    
}
