import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;

public class AddAnimalPage extends Pane {

    public AddAnimalPage(Stage stage, String username) {
        super();

        Image image = new Image("./Resources/GreyBackground.jpg");
        ImageView background = new ImageView(image);
        background.setFitWidth(800);
        background.setFitHeight(400);

        Text header = new Text("Add Animal");
        header.setFont(Font.font("Times New Roman", 50));

        Button addAnimalBtn = new Button("Add Animal");
        Button backBtn = new Button("Back");
        backBtn.setOnAction(event -> {
            AdminPage adminPage = new AdminPage(stage, username);
        });

        Text name = new Text("Name:");
        name.setFont(Font.font("Times New Roman", 30));
        TextField nameField = new TextField();
        HBox nameBox = new HBox(10, name, nameField);

        Text exhibit = new Text("Exhibit:");
        exhibit.setFont(Font.font("Times New Roman", 30));
        ObservableList<String> exhibitOptions =
                FXCollections.observableArrayList(
                        "Pacific",
                        "Birds",
                        "Jungle",
                        "Sahara",
                        "Mountainous"
                );
        ComboBox<String> exhibitComboBox = new ComboBox<String>(exhibitOptions);
        HBox exhibitBox = new HBox(10, exhibit, exhibitComboBox);

        Text type = new Text("Type:");
        type.setFont(Font.font("Times New Roman", 30));
        ObservableList<String> typeOptions =
                FXCollections.observableArrayList(
                        "Fish",
                        "Amphibian",
                        "Bird",
                        "Mammal",
                        "Reptile"
                );
        ComboBox<String> typeComboBox = new ComboBox<String>(typeOptions);
        HBox typeBox = new HBox(10, type, typeComboBox);

        Text species = new Text("Species:");
        species.setFont(Font.font("Times New Roman", 30));
        TextField speciesField = new TextField();
        HBox speciesBox = new HBox(10, species, speciesField);

        Text age = new Text("Age:");
        age.setFont(Font.font("Times New Roman", 30));
        TextField ageField = new TextField();
        HBox ageBox = new HBox(10, age, ageField);

        VBox root = new VBox(10, header, nameBox, exhibitBox, typeBox,
                speciesBox, ageBox);

        this.getChildren().addAll(background, root, addAnimalBtn, backBtn);

        root.setLayoutX(50);
        root.setLayoutY(50);
        addAnimalBtn.relocate(400, 200);
        backBtn.relocate(525, 200);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
