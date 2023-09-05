import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;


public class StaffPage extends Pane {

    public StaffPage(Stage stage) {
        super();

        ImageView background = new ImageView("StaffBackground.jpg");
        background.setFitHeight(400);
        background.setFitWidth(800);

        Text header = new Text("Staff Page");
        header.setFill(Color.WHITE);
        header.setFont(Font.font("Times New Roman", 50));
        Button searchAnimals = new Button("Search Animals");
        Button viewShows = new Button("View Shows");
        Button loggout = new Button("Log Out");
        VBox buttonBox = new VBox(searchAnimals, viewShows, loggout);
        buttonBox.setSpacing(20);

        this.getChildren().addAll(background, buttonBox, header);
        buttonBox.setLayoutY(130);
        buttonBox.setLayoutX(545);
        buttonBox.setAlignment(Pos.CENTER);
        header.setX(500);
        header.setY(70);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
