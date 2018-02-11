package com.sdabyd2.javaFX;

import com.sdabyd2.javaFX.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Person> personObsevableList = FXCollections.observableArrayList();

    public Main(){
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
        personObsevableList.add(new Person("Jan","Kowalski"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initRootLayout();
        showPersonLayout();
    }

    public void initRootLayout() throws IOException {
        rootLayout = FXMLLoader.load(getClass().getClassLoader()
                .getResource("RootLayout.fxml"));
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showPersonLayout() throws IOException {
        AnchorPane person = FXMLLoader.load(getClass().getClassLoader()
                .getResource("PersonOverview.fxml"));
        rootLayout.setCenter(person);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
