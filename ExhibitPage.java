import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class ExhibitsPage extends Pane {

    public ExhibitsPage(Stage stage) {
        super();

        Text atlHeader = new Text("Atlanta Zoo");
        atlHeader.setFill(Color.BLACK);
        atlHeader.setFont(Font.font("Times New Roman", 60));

        ImageView background = new ImageView("GreyBackgound.jpg");
        background.setFitWidth(800);
        background.setFitHeight(400);

        Button search = new Button("Search");

        Text header = new Text("Exhibits");
        header.setFill(Color.BLACK);
        header.setFont(Font.font("Times New Roman", 50));

        Text name = new Text("Name");
        name.setFill(Color.BLACK);
        name.setFont(Font.font("Times New Roman", 20));
        TextField nameField = new TextField();
        HBox nameBox = new HBox(15, name, nameField);

        Text size = new Text("Size (Min - Max)");
        size.setFont(Font.font("Times New Roman", 20));
        size.setFill(Color.BLACK);
        TextField min = new TextField("0");
        min.setPrefWidth(60);
        TextField max = new TextField("10000");
        max.setPrefWidth(60);
        HBox sizeBox = new HBox(15, size, min, max);

        Text numAnimals = new Text("Number of Animals (Min - Max)");
        numAnimals.setFont(Font.font("Times New Roman", 20));
        numAnimals.setFill(Color.BLACK);
        TextField minAnimals = new TextField("0");
        minAnimals.setPrefWidth(60);
        TextField maxAnimals = new TextField("10000");
        maxAnimals.setPrefWidth(60);
        HBox numAnimalsBox = new HBox(15, numAnimals, minAnimals, maxAnimals);

        Text water = new Text("Water Feature?");
        water.setFill(Color.BLACK);
        water.setFont(Font.font("Times New Roman", 20));
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Yes",
                        "No"
                );
        final ComboBox comboBox = new ComboBox(options);
        HBox waterBox = new HBox(15, water, comboBox);

        ObservableList<String> exhibitDetails =
                FXCollections.observableArrayList(
                        "Pacific", "800", "80", "Yes"
                );
        TableView<String> exhibitInfo = new TableView<>(exhibitDetails);
        exhibitInfo.setMaxHeight(100);
        exhibitInfo.setMinWidth(720);
        TableColumn exhibitName = new TableColumn("Name");
        exhibitName.setMinWidth(300);
        TableColumn exhibitSize = new TableColumn("Size");
        exhibitSize.setMinWidth(100);
        TableColumn exhibitNumAnimals = new TableColumn("Number of Animals");
        TableColumn exhibitWater = new TableColumn("Water Feature");



        exhibitInfo.getColumns().addAll(exhibitName, exhibitSize, exhibitNumAnimals, exhibitWater);

        this.getChildren().addAll(background, nameBox, sizeBox, numAnimalsBox,
                waterBox, search, exhibitInfo, atlHeader);

        search.relocate(300, 200);
        nameBox.setLayoutX(50);
        nameBox.setLayoutY(50);
        sizeBox.setLayoutX(50);
        sizeBox.setLayoutY(100);
        numAnimalsBox.setLayoutX(50);
        numAnimalsBox.setLayoutY(150);
        waterBox.setLayoutX(50);
        waterBox.setLayoutY(200);
        exhibitInfo.setLayoutX(40);
        exhibitInfo.setLayoutY(250);
        atlHeader.setX(420);
        atlHeader.setY(75);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }
}
