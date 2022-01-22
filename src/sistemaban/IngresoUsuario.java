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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class IngresoUsuario extends Application  {
    
    @Override
    public void start(Stage primaryStage) {
                
        //****************************************************
        //CREAR LOS CONTROLES
        //****************************************************
        
        Button BtnGrabar = new Button("Grabar");
        Button BtnLimpiar= new Button("Limpiar");
        Button BtnEnter = new Button("Enter");
        Button BtnCopiar = new Button("Copiar");
        Button BtnCortar = new Button("Cortar");
        Button BtnPegar = new Button("Pegar");
        
        Label LblTitulo = new Label("__________________________________________________________________________________________________________________");
        
        Image img = new Image ("sistemaban/ilustracions/user.png");
        ImageView imgusu = new ImageView(img);
        
        imgusu.setFitWidth(90);
        imgusu.setPreserveRatio(true);
        imgusu.setSmooth(true);
        imgusu.setCache(true);
        
        Label LblNombres = new Label("Nombres: ");
        TextField TxfNombres = new TextField();
        
        Label LblApellidos = new Label("    Apellidos: ");
        TextField TxfApellidos = new TextField();
        
        Label Lblfecha = new Label("     Fecha: ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        Label LblEmail = new Label("     Email ID: ");
        TextField TxfEmail = new TextField();
        Label Lbldirecc = new Label("     Dirección: ");
        TextField Txfdirecc = new TextField();
        Label LblTele = new Label("     Telefono: ");
        TextField TxfTele = new TextField();
        Label LblCiuda = new Label("     Ciudad: ");
        ComboBox cboCiuda = new ComboBox(); 
        
        cboCiuda.getItems().addAll("Quito","Guayaquil","Cuenca","Manta","Ambato","Loja","Machala","Ibarra","Portoviejo","Latacunga","Santo Domingo","Otros......");
        cboCiuda.setVisibleRowCount(3);
        cboCiuda.setPromptText("Seleccione su Ciudad");
        
        Label Lblmont = new Label("                 Monto de entrada: ");
        TextField Txfmonto = new TextField();
        Label Lblsimbol = new Label("$");
        
        Label LblNotas = new Label(" Notas:");
        TextArea TxaNotas = new TextArea();
    
        //****************************************************
        //Asociar etiquetas a los controles
        //****************************************************
        LblNombres.setLabelFor(TxfNombres);
        LblNotas.setLabelFor(LblNotas);
       
        
        //****************************************************
        //Setear msgs informativos
        //****************************************************
        TxfNombres.setPromptText("Ingrese sus dos nombres");
        TxfApellidos.setPromptText("Ingrese sus dos Apellidos");
        Txfmonto.setPromptText("0,00");
        TxaNotas.setPromptText("Ingresar Notas Extras");
        
        
        TxaNotas.setPrefColumnCount(40);
        TxaNotas.setPrefRowCount(5);
        
        TxaNotas.setEditable(false);
        
        //Setear botones
        BtnEnter.setDefaultButton(true);
        
        
        
        //******************************************************
        //Acciones
        //******************************************************
        BtnGrabar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String CamposError="";
                if (TxfNombres.getText().length()==0) {
                    CamposError+="El campo Nombre es onbligatorio y debe ser ingresado\n";
                }
                if (TxaNotas.getText().length()==0) {
                    CamposError+="El campo Notas es obligatorio y debe ser ingresado\n";
                }
                if (CamposError.length()==0) { //Valida campos no sean vacios
                    if (bValidarInt(TxfNombres,LblNombres.getText()) == true) { //valida tipo de contenido Intger
                        TxaNotas.setText("");
                        TxaNotas.appendText("Nota: " + TxfNombres.getText() + "\n");
                        //if (RdbSubaru.isSelected()) {
                            //TxaResumen.appendText("Marca: " + RdbSubaru.getText() + "\n" );
                        }
                        
                    else { //errores de conversion
                        TxfNombres.requestFocus();
                    }
                }
                else {
                    Alert AltVentanaError = new Alert(AlertType.INFORMATION);
                    AltVentanaError.setTitle("Mensajes Informativos de Error");
                    AltVentanaError.setHeaderText("Mensajes de Validacion");
                    AltVentanaError.setContentText(CamposError);
                    AltVentanaError.showAndWait();
                }
                
                
            }
        });
        BtnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TxfNombres.setText("");
                //
                //
                TxfNombres.setDisable(false);
                TxaNotas.setDisable(false);
            }
        });
        BtnEnter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Presiono tecla enter");
            }
        });
        BtnCopiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TxaNotas.copy();
            }
        });
        BtnCortar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TxaNotas.cut();
            }
        });
        BtnPegar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TxaNotas.paste();
            }
        });
        

        BtnGrabar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/save.png",30,30,true,true)));
        BtnLimpiar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/clear.png",30,30,true,true)));
        BtnEnter.setGraphic(new ImageView(new Image("sistemaban/ilustracions/enter.png",30,30,true,true)));
        BtnCopiar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/copy.png",30,30,true,true)));
        BtnCortar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/cut.png",30,30,true,true)));
        BtnPegar.setGraphic(new ImageView(new Image("sistemaban/ilustracions/paste.png",30,30,true,true)));
        
        DatePicker fecha =new DatePicker(LocalDate.now());
        fecha.setConverter(new LocalDateStringConverter(formato,null));
        fecha.setMaxSize(100, 50);
        
        
        GridPane root = new GridPane();
        GridPane root4 = new GridPane(); 
        GridPane root5 = new GridPane();
        GridPane root6 = new GridPane();
        GridPane root7 = new GridPane();
        GridPane root8 = new GridPane();
        
        root.setHgap(10); //Espacio horizontal
        root.setVgap(8); //Espacio vertical
        
       
        root4.setHgap(10);
        root4.setVgap(8);
        root4.addRow(0, BtnGrabar, BtnLimpiar, BtnEnter,BtnCopiar,BtnCortar,BtnPegar);
        
        root5.setHgap(10);
        root5.setVgap(8);
        root5.addRow(0, imgusu, LblNombres, TxfNombres,LblApellidos,TxfApellidos);
        
        root6.setHgap(10);
        root6.setVgap(8);
        root6.addRow(0, Lblfecha, fecha);
        root6.add(LblEmail, 0, 2);
        root6.add(TxfEmail, 1, 2);
        root6.add(Lbldirecc, 8, 2);
        root6.add(Txfdirecc, 9, 2);
        root6.add(LblTele, 0, 4);
        root6.add(TxfTele, 1, 4);
        root6.add(LblCiuda, 8, 4);
        root6.add(cboCiuda, 9, 4);
        
        root7.setHgap(10);
        root7.setVgap(8);
        root7.add(Lblmont, 6, 5);
        root7.add(Txfmonto, 7, 5);
        root7.add(Lblsimbol, 8, 5);
        
        root8.setHgap(10);
        root8.setVgap(8);
        root8.add(LblNotas, 1, 6);
        root8.add(TxaNotas, 2, 6);
   
        //Panel mostrado es el root
        root.add(root4,1,2);
        root.add(LblTitulo,1,3 );
        root.add(root5,1,4 );
        root.add(root6,1,6 );
        root.add(root7,1,7 );
        root.add(root8,1,8 );
        
   
        Scene scene = new Scene(root, 585, 550);
        
        primaryStage.setTitle("Ingreso de usuario");
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