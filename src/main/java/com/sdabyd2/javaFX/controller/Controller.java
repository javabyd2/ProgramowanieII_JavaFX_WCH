package com.sdabyd2.javaFX.controller;

import com.sdabyd2.javaFX.Main;
import com.sdabyd2.javaFX.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.text.TabableView;

public class Controller {

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

    // referencja klasy main
    private Main main;

    public void setMain(Main main) {
        this.main = main;
        personTableView.setItems(main.getPerson());
    }

    public Controller(Main main) {
        this.main = main;
    }

    public Controller() {
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
        System.out.println(">> Wybrałeś: "+person.getFirstname()+" "+person.getLastname());
        firstNameLabel.setText(person.getFirstname());
        lastnameLabel.setText(person.getLastname());
        birthdayLabel.setText(person.getBirthday());
        cityLabel.setText(person.getCity());
        postalCodeLabel.setText(person.getPostalcode());
        streetLabel.setText(person.getStreet());

    }
}
