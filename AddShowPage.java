import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;

public class AddShowPage extends Pane {
    private int count = 0;

    public AddShowPage(Stage stage, String username) {
        super();

        Image image = new Image("./Resources/GreyBackground.jpg");
        ImageView background = new ImageView(image);
        background.setFitWidth(800);
        background.setFitHeight(400);

        Text header = new Text("Add Show");
        header.setFont(Font.font("Times New Roman", 50));

        Button addAnimalBtn = new Button("Add Show");
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

        Text staff = new Text("Staff:");
        staff.setFont(Font.font("Times New Roman", 30));
        ObservableList<String> staffOptions =
                FXCollections.observableArrayList(
                        "Mitchell",
                        "Blake",
                        "Minji",
                        "Will",
                        "Binta"
                );
        ComboBox<String> staffComboBox = new ComboBox<String>(staffOptions);
        HBox typeBox = new HBox(10, staff, staffComboBox);

        Text date = new Text("Date (MM/DD/YYYY):");
        date.setFont(Font.font("Times New Roman", 30));
        TextField dateField = new TextField("example: 01/23/2018");
        dateField.setOnMouseClicked(event -> {
            if (count < 1) {
                dateField.setText("");
                count++;
            }
        });
        HBox speciesBox = new HBox(10, date, dateField);

        Text time = new Text("Time:");
        time.setFont(Font.font("Times New Roman", 30));
        TextField timeField = new TextField();
        HBox ageBox = new HBox(10, time, timeField);

        VBox root = new VBox(10, header, nameBox, exhibitBox, typeBox,
                speciesBox, ageBox);

        this.getChildren().addAll(background, root, addAnimalBtn, backBtn);

        root.setLayoutX(50);
        root.setLayoutY(50);
        addAnimalBtn.relocate(400, 160);
        backBtn.relocate(525, 160);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
