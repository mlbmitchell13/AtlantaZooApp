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

public class AnimalDetailPage extends Pane {

    public AnimalDetailPage(Stage stage, String username) {
        super();

        String nameString = "Nemo";
        String speciesString = "ClownFlish";
        String ageString = "8";
        String exhibitString = "Pacific";
        String typeString = "Fish";

        Text name = new Text("Name: ");
        Text nameInput = new Text(nameString);
        name.setFont(Font.font("Times New Roman", 20));
        nameInput.setFont(Font.font("Times New Roman", 20));
        nameInput.setFill(Color.RED);

        Text species = new Text("Species ");
        Text speciesInput = new Text(speciesString);
        species.setFont(Font.font("Times New Roman", 20));
        speciesInput.setFont(Font.font("Times New Roman", 20));
        speciesInput.setFill(Color.RED);

        Text age = new Text("Age: ");
        Text ageInput = new Text(ageString);
        age.setFont(Font.font("Times New Roman", 20));
        ageInput.setFont(Font.font("Times New Roman", 20));
        ageInput.setFill(Color.RED);

        Text exhibit = new Text("Exhibit: ");
        Text exhibitInput = new Text(exhibitString);
        exhibit.setFont(Font.font("Times New Roman", 20));
        exhibitInput.setFont(Font.font("Times New Roman", 20));
        exhibitInput.setFill(Color.RED);

        Text type = new Text("Type: ");
        Text typeInput = new Text(nameString);
        type.setFont(Font.font("Times New Roman", 20));
        typeInput.setFont(Font.font("Times New Roman", 20));
        typeInput.setFill(Color.RED);

        Image image = new Image("./Resources/GreyBackground.jpg");
        ImageView background = new ImageView(image);
        background.setFitWidth(800);
        background.setFitHeight(400);

        Button backBtn = new Button("Back");
        backBtn.setOnAction(event -> {
            AnimalSearchPage animalSearchPage = new AnimalSearchPage(stage, username);
        });

        HBox detailsBox = new HBox(10, name, nameInput, species, speciesInput,
                age, ageInput, exhibit, exhibitInput, type, typeInput);

        this.getChildren().addAll(background, detailsBox, backBtn);

        detailsBox.setLayoutX(70);
        detailsBox.setLayoutY(150);
        backBtn.setLayoutX(375);
        backBtn.setLayoutY(200);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }

}
