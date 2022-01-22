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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ContextMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MenuBan extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Creación controles Constructores
        MenuBar mnbBanco = new MenuBar(); //crear la barra de menu
        Menu mnuUsuario = new Menu("_Usuario"); //Crear el menu
        Menu mnuTrans = new Menu("Transferencia"); //Crear el menu
        Menu mnuTipo = new Menu("Tipo"); //Crear el menu
        Menu mnucajero = new Menu("Cajero");
        Menu mnupago = new Menu("Pago");
       
        MenuItem mniIngreso = new MenuItem("_Ingresar nuevo usuario"); //Crear el menuItem
        MenuItem mniDeposito = new MenuItem("_Deposito bancario"); //Crear el menuItem
        MenuItem mniRetiro = new MenuItem("_Tarjeta de Debito"); //Crear el menuItem
        MenuItem mniVerBD = new MenuItem("Ver Base de datos"); //Crear el menuItem
        
        MenuItem mniluz = new MenuItem("_Planilla de Luz");
        MenuItem mniagua = new MenuItem("_Planilla de agua");
        MenuItem mniinternet = new MenuItem("_Planilla de Internet");
        MenuItem mnitarjeta = new MenuItem("_Tarjeta de credito");
        

        RadioMenuItem rmnEasy = new RadioMenuItem("_Directa"); //Crear el RadioMenuItem
        RadioMenuItem rmnMedium = new RadioMenuItem("_Interbancaria"); //Crear el RadioMenuItem
        ToggleGroup tggTipo = new ToggleGroup(); //Crear el ToggleGroup
        
        
        
        Image img = new Image ("sistemaban/ilustracions/interfaz.png");
        ImageView imgView =new ImageView(img);
        
        imgView.setFitWidth(400);
        imgView.setPreserveRatio(true);
        imgView.setSmooth(true);
        imgView.setCache(true);
        
        
        //Setear mnemonic
        mnuUsuario.setMnemonicParsing(true);
        mniIngreso.setMnemonicParsing(true);
        mniDeposito.setMnemonicParsing(true);
        mniRetiro.setMnemonicParsing(true);
        mniVerBD.setMnemonicParsing(true);
        
        //Asigna los RadioMenuItems al ToogleGroup agregar todos o cada RadioMenuItem se agrega al Toogle
        tggTipo.getToggles().addAll(rmnEasy,rmnMedium);
        
        mnbBanco.getMenus().addAll(mnuUsuario,mnuTrans,mnucajero, mnupago);
        
        mnuUsuario.getItems().addAll(mniIngreso, new SeparatorMenuItem(), mniVerBD);
        
        mnucajero .getItems().addAll(mniDeposito,mniRetiro);
        
        mnupago.getItems().addAll(mniluz,mniagua,mniinternet,mnitarjeta);
 
        mnuTrans.getItems().addAll(new SeparatorMenuItem(),mnuTipo);
        
        mnuTipo.getItems().addAll(rmnEasy,rmnMedium);
        
        
        
        
        //Acciones del MenuItem
        rmnEasy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Directa dir = new Directa();
                dir.start(new Stage());
                
            }
        });
        
        rmnMedium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _TipoInterbancaria Inter = new _TipoInterbancaria();
                Inter.start(new Stage());
                
            }
        });
        
        mniIngreso.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                IngresoUsuario escena1 = new IngresoUsuario();
                escena1.start(new Stage());
                
            }
        });
        
        mniVerBD.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BaseDato escena2 = new BaseDato();
                escena2.start(new Stage());
                
            }
        });
        
        
        mniDeposito.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Depositar
                     objDepositar  = new Depositar();
                     objDepositar.start(new Stage());
            }
        });
         mniRetiro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Retirar
                     objRetirar  = new Retirar();
                     objRetirar.start(new Stage());
            }
        });
        //pago
        mniluz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PLanilla_Luz escenaLU = new PLanilla_Luz();
                escenaLU.start(new Stage());
            }
        });
        mniagua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Planilla_Agua escenaAWU = new Planilla_Agua();
                escenaAWU.start(new Stage());
            }
        });
        mniinternet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PlanillaInternet escenaINTE = new PlanillaInternet();
                escenaINTE.start(new Stage());
            }
        });
        mnitarjeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TarjetaCredito escenaTAR = new TarjetaCredito();
                escenaTAR.start(new Stage());
            }
        });
        
        
        FlowPane root = new FlowPane();
        root.getChildren().add(mnbBanco); //Agregar la barra de Menu o MenuBar
        //root.getChildren().add(LblMsg);
        root.getChildren().add(imgView);
        
        
        //root.getChildren().add(BtnMenu);
        
        Scene scene = new Scene(root, 385, 250);
        
        primaryStage.setTitle("Menu Banco");
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
    
