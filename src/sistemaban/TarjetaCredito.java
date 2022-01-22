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
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class TarjetaCredito extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label lblCuenta = new Label("     CUENTA CORRIENTE");
        lblCuenta.setFont(Font.font("verdana",FontWeight.BLACK, 20));
        Label lblNumeroCuenta = new Label("    N.");
        Label lblMonto = new Label("   $");  
        TextField txtNumeroCUenta = new TextField("");
        txtNumeroCUenta.setPrefColumnCount(7);

        Label lblContrato = new Label("    NUMERO DE CUENTA: ");
        TextField txtContrato = new TextField("");
        txtContrato.setPromptText("Ej. 2217 5820 5455 0274");
        
        Label lblCLiente = new Label("    CLIENTE: ");
        TextField txtCLiente = new TextField("");
        txtCLiente.setPromptText("Ingrese nombre del cliente");
        
        Label lblTipo = new Label("    BANCO EMISOR");
        ComboBox<String> cboCuenta = new ComboBox<String>();
        cboCuenta.getItems().addAll("BANCO BOLIVARIANO", "BANCO PICHINCHA", "BANCO DEL PACIFICO", "BANCO GUAYAQUIL", "BANCO DEL AUSTRO", "PRODUBANCO");
        cboCuenta.setVisibleRowCount(3);
        cboCuenta.setPromptText("Escoge la institucion financiera");
        
        Label lblIdentificacion = new Label("    TIPO DE IDENTIFICACION: ");
        TextField txtIdentificacion = new TextField("");
        txtIdentificacion.setPromptText("Ej. 1724153802");
        txtCLiente.setPromptText("Ingrese nombre del cliente");
        RadioButton rbCedula = new RadioButton ("Cedula");
        RadioButton rbRUC = new RadioButton ("RUC");
        RadioButton rbPasaporte = new RadioButton ("Pasaporte");
        
        Label lblMontoPagar = new Label("    MONTO A PAGAR: ");
        TextField txtMonto = new TextField("");
        txtMonto.setPromptText("0.00");
        txtMonto.setMaxSize(100, 10);
        
        
        //imagen
        Image img = new Image ("sistemaban/ilustracions/tarjetas.png");
        ImageView imgLu = new ImageView(img);
        
        imgLu.setFitWidth(300);
        imgLu.setPreserveRatio(true);
        imgLu.setSmooth(true);
        imgLu.setCache(true);
        
        Button btnPagar = new Button("PAGAR");
        btnPagar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cboCuenta.getSelectionModel().getSelectedIndex()>=0){
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Msg del sistema");
                    alerta.setContentText("Pago realizado con exito");
                    alerta.showAndWait();
                }else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Msg del sistema");
                    alerta.setContentText("Error: no seleecion ningun campo");
                    alerta.showAndWait();
                }
            }
        });
        
        btnPagar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/pagar.png",30,30,true,true)));
        
        GridPane Pantalla = new GridPane();
        GridPane root1 = new GridPane();
        GridPane root2 = new GridPane();
        GridPane root3 = new GridPane();
        HBox Cuenta = new HBox(lblNumeroCuenta, txtNumeroCUenta, lblMonto);
        HBox Identificacion = new HBox(10,rbCedula, rbRUC, rbPasaporte);
        
        Pantalla.setHgap(15);
        Pantalla.setVgap(15);
        
        root1.setHgap(10);
        root1.setVgap(8);
        root1.add(imgLu, 9, 1);
        
        root2.setHgap(50);
        root2.setVgap(10);
        root2.addRow(0, Cuenta);
        root2.addRow(2, lblCLiente, txtCLiente);
        root2.addRow(3, lblContrato, txtContrato);
        root2.addRow(4, lblIdentificacion, Identificacion);
        root2.addRow(5, new Label (""), txtIdentificacion);
        root2.addRow(6, lblTipo, cboCuenta);
        root2.addRow(7, lblMontoPagar, txtMonto);
        
        root3.setHgap(10);
        root3.setVgap(8);
        root3.add(btnPagar, 18, 1);

        Pantalla.addRow(0, lblCuenta);
        Pantalla.addRow(1, Cuenta);
        Pantalla.addRow(2, root1);
        Pantalla.addRow(3, root2);
        Pantalla.addRow(4, root3);
        
        
        
        Pantalla.setStyle("-fx-background-color: #D2B4DE");
        
        Scene scene = new Scene(Pantalla, 470, 560);
        
        primaryStage.setTitle("Planilla de Internet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

