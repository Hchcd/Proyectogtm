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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PlanillaInternet extends Application{
    @Override
    public void start(Stage primaryStage) {
        Label lblCuenta = new Label("     CUENTA CORRIENTE");
        lblCuenta.setFont(Font.font("verdana",FontWeight.BLACK, 20));
        Label lblNumeroCuenta = new Label("    N.");
        Label lblMonto = new Label("   $");  
        TextField txtNumeroCUenta = new TextField("");
        txtNumeroCUenta.setPrefColumnCount(7);

        Label lblContrato = new Label("    CUENTA FINANCIERA: ");
        TextField txtContrato = new TextField("");
        
        Label lblCLiente = new Label("    CLIENTE: ");
        TextField txtCLiente = new TextField("");
        txtCLiente.setPromptText("Ingrese nombre del cliente");
        
        Label lblTipo = new Label("    TIPO DE TARJETA");
        ComboBox<String> cboCuenta = new ComboBox<String>();
        cboCuenta.getItems().addAll("Tarjeta de debito", "Tarjeta de credito", "Efectivo");
        cboCuenta.setVisibleRowCount(3);
        cboCuenta.setPromptText("Seleccionar tipo de tarjeta");
        
        Label lblMontoPagar = new Label("    MONTO A PAGAR: ");
        TextField txtMonto = new TextField("");
        txtMonto.setPromptText("0.00");
        txtMonto.setMaxSize(100, 10);
        
        Label lblDescripcion = new Label("    DESCRIPCION: ");
        TextArea txaDescripcion = new TextArea("");
        txaDescripcion.setPromptText("Ingrese una descripcion");
        txaDescripcion.setMaxSize(300, 100);
        
        
        Image img = new Image ("sistemaban/ilustracions/internet.png");
        ImageView imgLu = new ImageView(img);
        
        imgLu.setFitWidth(200);
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
        HBox Cuenta = new HBox(lblNumeroCuenta, txtNumeroCUenta, lblMonto);
        GridPane root1 = new GridPane();
        GridPane root2 = new GridPane();
        GridPane root3 = new GridPane();

        
        
        Pantalla.setHgap(15);
        Pantalla.setVgap(15);
        
        root1.setHgap(10);
        root1.setVgap(8);
        root1.add(imgLu, 15, 1);
        
        root2.setHgap(50);
        root2.setVgap(10);
        root2.addRow(0, lblCLiente, txtCLiente);
        root2.addRow(1, lblContrato, txtContrato);
        root2.addRow(2, lblTipo, cboCuenta);
        root2.addRow(3, lblMontoPagar, txtMonto);
        root2.addRow(4, lblDescripcion, txaDescripcion);
        
        root3.setHgap(10);
        root3.setVgap(8);
        root3.add(btnPagar, 18, 1);
       

        Pantalla.addRow(0, lblCuenta);
        Pantalla.addRow(1, root1);
        Pantalla.addRow(2, Cuenta);
        Pantalla.addRow(3, root2);
        Pantalla.addRow(4, root3);
        
        Pantalla.setStyle("-fx-background-color: #85C1E9");
        Scene scene = new Scene(Pantalla, 500, 450);
        
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
