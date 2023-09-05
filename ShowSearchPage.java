import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class VisitorPage extends Pane {

    public VisitorPage(Stage stage, String username) {
        super();

        Text header = new Text("Visitor Page");
        header.setFill(Color.GOLD);
        header.setFont(Font.font("Times New Roman", 50));

        Image image = new Image("./Resources/VisitorBackground.jpg");
        ImageView background = new ImageView(image);

        background.setFitWidth(800);
        background.setFitHeight(400);
        Button searchExhibitsBtn = new Button("Search Exhibits");
        Button searchShowsBtn = new Button("Search Shows");
        Button searchAnimalsBtn = new Button("Search for Animals");
        Button exhibitHistoryBtn = new Button("View Exhibit History");
        Button showHistoryBtn = new Button("View Show History");
        Button logoutBtn = new Button("Log out");
        logoutBtn.setOnAction(event -> {
            LoginScreen login = new LoginScreen(stage);
        });

        VBox buttonBox = new VBox(searchExhibitsBtn, exhibitHistoryBtn,
                searchShowsBtn, showHistoryBtn, searchAnimalsBtn, logoutBtn);
        buttonBox.setSpacing(10);

        this.getChildren().addAll(background, header, buttonBox);
        buttonBox.setLayoutX(50);
        buttonBox.setLayoutY(100);
        header.setX(20);
        header.setY(70);

        searchAnimalsBtn.setOnAction(event -> {
            AnimalSearchPage animalSearchPage = new AnimalSearchPage(stage, username);
        });
        searchExhibitsBtn.setOnAction(event -> {
            ExhibitSearchPage exhibitSearchPage = new ExhibitSearchPage(stage, username);
        });
        searchShowsBtn.setOnAction(event -> {
            ShowsSearchPage showsSearchPage = new ShowsSearchPage(stage, username);
        });

        Scene scene = new Scene(this);

        stage.setScene(scene);
        stage.sizeToScene();

    }


}