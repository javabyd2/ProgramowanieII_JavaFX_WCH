package com.sdabyd2.javaFX.controller;

import com.sdabyd2.javaFX.Main;
import com.sdabyd2.javaFX.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> firstnameColumn;

    @FXML
    private TableColumn<Person, String> lastnameColumn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private Button closeButton;



    // referencja klasy main
    private Main main;

    public void setMain(Main main) {
        this.main = main;
        personTableView.setItems(main.getPerson());
    }

    public MainController(Main main) {
        this.main = main;
    }

    public MainController() {
    }

    @FXML
    private void initialize() {
        firstnameColumn.setCellValueFactory(
                data -> data.getValue().firstnameProperty());
        lastnameColumn.setCellValueFactory(
                data -> data.getValue().lastnameProperty());
        personTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, x, y) -> showPerson(y));
    }

    public void showPerson(Person person) {
        System.out.println(">> Wybrałeś: " + person.getFirstname() + " " + person.getLastname());
        firstNameLabel.setText(person.getFirstname());
        lastnameLabel.setText(person.getLastname());
        birthdayLabel.setText(person.getBirthday());
        cityLabel.setText(person.getCity());
        postalCodeLabel.setText(person.getPostalcode());
        streetLabel.setText(person.getStreet());
    }

    @FXML
    private void deletePerson() {
        int index = personTableView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            System.out.println(">> Usunołeś: " + main.getPerson().get(index).getFirstname() + " " + main.getPerson().get(index).getLastname());
            personTableView.getItems().remove(index);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Błąd");
            alert.setHeaderText("To jest error");
            alert.setContentText("Nie można usunąć");
            alert.showAndWait();
        }
    }

    public void addPerson(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                (getClass().getClassLoader().getResource("AddPerson.fxml")
        ));

        AnchorPane addPersonLayout = loader.load();
        AddPersonController addPersonController = loader.getController();
        addPersonController.setMain(main);

        Stage stage = new Stage();
        Scene scene = new Scene(addPersonLayout);
        stage.setScene(scene);
        stage.show();


    }


}
