package org.example;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;


public class ProdajaController {
    @FXML
    private TextField txtIme;
    @FXML
    private void obrisiPromptTekstIme(ActionEvent e) { txtIme.setText("");}
    @FXML
    private TextField txtPrezime;
    @FXML
    private void obrisiPromptTekstPrezime(ActionEvent e) {
        txtPrezime.setText("");
    }
    @FXML
    private TextField txtAdresa;
    @FXML
    private void obrisiPromptTekstAdresa(ActionEvent e) {
        txtAdresa.setText("");
    }
    @FXML
    private HBox hboxBrzina;
    @FXML
    private HBox hboxProtok;
    @FXML
    private HBox hboxTrajanjeUgovora;
    @FXML
    private TableView<InternetPaket> tableProdaja;
    private ObservableList<InternetPaket> prodaje = FXCollections.observableArrayList();

    private int selectedSpeed;
    private String selectedBandwidth;
    private int selectedDuration;


    @FXML
    private void selectSpeed(ActionEvent event) {
        Button clickedButtonS = (Button) event.getSource();
        selectedSpeed = Integer.parseInt(clickedButtonS.getText());
    }

    @FXML
    private void selectBandwidth(ActionEvent event) {
        Button clickedButtonB = (Button) event.getSource();
        String buttonText = clickedButtonB.getText();
        selectedBandwidth = buttonText.equals("Flat") ? "Flat" : Integer.toString(Integer.parseInt(buttonText));
    }

    @FXML
    private void selectDuration(ActionEvent event) {
        Button clickedButtonD = (Button) event.getSource();
        selectedDuration = Integer.parseInt(clickedButtonD.getText().split(" ")[0]);
    }

    public void initialize() {

        TableColumn<InternetPaket, String> imeColumn = new TableColumn<>("Ime");
        imeColumn.setCellValueFactory(new PropertyValueFactory<>("imeKorisnika"));
        imeColumn.setPrefWidth(140);

        TableColumn<InternetPaket, String> prezimeColumn = new TableColumn<>("Prezime");
        prezimeColumn.setCellValueFactory(new PropertyValueFactory<>("prezimeKorisnika"));
        prezimeColumn.setPrefWidth(140);

        TableColumn<InternetPaket, String> adresaColumn = new TableColumn<>("Adresa");
        adresaColumn.setCellValueFactory(new PropertyValueFactory<>("adresaKorisnika"));
        adresaColumn.setPrefWidth(140);

        TableColumn<InternetPaket, Integer> brzinaColumn = new TableColumn<>("Brzina (Mbit/s)");
        brzinaColumn.setCellValueFactory(new PropertyValueFactory<>("brzina"));
        brzinaColumn.setPrefWidth(140);

        TableColumn<InternetPaket, Integer> protokColumn = new TableColumn<>("Protok");
        protokColumn.setCellValueFactory(new PropertyValueFactory<>("protok"));
        protokColumn.setPrefWidth(140);

        TableColumn<InternetPaket, Integer> trajanjeColumn = new TableColumn<>("Trajanje ugovora (godine)");
        trajanjeColumn.setCellValueFactory(new PropertyValueFactory<>("trajanjeUgovora"));
        trajanjeColumn.setPrefWidth(140);

        tableProdaja.getColumns().addAll(imeColumn, prezimeColumn, adresaColumn, brzinaColumn, protokColumn, trajanjeColumn);
        tableProdaja.setItems(prodaje);
        tableProdaja.setPrefWidth(1000);

        Platform.runLater(() -> {
            tableProdaja.requestFocus();
        });
    }

    @FXML
    private void dodajProdaju() {
        if (validacijaUnosa()) {
            int selectedSpeed = this.selectedSpeed;
            String selectedBandwidth = this.selectedBandwidth;
            int selectedDuration = this.selectedDuration;
            InternetPaket prodaja = new InternetPaket(txtIme.getText(), txtPrezime.getText(), txtAdresa.getText(), selectedSpeed,
                    selectedBandwidth, selectedDuration);
            prodaje.add(prodaja);
            ocistiPolja();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Molimo unesite sve podatke.");
            alert.showAndWait();
        }
    }

    @FXML
    private void obrisiProdaju() {
        int index = tableProdaja.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            prodaje.remove(index);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije odabrana prodaja za brisanje.");
            alert.showAndWait();
        }
    }

    private boolean validacijaUnosa() {
        return  !txtIme.getText().isEmpty() &&
                !txtPrezime.getText().isEmpty() &&
                !txtAdresa.getText().isEmpty() &&
                selectedSpeed != 0 &&
                !selectedBandwidth.isEmpty() &&
                selectedDuration != 0;
    }

    @FXML
    private void ocistiPolja() {
        txtIme.clear();
        txtPrezime.clear();
        txtAdresa.clear();
    }

}
