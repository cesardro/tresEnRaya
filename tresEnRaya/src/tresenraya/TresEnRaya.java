package tresenraya;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TresEnRaya extends Application {

    private GraphicsContext graphicsContext2D;
    private int turno = 1;
    private int[] lista = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int cont1 = 1;
    private int cont2 = 1;
    private Label partX;
    private Label partY;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        partX = new Label("Partidas jugador 1: 0");
        partY = new Label("Partidas jugador 2: 0");

        partX.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        partY.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        HBox estado = new HBox(partX, partY);
        estado.setSpacing(10);
        estado.setAlignment(Pos.CENTER);

        Canvas canvas = new Canvas();
        canvas.setHeight(602);
        canvas.setWidth(602);

        graphicsContext2D = canvas.getGraphicsContext2D();

        inciarPartida();

        canvas.setOnMouseClicked(event -> {
            if (turno == 1) {
                jugador1(event);
            }
            if (turno == 2) {
                jugador2(event);
            }
            quienGana(partX, partY);
        });

        VBox vbox = new VBox(estado, canvas);

        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.setTitle("Tres en Raya");
        stage.show();
    }

    private void jugador1(MouseEvent event) {

        if ((event.getX() < 201 && event.getY() < 201)) {
            if (lista[0] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(20, 180, 180, 20);
                graphicsContext2D.strokeLine(20, 20, 180, 180);
                lista[0] = 1;
                turno = 2;
            }
        } else if ((event.getX() < 402) && (event.getY() < 201)) {
            if (lista[1] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(221, 20, 382, 180);
                graphicsContext2D.strokeLine(382, 20, 221, 180);
                lista[1] = 1;
                turno = 2;
            }
        } else if ((event.getX() < 602) && (event.getY() < 201)) {
            if (lista[2] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(421, 20, 582, 180);
                graphicsContext2D.strokeLine(582, 20, 421, 180);
                lista[2] = 1;
                turno = 2;
            }
        } else if ((event.getX() < 201) && (event.getY() < 402)) {
            if (lista[3] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(20, 221, 180, 382);
                graphicsContext2D.strokeLine(180, 221, 20, 382);
                lista[3] = 1;
                turno = 2;
            }
        } else if ((event.getX() < 402) && (event.getY()) < 402) {
            if (lista[4] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(221, 221, 382, 382);
                graphicsContext2D.strokeLine(382, 221, 221, 382);
                lista[4] = 1;
                turno = 2;
            }
        } else if ((event.getX() < 602) && (event.getY() < 402)) {
            if (lista[5] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(421, 221, 582, 382);
                graphicsContext2D.strokeLine(582, 221, 421, 382);
                lista[5] = 1;
                turno = 2;
            }
        } else if ((event.getX() < 201) && (event.getY() < 602)) {
            if (lista[6] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(20, 421, 180, 582);
                graphicsContext2D.strokeLine(180, 421, 20, 582);
                lista[6] = 1;
                turno = 2;
            }
        } else if ((event.getX() < 402) && (event.getY() < 602)) {
            if (lista[7] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(221, 421, 382, 582);
                graphicsContext2D.strokeLine(382, 421, 221, 582);
                lista[7] = 1;
                turno = 2;
            }
        } else if ((event.getX() < 602) && (event.getY() < 602)) {
            if (lista[8] == 0) {
                graphicsContext2D.setStroke(Color.RED);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeLine(421, 421, 582, 582);
                graphicsContext2D.strokeLine(582, 421, 421, 582);
                lista[8] = 1;
                turno = 2;
            }
        }
    }

    private void jugador2(MouseEvent event) {

        if ((event.getX() < 201 && event.getY() < 201)) {
            if (lista[0] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(10, 10, 180, 180);
                lista[0] = 2;
                turno = 1;
            }
        } else if ((event.getX() < 402) && (event.getY() < 201)) {
            if (lista[1] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(211, 10, 180, 180);
                lista[1] = 2;
                turno = 1;
            }
        } else if ((event.getX() < 602) && (event.getY() < 201)) {
            if (lista[2] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(411, 10, 180, 180);
                lista[2] = 2;
                turno = 1;
            }
        } else if ((event.getX() < 201) && (event.getY() < 402)) {
            if (lista[3] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(10, 211, 180, 180);
                lista[3] = 2;
                turno = 1;
            }
        } else if ((event.getX() < 402) && (event.getY()) < 402) {
            if (lista[4] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(211, 211, 180, 180);
                lista[4] = 2;
                turno = 1;
            }
        } else if ((event.getX() < 602) && (event.getY() < 402)) {
            if (lista[5] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(411, 211, 180, 180);
                lista[5] = 2;
                turno = 1;
            }
        } else if ((event.getX() < 201) && (event.getY() < 602)) {
            if (lista[6] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(10, 411, 180, 180);
                lista[6] = 2;
                turno = 1;
            }
        } else if ((event.getX() < 402) && (event.getY() < 602)) {
            if (lista[7] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(211, 411, 180, 180);
                lista[7] = 2;
                turno = 1;
            }
        } else if ((event.getX() < 602) && (event.getY() < 602)) {
            if (lista[8] == 0) {
                graphicsContext2D.setStroke(Color.BLUE);
                graphicsContext2D.setLineWidth(10);
                graphicsContext2D.strokeOval(411, 411, 180, 180);
                lista[8] = 2;
                turno = 1;
            }
        }
    }

    private void quienGana(Label partX, Label partY) {
        if ((lista[0] == lista[1]) && (lista[1] == lista[2])) {
            if (lista[0] == 1 && lista[1] == 1 && lista[2] == 1) {
                System.out.println("Gana jugador 1");
                partX.setText("Partidas jugador 1: " + cont1);
                cont1++;
                reiniciarPartida(partX);
                inciarPartida();
            }
            if (lista[0] == 2 && lista[1] == 2 && lista[2] == 2) {
                System.out.println("Gana jugador 2");
                partY.setText("Partidas jugador 2: " + cont2);
                cont2++; 
                reiniciarPartida(partY);
                inciarPartida();
            }
        }
        if ((lista[3] == lista[4]) && (lista[4] == lista[5])) {
            if (lista[3] == 1 && lista[4] == 1 && lista[5] == 1) {
                System.out.println("Gana jugador 1");
                partX.setText("Partidas jugador 1: " + cont1);
                cont1++;
                reiniciarPartida(partX);
                inciarPartida();
            }
            if (lista[3] == 2 && lista[4] == 2 && lista[5] == 2) {
                System.out.println("Gana jugador 2");
                partY.setText("Partidas jugador 2: " + cont2);
                cont2++;
                reiniciarPartida(partY);
                inciarPartida();
            }
        }
        if ((lista[6] == lista[7]) && (lista[7] == lista[8])) {
            if (lista[6] == 1 && lista[7] == 1 && lista[8] == 1) {
                System.out.println("Gana jugador 1");
                partX.setText("Partidas jugador 1: " + cont1);
                cont1++;
                reiniciarPartida(partX);
                inciarPartida();
            }
            if (lista[6] == 2 && lista[7] == 2 && lista[8] == 2) {
                System.out.println("Gana jugador 2");
                partY.setText("Partidas jugador 2: " + cont2);
                cont2++;
                reiniciarPartida(partY);
                inciarPartida();
            }
        }
        if ((lista[0] == lista[3]) && (lista[3] == lista[6])) {
            if (lista[0] == 1 && lista[3] == 1 && lista[6] == 1) {
                System.out.println("Gana jugador 1");
                partX.setText("Partidas jugador 1: " + cont1);
                cont1++;
                reiniciarPartida(partX);
                inciarPartida();
            }
            if (lista[0] == 2 && lista[3] == 2 && lista[6] == 2) {
                System.out.println("Gana jugador 2");
                partY.setText("Partidas jugador 2: " + cont2);
                cont2++;
                reiniciarPartida(partY);
                inciarPartida();
            }
        }
        if ((lista[1] == lista[4]) && (lista[4] == lista[7])) {
            if (lista[1] == 1 && lista[4] == 1 && lista[7] == 1) {
                System.out.println("Gana jugador 1");
                partX.setText("Partidas jugador 1: " + cont1);
                cont1++;
                reiniciarPartida(partX);
                inciarPartida();
            }
            if (lista[1] == 2 && lista[4] == 2 && lista[7] == 2) {
                System.out.println("Gana jugador 2");
                partY.setText("Partidas jugador 2: " + cont2);
                cont2++;
                reiniciarPartida(partY);
                inciarPartida();
            }
        }
        if ((lista[2] == lista[5]) && (lista[5] == lista[8])) {
            if (lista[2] == 1 && lista[5] == 1 && lista[8] == 1) {
                System.out.println("Gana jugador 1");
                partX.setText("Partidas jugador 1: " + cont1);
                cont1++;
                reiniciarPartida(partX);
                inciarPartida();
            }
            if (lista[2] == 2 && lista[5] == 2 && lista[8] == 2) {
                System.out.println("Gana jugador 2");
                partY.setText("Partidas jugador 2: " + cont2);
                cont2++;
                reiniciarPartida(partY);
                inciarPartida();
            }
        }
        if ((lista[0] == lista[4]) && (lista[4] == lista[8])) {
            if (lista[0] == 1 && lista[4] == 1 && lista[8] == 1) {
                System.out.println("Gana jugador 1");
                partX.setText("Partidas jugador 1: " + cont1);
                cont1++;
                reiniciarPartida(partX);
                inciarPartida();
            }
            if (lista[0] == 2 && lista[4] == 2 && lista[8] == 2) {
                System.out.println("Gana jugador 2");
                partY.setText("Partidas jugador 2: " + cont2);
                cont2++;
                reiniciarPartida(partY);
                inciarPartida();
            }
        }
        if ((lista[2] == lista[4]) && (lista[4] == lista[6])) {
            if (lista[2] == 1 && lista[4] == 1 && lista[6] == 1) {
                System.out.println("Gana jugador 1");
                partX.setText("Partidas jugador 1: " + cont1);
                cont1++;
                reiniciarPartida(partX);
                inciarPartida();
            }
            if (lista[2] == 2 && lista[4] == 2 && lista[6] == 2) {
                System.out.println("Gana jugador 2");
                partY.setText("Partidas jugador 2: " + cont2);
                cont2++;
                reiniciarPartida(partY);
                inciarPartida();
            }
        }
        if (lista[0] > 0 && lista[1] > 0 && lista[2] > 0 && lista[3] > 0 && lista[4] > 0 && lista[5] > 0 && lista[6] > 0 && lista[7] > 0 && lista[8] > 0) {
            nadieGana();
            inciarPartida();
        }
    }

    private void inciarPartida() {

        graphicsContext2D.setStroke(Color.BLACK);
        graphicsContext2D.setLineWidth(1);
        graphicsContext2D.setFill(Color.WHITE);
        graphicsContext2D.fillRect(0, 0, 602, 602);
        graphicsContext2D.beginPath();
        graphicsContext2D.moveTo(201, 0);
        graphicsContext2D.lineTo(201, 602);
        graphicsContext2D.moveTo(402, 0);
        graphicsContext2D.lineTo(402, 602);
        graphicsContext2D.moveTo(0, 201);
        graphicsContext2D.lineTo(602, 201);
        graphicsContext2D.moveTo(0, 402);
        graphicsContext2D.lineTo(602, 402);
        graphicsContext2D.stroke();
        graphicsContext2D.closePath();

        cargarInformacion();
    }

    private void reiniciarPartida(Label ganador) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setHeaderText(ganador.getText());
        alerta.setTitle("Ganador");
        ButtonType btnAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.YES);

        alerta.getButtonTypes().setAll(btnAceptar);
        Optional<ButtonType> action = alerta.showAndWait();
        if (action.get() == btnAceptar) {
            for (int i = 0; i < lista.length; i++) {
                lista[i] = 0;
            }
            alerta.close();
        }
       guardarInformacion();
    }

    private void nadieGana() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setHeaderText("Nadie gana");
        alerta.setTitle("Empate");
        ButtonType btnAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.YES);

        alerta.getButtonTypes().setAll(btnAceptar);
        Optional<ButtonType> action = alerta.showAndWait();
        if (action.get() == btnAceptar) {
            for (int i = 0; i < lista.length; i++) {
                lista[i] = 0;
            }
            alerta.close();
        }
    }

    private void guardarInformacion() {
         try {
            BufferedWriter fWrite = new BufferedWriter(new FileWriter("C:\\Users\\zx21student278\\Desktop\\Datos\\tresEnRaya.txt"));
            fWrite.write("1:"+cont1+"\n");
            fWrite.write("2:"+cont2);
            fWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(TresEnRaya.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarInformacion() {
        System.out.println("entro");
        try {
            BufferedReader fRead = new BufferedReader(new FileReader("C:\\Users\\zx21student278\\Desktop\\Datos\\tresEnRaya.txt"));
            String linea = fRead.readLine();
            while (linea != null) {
                if (linea != null) {
                    String[] trozos = linea.split(":");
                    if("1".equals(trozos[0])){
                        cont1 = Integer.parseInt(trozos[1]);
                    }
                    if("2".equals(trozos[0])){
                        cont2 = Integer.parseInt(trozos[1]);
                    }
                }

                linea = fRead.readLine();
            }
            partX.setText("Partidas jugador 1: "+cont1);
            partY.setText("Partidas jugador 2: "+cont2);
            fRead.close();
        } catch (IOException ex) {
            Logger.getLogger(TresEnRaya.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
