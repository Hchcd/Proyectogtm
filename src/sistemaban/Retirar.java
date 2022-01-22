
package sistemaban;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static javafx.application.Application.launch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;



public class Retirar {
    public void start(Stage primaryStage) {
    
    ComboBox<String> cboCuenta = new ComboBox<>();
        ComboBox<String> cboCliente = new ComboBox<>();
        
        
        ObservableList<String> cuenta = FXCollections.observableArrayList();
        cuenta.addAll("");
        cboCuenta.itemsProperty().setValue(cuenta);
        ObservableList<String> cliente = FXCollections.observableArrayList();
        cliente.addAll("");
        cboCliente.itemsProperty().setValue(cliente);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        DatePicker fecha = new DatePicker(LocalDate.now());
        fecha.setConverter(new LocalDateStringConverter(formatter, null));
        TextField txfCliente = new TextField();
        TextField txfCedula = new TextField();
        TextField txfCelular = new TextField();
        Text mensaje = new Text("Realiza tus retiros de una forma segura");
        Label lblHabilitacion = new Label("Datos de la Habilitacion");
        Label lblCliente = new Label("Datos del Cliente");
        Button btnContinuar = new Button("Continuar");
        Button btnRegresar = new Button("Principal");
        

        lblHabilitacion.setFont(Font.font("arial", 16));
        lblCliente.setFont(Font.font("arial", 16));

        lblHabilitacion.setStyle("-fx-font: 16 arial;");
        lblCliente.setStyle("-fx-font: 16 arial;");

        mensaje.setFont(Font.font("arial", 24));
        mensaje.setStyle("-fx-font: 24 arial;");

        mensaje.setFont(Font.font("arial", 24));
        mensaje.setStyle("-fx-font: 24 arial;");

        txfCliente.setMaxSize(250, 100);
        txfCedula.setMaxSize(180, 100);
        txfCelular.setMaxSize(180, 100);

        cboCuenta.setMinSize(450,5);
        cboCliente.setMinSize(450,5);
        
        Image img = new Image ("sistemaban/ilustracions/retiro.gif");
        ImageView imgView =new ImageView(img);
     
        imgView.setFitWidth(200);
        imgView.setPreserveRatio(true);
        imgView.setSmooth(true);
        imgView.setCache(true);
        
        
        
        btnRegresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuBan
                     objMenuBan  = new MenuBan();
                     objMenuBan.start(new Stage());
            }
        });
 

        GridPane pnlImagen = new GridPane();
        GridPane pnlHabilitacion = new GridPane();
        HBox pnlBotones = new HBox(5);

        pnlHabilitacion.setHgap(10);
        pnlHabilitacion.setVgap(10);
        pnlImagen.setHgap(10);
        pnlImagen.setVgap(10);

        pnlImagen.getChildren().add(imgView);
        
        
        
        pnlHabilitacion.addRow(0, pnlImagen, mensaje);
        pnlBotones.getChildren().addAll(btnContinuar,btnRegresar);
        
        pnlHabilitacion.addRow(1, new Label("Habilitacion Retiro Rapido"));
        pnlHabilitacion.addRow(2, new Label(""),lblHabilitacion);
        pnlHabilitacion.addRow(3, new Label("Cuenta para retiro:"), cboCuenta);
        pnlHabilitacion.addRow(4, new Label("Numero de Tarjeta"), cboCliente);
        pnlHabilitacion.addRow(5, new Label("Fecha de vencimiento de la habilitacion"), fecha);
        pnlHabilitacion.addRow(6, new Label(""),lblCliente);
        pnlHabilitacion.addRow(7, new Label(" Nombre completo del Cliente"), txfCliente);
        pnlHabilitacion.addRow(8, new Label("Cedula"), txfCedula);
        pnlHabilitacion.addRow(9, new Label("Numero de Celular"), txfCelular);
        pnlHabilitacion.add(pnlBotones,1,10);;

        
        pnlHabilitacion.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 10;"
                + "-fx-border-insets: 10;"
                + "-fx-border-radius: 10;"
                + "-fx-border-color: #045FB4;"
                + "-fx-background-color: #FFFFFF;");

        Scene scene = new Scene(pnlHabilitacion, 740, 650);

        primaryStage.setTitle("HABILITACION DE RETIROS RAPIDO");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}



