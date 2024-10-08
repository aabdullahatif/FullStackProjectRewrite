import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- Menu Bar ---
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu themeMenu = new Menu("Theme");
        Menu helpMenu = new Menu("Help");
        menuBar.getMenus().addAll(fileMenu, editMenu, themeMenu, helpMenu);

        // --- Left Side ---
        ImageView imageView = new ImageView(new Image("person_icon.png")); // Replace with your image path
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        TableView<MyData> tableView = new TableView<>();
        TableColumn<MyData, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<MyData, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        // ... (add other columns: LastName, Department, Major, Email)
        tableView.getColumns().addAll(idColumn, firstNameColumn, /* ... other columns */);

        ObservableList<MyData> data = FXCollections.observableArrayList(
                // ... add sample data
        );
        tableView.setItems(data);

        VBox leftVBox = new VBox(10, imageView, tableView); // Spacing between image and table
        leftVBox.setPadding(new Insets(10));
        leftVBox.setAlignment(Pos.TOP_CENTER);

        // --- Right Side ---
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(5);
        formGrid.setPadding(new Insets(10));

        // Add labels and text fields to the GridPane
        // Example:
        formGrid.add(new Label("Last Name:"), 0, 0);
        formGrid.add(new TextField(), 1, 0);
        // ... (add other form fields)

        Button clearButton = new Button("Clear");
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button editButton = new Button("Edit");

        VBox buttonVBox = new VBox(10, clearButton, addButton, deleteButton, editButton);
        buttonVBox.setAlignment(Pos.CENTER);
        buttonVBox.setPadding(new Insets(10));

        VBox rightVBox = new VBox(10, formGrid, buttonVBox); // Spacing between form and buttons

        // --- Main Layout ---
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setLeft(leftVBox);
        root.setCenter(rightVBox);

        Scene scene = new Scene(root, 800, 600); // Adjust size as needed
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("FSC CSC 325 - Full Stack Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // --- Data Class (Replace with your actual data model) ---
    public static class MyData {
        private int id;
        private String firstName;
        // ... other properties

        // Constructor, getters, and setters
        // ...
    }

    public static void main(String[] args) {
        launch(args);
    }
}