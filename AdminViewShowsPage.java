import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
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

public class AdminViewShowsPage extends Pane {

    public AdminViewShowsPage(Stage stage, String username) {
        super();

        Text atlHeader = new Text("Atlanta Zoo");
        atlHeader.setFill(Color.BLACK);
        atlHeader.setFont(Font.font("Times New Roman", 60));

        Image image = new Image("./Resources/GreyBackground.jpg");
        ImageView background = new ImageView(image);
        background.setFitWidth(800);
        background.setFitHeight(400);

        Button search = new Button("Search");
        Button deleteShow = new Button("Delete Show");
        Button backBtn = new Button("Back");
        backBtn.setOnAction(event -> {
            AdminPage adminPage = new AdminPage(stage, username);
        });
        HBox buttonBox = new HBox(15, search, deleteShow, backBtn);

        Text header = new Text("Shows");
        header.setFill(Color.BLACK);
        header.setFont(Font.font("Times New Roman", 30));

        Text name = new Text("Name");
        name.setFill(Color.BLACK);
        name.setFont(Font.font("Times New Roman", 20));
        TextField nameField = new TextField();
        HBox nameBox = new HBox(15, name, nameField);

        Text exhibit = new Text("Exhibit");
        exhibit.setFill(Color.BLACK);
        exhibit.setFont(Font.font("Times New Roman", 20));
        ObservableList<String> exhibitOptions =
                FXCollections.observableArrayList(
                        "Pacific",
                        "Birds",
                        "Jungle",
                        "Sahara",
                        "Mountainous"
                );
        final ComboBox exhibitComboBox = new ComboBox(exhibitOptions);
        HBox exhibitBox = new HBox(15, exhibit, exhibitComboBox);

        Text date = new Text("Date (MM/DD/YYYY): ");
        date.setFill(Color.BLACK);
        date.setFont(Font.font("Times New Roman", 20));
        TextField dateField = new TextField();
        HBox dateBox = new HBox(15, date, dateField);

        ObservableList<String> showDetails =
                FXCollections.observableArrayList(
                        "Pacific", "800", "80", "Yes"
                );
        TableView<String> showInfo = new TableView<>(showDetails);
        showInfo.setMaxHeight(100);
        showInfo.setMinWidth(720);
        TableColumn showName = new TableColumn("Name");
        showName.setMinWidth(240);
        TableColumn showExhibit = new TableColumn("Exhibit");
        showExhibit.setMinWidth(240);
        TableColumn showDate = new TableColumn("Date");
        showDate.setMinWidth(240);
        showInfo.getColumns().addAll(showName, showExhibit, showDate);

        VBox allFields = new VBox(10, header, nameBox, exhibitBox, dateBox);

        this.getChildren().addAll(background, atlHeader, showInfo, allFields, buttonBox);

        atlHeader.setX(400);
        atlHeader.setY(100);
        allFields.setLayoutX(50);
        allFields.setLayoutY(50);
        buttonBox.setLayoutX(50);
        buttonBox.setLayoutY(200);
        showInfo.setLayoutX(40);
        showInfo.setLayoutY(250);


        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}