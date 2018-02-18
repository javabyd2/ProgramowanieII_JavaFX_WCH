package com.sdabyd2.javaFX.controller;


import com.sdabyd2.javaFX.Main;
import com.sdabyd2.javaFX.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddPersonController {

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField postalcode;

    @FXML
    private TextField street;

    @FXML
    private TextField city;

    @FXML
    private TextField birthday;

    @FXML
    private Button cancelAddPerson;

    private Main main;


    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void addPerson() {
        main.getPerson().add(new Person(firstname.getText(), lastname.getText(), postalcode.getText(),
                city.getText(), birthday.getText(), street.getText()));

        System.out.println(">> Dodałeś: " + firstname.getText());
        System.out.println(">> Dodałeś: " + lastname.getText());
        System.out.println(">> Dodałeś: " + postalcode.getText());
        System.out.println(">> Dodałeś: " + street.getText());
        System.out.println(">> Dodałeś: " + city.getText());
        System.out.println(">> Dodałeś: " + birthday.getText());
    }

    @FXML
    private void cancel() {
        Stage stage = (Stage) cancelAddPerson.getScene().getWindow();
        stage.close();
    }


}
