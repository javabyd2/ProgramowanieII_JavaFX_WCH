package com.sdabyd2.javaFX;

import com.sdabyd2.javaFX.controller.Controller;
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

    public Main() {
        personObsevableList.add(new Person("Jan", "Kowalski","86-050","Bydgoszcz","02-12-1990","Karska"));
        personObsevableList.add(new Person("Andrzej", "Petyja","90-784","Warszawa","1967","Spokojna"));
        personObsevableList.add(new Person("Tomasz", "Nikczem","89-453","Lublin","1945","Nowa"));
        personObsevableList.add(new Person("Krystian", "Bokuski","34-675","Gdańska","1996","Hojny"));
        personObsevableList.add(new Person("Paulina", "Nowak","67-456","Poznań","1967","Szybka"));
        personObsevableList.add(new Person("Dorota", "Ciela","45-123","Kraków","1997","Liściasta"));
        personObsevableList.add(new Person("Paweł", "Sydria","98-456","Lublin","1980","Haska"));
        personObsevableList.add(new Person("Kamil", "Linda","90-456","Wrocław","1967","Niebieska"));
        personObsevableList.add(new Person("Bożena", "Anokiewski","34-890","Katowice","1956","Wąska"));
        personObsevableList.add(new Person("Grzegorz", "Kipal","45-678","Sopot","1990","Błękitna"));
    }

    public ObservableList<Person> getPerson() {
        return personObsevableList;
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

        FXMLLoader loader = new FXMLLoader((getClass().getClassLoader()
                .getResource("PersonOverview.fxml")));


        AnchorPane person = loader.load();
        rootLayout.setCenter(person);

        Controller controller = loader.getController();
        controller.setMain(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
