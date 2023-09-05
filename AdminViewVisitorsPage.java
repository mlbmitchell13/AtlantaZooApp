import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class AdminViewVisitorsPage extends Pane{

    public AdminViewVisitorsPage(Stage stage, String username) {
        super();

        Text header = new Text("View Visitors");
        header.setFont(Font.font("Times New Roman", 50));

        Image image = new Image("./Resources/GreyBackground.jpg");
        ImageView background = new ImageView(image);
        background.setFitWidth(800);
        background.setFitHeight(400);

        ObservableList<String> visitorDetails =
                FXCollections.observableArrayList(
                        "Pacific", "800", "80", "Yes"
                );
        javafx.scene.control.TableView<String> visitorInfo =
                new javafx.scene.control.TableView<>(visitorDetails);
        visitorInfo.setMaxHeight(100);
        visitorInfo.setMinWidth(720);
        TableColumn visitorUsername = new TableColumn("Username");
        visitorUsername.setMinWidth(360);
        TableColumn visitorEmail = new TableColumn("Email");
        visitorEmail.setMinWidth(360);
        visitorInfo.getColumns().addAll(visitorUsername, visitorEmail);

        Button delete = new Button("Delete Visitor");
        Button backBtn = new javafx.scene.control.Button("Back");
        backBtn.setOnAction(event -> {
            AdminPage adminPage = new AdminPage(stage, username);
        });
        HBox buttonBox = new HBox(15, delete, backBtn);

        this.getChildren().addAll(background, header, visitorInfo, buttonBox);

        header.setX(250);
        header.setY(75);
        visitorInfo.setLayoutX(40);
        visitorInfo.setLayoutY(175);
        buttonBox.setLayoutX(300);
        buttonBox.setLayoutY(300);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }
}
