
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class _TipoInterbancaria {
    
    public void start(Stage primaryStage) {
        Label LblTitulo = new Label("TIPO TRANSFERENCIA");
        RadioButton rdbDeposito = new RadioButton("Deposito");
        RadioButton rdbTransferencia = new RadioButton("Transferencia");
        RadioButton rdbDinero = new RadioButton("Dinero");
        RadioButton rdbCheque = new RadioButton("Cheque");
        ToggleGroup tggOperacion = new ToggleGroup();
        ToggleGroup tggPago = new ToggleGroup();
        TextArea txaReferencia = new TextArea();
        ComboBox<String> cboCaja = new ComboBox<>();
        TextField txfValor = new TextField();
        Button btnConcluir = new Button("Concluir");
        Button btnRegresar = new Button("Principal");

        
        LblTitulo.setFont(Font.font("verdana",FontWeight.BLACK, 12));
        
        ObservableList<String> caja = FXCollections.observableArrayList();
        caja.addAll("BANCO PICHINCHA", "BANCO GUAYAQUIL", "BANCO PACIFICO");
        cboCaja.itemsProperty().setValue(caja);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        DatePicker fecha = new DatePicker(LocalDate.now());
        fecha.setConverter(new LocalDateStringConverter(formatter, null));

        txfValor.setMaxSize(250, 100);
        txaReferencia.setMaxSize(250, 5);
        txfValor.setPromptText("0.00");

        btnRegresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuBan
                     objMenuBan  = new MenuBan();
                     objMenuBan.start(new Stage());
            }
        });
        
        
         Image img = new Image("sistemaban/ilustracions/deposito.png");
        ImageView imgDeposito = new ImageView(img);
     
        
        
        imgDeposito.setFitWidth(200);
        imgDeposito.setPreserveRatio(true);
        imgDeposito.setSmooth(true);
        imgDeposito.setCache(true);

        tggOperacion.getToggles().addAll(rdbDeposito, rdbTransferencia);
        tggPago.getToggles().addAll(rdbDinero, rdbCheque);

        
        
        
        GridPane root = new GridPane();
        GridPane pnlOperacion = new GridPane();
        GridPane pnlPago = new GridPane();
        HBox pnlBotones = new HBox(5);

        pnlOperacion.addRow(0, rdbDeposito);
        pnlOperacion.addRow(1, rdbTransferencia);
        pnlPago.addRow(0, rdbDinero);
        pnlPago.addRow(1, rdbCheque);
        pnlBotones.getChildren().addAll(btnConcluir,btnRegresar);
        
        root.setHgap(10);
        root.setVgap(10);
        root.addRow(0,LblTitulo);
        root.addRow(1, new Label(""), imgDeposito);
        root.addRow(2, new Label("Cuenta origen"), pnlOperacion);
        root.addRow(2, new Label("Fecha"), fecha);
        root.addRow(3, new Label("Operacion con"), pnlPago);
        root.addRow(3, new Label("Referencia"), txaReferencia);
        root.addRow(4, new Label("Caja de Origen"), cboCaja);
        root.addRow(4, new Label("Valor en Dinero"), txfValor);
        root.add(pnlBotones,1,10);;

        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 10;"
                + "-fx-border-insets: 10;"
                + "-fx-border-radius: 10;"
                + "-fx-border-color: #2E9AFE;");

        Scene scene = new Scene(root, 740, 450);

        primaryStage.setTitle("INTERBANCARIA");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}


