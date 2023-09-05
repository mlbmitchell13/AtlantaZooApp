import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

public class StaffLogNotePage extends Pane {
    private int count = 0;

    public StaffLogNotePage(Stage stage, String username) {
        super();

        String nameString = "Nemo";
        String speciesString = "ClownFlish";
        String ageString = "8";
        String exhibitString = "Pacific";
        String typeString = "Fish";

        Text header = new Text("Animal Note Detail");
        header.setFont(Font.font("Times New Roman", 30));

        Text name = new Text("Name: ");
        Text nameInput = new Text(nameString);
        name.setFont(Font.font("Times New Roman", 20));
        nameInput.setFont(Font.font("Times New Roman", 20));
        nameInput.setFill(Color.RED);

        Text species = new Text("Species: ");
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
        Text typeInput = new Text(typeString);
        type.setFont(Font.font("Times New Roman", 20));
        typeInput.setFont(Font.font("Times New Roman", 20));
        typeInput.setFill(Color.RED);

        Image image = new Image("./Resources/GreyBackground.jpg");
        ImageView background = new ImageView(image);
        background.setFitWidth(800);
        background.setFitHeight(400);

        Button logNote = new Button("Log Note");
        Button backBtn = new Button("Back");
        backBtn.setOnAction(event -> {
            AnimalSearchPage animalSearchPage = new AnimalSearchPage(stage, username);
        });


        HBox detailsBox = new HBox(10, name, nameInput, species, speciesInput,
                age, ageInput, exhibit, exhibitInput, type, typeInput);

        TextArea note = new TextArea("Add notes here...");
        note.setMaxSize(150, 75);
        note.setWrapText(true);
        note.setOnMouseClicked(event -> {
            if (count < 1) {
                note.setText("");
                count++;
            }
        });

        ObservableList<String> noteDetails =
                FXCollections.observableArrayList(
                        "Pacific", "800", "80", "Yes"
                );
        TableView<String> noteInfo = new TableView<>(noteDetails);
        noteInfo.setMaxHeight(100);
        noteInfo.setMinWidth(720);
        TableColumn staffMember = new TableColumn("Staff Member");
        staffMember.setMinWidth(240);
        TableColumn noteText = new TableColumn("Note");
        noteText.setMinWidth(240);
        TableColumn showDate = new TableColumn("Date");
        showDate.setMinWidth(240);
        noteInfo.getColumns().addAll(staffMember, noteText, showDate);

        this.getChildren().addAll(background, header, detailsBox, note, logNote, backBtn, noteInfo);

        header.setX(50);
        header.setY(50);
        detailsBox.setLayoutX(50);
        detailsBox.setLayoutY(100);
        note.setLayoutX(50);
        note.setLayoutY(150);
        logNote.setLayoutX(215);
        logNote.setLayoutY(175);
        backBtn.setLayoutX(300);
        backBtn.setLayoutY(175);
        noteInfo.setLayoutX(50);
        noteInfo.setLayoutY(250);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }
}