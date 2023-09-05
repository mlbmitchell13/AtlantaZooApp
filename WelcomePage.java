import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import java.lang.Thread;



public class ZooApp extends Application {

    private Text welcome;
    private Text clickStart;
    private Scene mainScene;
    private ImageView background;



    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane firstStack = new Pane(); // Pane used to place text on
        primaryStage.setTitle("Zoo Application"); // Setting the title

        //*******Creating the Flashing Click To Start*******\\
        clickStart = new Text("Click to Start");
        clickStart.setFill(Color.WHITE);
        clickStart.setX(150);
        clickStart.setY(320);
        //**************************************************\\

        Thread flash = new Thread(() -> flashClick(clickStart, 0.5, -1));
        flash.setDaemon(true);
        flash.start();


        //*******************Creating Title**********************\\
        welcome = new Text("Welcome \n" + "to the \n" + "Atlanta \n" +
                "Zoo App!");
        welcome.setFill(Color.GOLD);
        welcome.setX(100);
        welcome.setY(100);
        welcome.setFont(Font.font("Georgia", 50));
        //****************************************************\\

        //*********************BackGround*********************\\
        background = new ImageView("MainBackground.jpg");
        background.setFitHeight(400);
        background.setFitWidth(800);
        //****************************************************\\

        /*background.setOnMouseClicked(event -> {
            LoginScreen login = new LoginScreen(primaryStage);
        });
        */

        firstStack.getChildren().add(background);
        firstStack.getChildren().addAll(welcome, clickStart);
        mainScene = new Scene(firstStack);
        primaryStage.setScene(mainScene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * This is the method used to have the "Click to Start" text to flash
     * @param text
     * @param dur
     * @param iteration
     */
    public void flashClick(Text text, double dur, int iteration) {
        EventHandler<ActionEvent> handler = event -> {
            if (text.isVisible()) {
                text.setVisible(false);
            } else {
                text.setVisible(true);
            }
        };

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(dur), handler);

        Timeline timeline = new Timeline();
        if (iteration < 0) {
            timeline.setCycleCount(Timeline.INDEFINITE);
        } else {
            timeline.setCycleCount(iteration);
        }

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public static void main(String args[]) {
        Application.launch(args);
    }


}
