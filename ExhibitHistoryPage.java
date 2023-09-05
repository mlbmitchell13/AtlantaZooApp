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

public class ExhibitHistoryPage extends Pane {

    public ExhibitHistoryPage(Stage stage, String username) {
        super();

        Text atlHeader = new Text("Atlanta Zoo");
        atlHeader.setFill(Color.BLACK);
        atlHeader.setFont(Font.font("Times New Roman", 60));

        Image image = new Image("./Resources/GreyBackground.jpg");
        ImageView background = new ImageView(image);
        background.setFitWidth(800);
        background.setFitHeight(400);

        Button search = new Button("Search");
        HBox buttonBox = new HBox(15, search);

        Text header = new Text("Exhibit History");
        header.setFill(Color.BLACK);
        header.setFont(Font.font("Times New Roman", 30));

        Text name = new Text("Name");
        name.setFill(Color.BLACK);
        name.setFont(Font.font("Times New Roman", 20));
        TextField nameField = new TextField();
        HBox nameBox = new HBox(15, name, nameField);

        Text numVisits = new Text("Number of Visits: (Min - Max): ");
        numVisits.setFill(Color.BLACK);
        numVisits.setFont(Font.font("Times New Roman", 20));
        TextField min = new TextField("0");
        min.setPrefWidth(60);
        TextField max = new TextField("10000");
        max.setPrefWidth(60);
        HBox numVisitsBox = new HBox(10, numVisits, min, max);

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
        TableColumn exhibitName = new TableColumn("Name");
        exhibitName.setMinWidth(240);
        TableColumn exhibitDate = new TableColumn("Date");
        exhibitDate.setMinWidth(240);
        TableColumn exhibitNumVisits = new TableColumn("Number of Visits");
        exhibitNumVisits.setMinWidth(240);
        showInfo.getColumns().addAll(exhibitName, exhibitDate, exhibitNumVisits);

        VBox allFields = new VBox(10, header, nameBox, numVisitsBox, dateBox);

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