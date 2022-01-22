/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaban;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.shape.Circle;

/**
 *
 * @author Usuario
 */
public class SistemaBan extends Application{
    @Override
    public void start(Stage primaryStage) {
                
        //****************************************************
        //CREAR LOS CONTROLES
        //****************************************************
        Label LblTitulo = new Label(" ACCESO AL SISTEMA ");
        Label LblUsuario = new Label("               Usuario: ");
        Label LblClave = new Label("             Contraseña: ");
        Label LblCargo = new Label ("                  Cargo: ");
        TextField TxfUsuario = new TextField();
        
        PasswordField PwdClave = new PasswordField(); 
        
        ComboBox cboCargo = new ComboBox();
        cboCargo.getItems().addAll("Administrador","Cajero","Gerente");
        cboCargo.setPromptText("Seleccione el cargo");
     
        Button BtnGrabar = new Button();
        Button BtnLimpiar= new Button();
        Label LblIniciar =new Label("     Iniciar");
        Label LblCancela =new Label("                                 Cancelar");
            
        Image img = new Image ("sistemaban/ilustracions/bank.png");
        ImageView imgLogin = new ImageView(img);
        
        imgLogin.setFitWidth(200);
        imgLogin.setPreserveRatio(true);
        imgLogin.setSmooth(true);
        imgLogin.setCache(true);
        
        
        BtnGrabar.setMaxSize(50, 50);
        BtnLimpiar.setMaxSize(50, 50);
        
        
        
        
        //****************************************************
        //Asociar etiquetas a los controles
        //****************************************************
        LblUsuario.setLabelFor(TxfUsuario);
        LblClave.setLabelFor(PwdClave);
        
        //****************************************************
        //Setear msgs informativos
        //****************************************************
        TxfUsuario.setPromptText("Ingrese su usuario");
        PwdClave.setPromptText("Ingrese su contraseña");
        
        BtnGrabar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/camera_test.png",64,64,true,true)));
        BtnGrabar.setShape(new Circle(2));
        
        BtnLimpiar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/button_cancel.png")));
        BtnLimpiar.setShape(new Circle(2));
        
        
        
        
        
        //******************************************************
        //Acciones
        //******************************************************
        BtnGrabar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Node source =(Node) event.getSource();
                Stage stage = (Stage)source.getScene().getWindow();
                stage.close();
                MenuBan escena1 = new MenuBan();
                escena1.start(new Stage());
                
        
            }
        });
        BtnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TxfUsuario.setText("");
                
                TxfUsuario.setDisable(false);
                
            }
        });
        
        

        
        GridPane root = new GridPane();
    
        GridPane root4 = new GridPane(); //Botones
        
        
        root.setHgap(5); //Espacio horizontal
        root.setVgap(5); //Espacio vertical
        
        LblTitulo.setFont(Font.font("verdana",FontWeight.BLACK, 12));
        //LblMatricula.setMaxSize(50, 50);
        LblIniciar.setFont(Font.font("verdana",FontWeight.BOLD, 11));
        LblCancela.setFont(Font.font("verdana",FontWeight.BOLD, 11));
       
                
        root4.setHgap(30);
        root4.setVgap(100);
        root4.addRow(0, BtnGrabar, BtnLimpiar);
        
        
        
        root.add(imgLogin,3,7);
        root.add(LblTitulo,3,2 );
       
        root.add(LblUsuario,2,8); 
        root.add(TxfUsuario,3,8);
        root.add(LblClave,2,10);
        root.add(PwdClave,3,10);
        root.add(LblCargo,2,12);
        root.add(cboCargo,3,12);
        root.add(root4,3,15);
        root.add(LblIniciar,3,17);
        root.add(LblCancela,3,17);
        
        
        
        
        
        Scene scene = new Scene(root, 400, 500);
        
        primaryStage.setTitle("Sistema Bancario");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public boolean bValidarInt(TextInputControl Texto, String Etiqueta) {
        try {
            Integer.parseInt(Texto.getText());
            return  true;
        }
        catch (NumberFormatException e) {
            Alert AltVentanaError = new Alert(AlertType.INFORMATION);
            AltVentanaError.setTitle("Mensajes Informativos de Error");
            AltVentanaError.setHeaderText("Mensajes de Conversión");
            AltVentanaError.setContentText("El campor " + Etiqueta + " no puede ser convertido a Entero. Revise el conenido del campo");
            AltVentanaError.showAndWait();
            return false;
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}