package com.sdabyd2.javaFX;

import com.sdabyd2.javaFX.controller.MainController;
import com.sdabyd2.javaFX.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
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
        personObsevableList.add(new Person("Jan", "Kowalski", "86-050", "Bydgoszcz", "02-12-1990", "Karska 6"));
        personObsevableList.add(new Person("Andrzej", "Pomat", "90-784", "Warszawa", "06-12-1967", "Spokojna 12"));
        personObsevableList.add(new Person("Tomasz", "Nikiel", "89-453", "Lublin", "09-12-1945", "Nowa 77"));
        personObsevableList.add(new Person("Krystian", "Bokuski", "34-675", "Gdańska", "12-05-1996", "Monsuna 5"));
        personObsevableList.add(new Person("Paulina", "Nowak", "67-456", "Poznań", "22-06-1967", "Szybka 1"));
        personObsevableList.add(new Person("Dorota", "Krosna", "45-123", "Kraków", "12-02-1997", "Liściasta 9"));
        personObsevableList.add(new Person("Paweł", "Sydria", "98-456", "Lublin", "09-03-1980", "Haska 12"));
        personObsevableList.add(new Person("Kamil", "Linda", "90-456", "Wrocław", "27-09-1967", "Niebieska 4"));
        personObsevableList.add(new Person("Bożena", "Anokiewski", "34-890", "Katowice", "11-11-1956", "Wąska 78"));
        personObsevableList.add(new Person("Grzegorz", "Kipal", "45-678", "Sopot", "09-10-1990", "Błękitna 12"));
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

        MainController controller = loader.getController();
        controller.setMain(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
