import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class StaffAnimalSearchPage extends Pane {

    public StaffAnimalSearchPage(Stage stage, String username) {
        super();

        Text atlHeader = new Text("Atlanta Zoo");
        atlHeader.setFill(Color.BLACK);
        atlHeader.setFont(Font.font("Times New Roman", 60));

        Image image = new Image("./Resources/GreyBackground.jpg");
        ImageView background = new ImageView(image);
        background.setFitWidth(800);
        background.setFitHeight(400);

        Button search = new Button("Search");
        Button backBtn = new Button("Back");
        backBtn.setOnAction(event -> {
            StaffPage staffPage = new StaffPage(stage, username);
        });

        Text header = new Text("Animals");
        header.setFill(Color.BLACK);
        header.setFont(Font.font("Times New Roman", 30));

        Text name = new Text("Name");
        name.setFill(Color.BLACK);
        name.setFont(Font.font("Times New Roman", 20));
        TextField nameField = new TextField();
        HBox nameBox = new HBox(15, name, nameField);

        Text species = new Text("Species");
        species.setFill(Color.BLACK);
        species.setFont(Font.font("Times New Roman", 20));
        TextField speciesField = new TextField();
        HBox speciesBox = new HBox(15, species, speciesField);

        Text age = new Text("Age (Min - Max)");
        age.setFont(Font.font("Times New Roman", 20));
        age.setFill(Color.BLACK);
        TextField min = new TextField("0");
        min.setPrefWidth(60);
        TextField max = new TextField("500");
        max.setPrefWidth(60);
        HBox ageBox = new HBox(15, age, min, max);

        Text exhibit = new Text("Exhibit");
        exhibit.setFill(Color.BLACK);
        exhibit.setFont(Font.font("Times New Roman", 20));
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Pacific",
                        "Birds",
                        "Jungle",
                        "Sahara",
                        "Mountainous"
                );
        final ComboBox comboBox = new ComboBox(options);
        HBox exhibitBox = new HBox(15, exhibit, comboBox);

        Text type = new Text("Type");
        type.setFill(Color.BLACK);
        type.setFont(Font.font("Times New Roman", 20));
        ObservableList<String> typeOptions =
                FXCollections.observableArrayList(
                        "Fish",
                        "Amphibian",
                        "Mammal",
                        "Bird"
                );
        final ComboBox typeComboBox = new ComboBox(typeOptions);
        HBox typeBox = new HBox(15, type, typeComboBox);

        ObservableList<String> animalDetails =
                FXCollections.observableArrayList(
                        "Pacific", "800", "80", "Yes"
                );
        TableView<String> animalInfo = new TableView<>(animalDetails);
        animalInfo.setMaxHeight(100);
        animalInfo.setMinWidth(720);
        TableColumn animalName = new TableColumn("Name");
        animalName.setMinWidth(300);
        TableColumn animalSpecies = new TableColumn("Species");
        animalSpecies.setMinWidth(100);
        TableColumn animalsExhibit = new TableColumn("Exhibit");
        animalsExhibit.setMinWidth(150);
        TableColumn animalAge = new TableColumn("Age");
        TableColumn animalType = new TableColumn("Type");
        animalType.setMinWidth(100);



        animalInfo.getColumns().addAll(animalName, animalSpecies,
                animalsExhibit, animalAge, animalType);

        this.getChildren().addAll(background, nameBox, speciesBox, ageBox,
                exhibitBox, search, animalInfo, atlHeader, typeBox, header, backBtn);

        search.relocate(300, 210);
        nameBox.setLayoutX(50);
        nameBox.setLayoutY(65);
        speciesBox.setLayoutX(50);
        speciesBox.setLayoutY(100);
        exhibitBox.setLayoutX(50);
        exhibitBox.setLayoutY(140);
        ageBox.setLayoutX(50);
        ageBox.setLayoutY(175);
        typeBox.setLayoutX(50);
        typeBox.setLayoutY(210);
        animalInfo.setLayoutX(40);
        animalInfo.setLayoutY(270);
        atlHeader.setX(420);
        atlHeader.setY(125);
        header.setX(50);
        header.setY(40);
        backBtn.relocate(380, 210);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }
}

