import javafx.scene.control.*;
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

public class ExhibitDetail extends Pane {

    public ExhibitDetail(Stage stage) {
        super();

        String nameString = "Pacific"; //This input should come from database or
                                       //where user clicks exhibit to view
        String sizeString = "800";
        String numAnimalsString = "30";
        String waterString = "Yes";

        Text atlHeader = new Text("Atlanta Zoo");
        atlHeader.setFill(Color.BLACK);
        atlHeader.setFont(Font.font("Times New Roman", 60));

        Text name = new Text("Name:");
        Text nameInput = new Text(nameString);
        name.setFont(Font.font("Times New Roman", 20));
        nameInput.setFont(Font.font("Times New Roman", 20));
        nameInput.setFill(Color.RED);
        Text size = new Text("Size: ");
        Text sizeInput = new Text(sizeString);
        size.setFont(Font.font("Times New Roman", 20));
        sizeInput.setFont(Font.font("Times New Roman", 20));
        sizeInput.setFill(Color.RED);
        Text numAnimals = new Text("Number of Animals:");
        Text numAnimalsInput = new Text(numAnimalsString);
        numAnimals.setFont(Font.font("Times New Roman", 20));
        numAnimalsInput.setFont(Font.font("Times New Roman", 20));
        numAnimalsInput.setFill(Color.RED);
        Text waterFeature = new Text("Water Feature: ");
        Text waterInput = new Text(waterString);
        waterFeature.setFont(Font.font("Times New Roman", 20));
        waterInput.setFont(Font.font("Times New Roman", 20));
        waterInput.setFill(Color.RED);

        Button logVisit = new Button("Log Visit");

        TableView exhibitDetails = new TableView();
        exhibitDetails.setMaxHeight(100);
        exhibitDetails.setMinWidth(720);
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setMinWidth(350);
        TableColumn speciesColumn = new TableColumn("Species");
        speciesColumn.setMinWidth(350);
        exhibitDetails.getColumns().addAll(nameColumn, speciesColumn);

        HBox detailsBox = new HBox(10, name, nameInput, size, sizeInput, numAnimals,
                numAnimalsInput, waterFeature, waterInput);

        ImageView background = new ImageView("GreyBackgound.jpg");
        background.setFitWidth(800);
        background.setFitHeight(400);

        this.getChildren().addAll(background, logVisit, detailsBox, atlHeader, exhibitDetails);

        detailsBox.setLayoutX(100);
        detailsBox.setLayoutY(100);
        atlHeader.setX(240);
        atlHeader.setY(70);
        logVisit.setLayoutX(350);
        logVisit.setLayoutY(200);
        exhibitDetails.setLayoutX(40);
        exhibitDetails.setLayoutY(250);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }
}
