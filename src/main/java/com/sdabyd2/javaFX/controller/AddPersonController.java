package com.sdabyd2.javaFX.controller;


import com.sdabyd2.javaFX.Main;
import com.sdabyd2.javaFX.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


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

    private Main main;

    public void setMain(Main main){
        this.main = main;
    }

    @FXML
    private void addPerson(){
        main.getPerson().add(new Person(firstname.getText(),lastname.getText(),postalcode.getText(),
                city.getText(),birthday.getText(),street.getText()));

        System.out.println(firstname.getText());
        System.out.println(lastname.getText());
        System.out.println(postalcode.getText());
        System.out.println(street.getText());
        System.out.println(city.getText());
        System.out.println(birthday.getText());
    }

    @FXML
    private void cancel() {

    }
}
