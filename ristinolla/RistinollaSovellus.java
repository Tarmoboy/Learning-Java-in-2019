package ristinolla;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Tarmoboy
 */

public class RistinollaSovellus extends Application {
    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
        System.out.println("Hello world!");
    }
    @Override
    public void start(Stage stage) throws Exception {
        Ristinolla ristinolla = new Ristinolla();
        Font tasaleveys = Font.font("Monospaced", 40);
        Label pelitilanne = new Label("Vuoro: " + ristinolla.vuoro());
        pelitilanne.setFont(tasaleveys);
        BorderPane asettelu = new BorderPane();
        asettelu.setTop(pelitilanne);
        GridPane ruudukko = new GridPane();
        ruudukko.setHgap(10);
        ruudukko.setVgap(10);
        ruudukko.setPadding(new Insets(10, 10, 10, 10));
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button nappi = new Button(ristinolla.status(x, y));
                nappi.setFont(tasaleveys);
                ruudukko.add(nappi, x, y);
                int rx = x;
                int ry = y;
                nappi.setOnAction((event) -> {
                    ristinolla.aseta(rx, ry);
                    nappi.setText(ristinolla.status(rx, ry));
                    pelitilanne.setText("Vuoro: " + ristinolla.vuoro());
                    if (ristinolla.loppu()) {
                        pelitilanne.setText("Loppu!");
                    }
                });
            }
        }
        asettelu.setCenter(ruudukko);
        Scene nakyma = new Scene(asettelu);
        stage.setScene(nakyma);
        stage.show();
    }
}
