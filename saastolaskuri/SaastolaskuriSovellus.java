package sovellus;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Tarmoboy
 */

public class SaastolaskuriSovellus extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SaastolaskuriSovellus.class);
    }

    @Override
    public void start(Stage ikkuna) throws Exception {
        BorderPane komponentit = new BorderPane();
        NumberAxis xAkseli = new NumberAxis(0, 30, 1);
        NumberAxis yAkseli = new NumberAxis();
        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setAnimated(false);
        viivakaavio.setLegendVisible(false);
        viivakaavio.setTitle("Säästölaskuri");
        VBox sliderit = new VBox();
        sliderit.setSpacing(20);
        BorderPane kuukausittainen = new BorderPane();
        Slider tallennus = new Slider(25, 250, 25);
        tallennus.setSnapToTicks(true);
        tallennus.setBlockIncrement(500);
        tallennus.setShowTickLabels(true);
        tallennus.setShowTickMarks(true);
        Label tallennusTeksti = new Label("25");
        kuukausittainen.setLeft(new Label("Kuukausittainen tallennus"));
        kuukausittainen.setCenter(tallennus);
        kuukausittainen.setRight(tallennusTeksti);
        BorderPane vuosittainen = new BorderPane();
        Slider korko = new Slider(0, 10, 0);
        korko.setMinorTickCount(10);
        korko.setShowTickLabels(true);
        korko.setShowTickMarks(true);
        Label korkoTeksti = new Label("0");
        vuosittainen.setLeft(new Label("Vuosittainen korko"));
        vuosittainen.setCenter(korko);
        vuosittainen.setRight(korkoTeksti);
        XYChart.Series saastot = new XYChart.Series();
        XYChart.Series saastotKoroilla = new XYChart.Series();
        viivakaavio.getData().add(saastot);
        viivakaavio.getData().add(saastotKoroilla);
        tallennus.setOnMouseReleased(e -> {
            tallennusTeksti.setText("" + tallennus.getValue());
            paivitaKaavio(tallennus.getValue(), korko.getValue(), saastot, saastotKoroilla);
        });

        korko.setOnMouseReleased(e -> {

            String korkoString = "" + korko.getValue();
            if (korkoString.length() > 4) {
                korkoString = korkoString.substring(0, 4);
            }
            korkoTeksti.setText(korkoString);
            paivitaKaavio(tallennus.getValue(), korko.getValue(), saastot, saastotKoroilla);
        });
        sliderit.getChildren().addAll(kuukausittainen, vuosittainen);
        komponentit.setTop(sliderit);
        komponentit.setCenter(viivakaavio);
        Scene nakyma = new Scene(komponentit);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    private void paivitaKaavio(double kuukausiSaasto, double korko, XYChart.Series saastot, XYChart.Series saastotKoroilla) {
        saastot.getData().clear();
        saastotKoroilla.getData().clear();
        saastot.getData().add(new XYChart.Data(0, 0));
        saastotKoroilla.getData().add(new XYChart.Data(0, 0));
        double edellinen = 0;
        for (int i = 1; i <= 30; i++) {
            saastot.getData().add(new XYChart.Data(i, i * kuukausiSaasto * 12));
            edellinen += kuukausiSaasto * 12;
            edellinen *= (1 + korko / 100.0);
            saastotKoroilla.getData().add(new XYChart.Data(i, edellinen));
        }
    }
}
