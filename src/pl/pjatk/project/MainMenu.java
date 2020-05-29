package pl.pjatk.project;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenu extends Application {
    private final BorderPane root = new BorderPane();
    private final VBox buttons = new VBox();
    private final Scene menuScene = new Scene(root, 600, 500);
    private final Button btnText = new Button("Text Encrypt");
    private final Button btnFile = new Button("File Encrypt");
    private final Image coverArtImage = new Image(new FileInputStream(".\\src\\pl\\pjatk\\project\\SplashScreenLogo.png"));
    private final ImageView coverArt = new ImageView(coverArtImage);
    private final Label copyright = new Label("\u00a9 Jan Sitarski s20701");

    public MainMenu() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Main Menu");

        buttons.getChildren().addAll(btnText, btnFile);
        root.setTop(coverArt);
        root.setBottom(copyright);
        BorderPane.setAlignment(coverArt,Pos.CENTER);
        root.setCenter(buttons);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(15.0);
        btnFile.setPrefWidth(400.0);
        btnText.setPrefWidth(400.0);

        primaryStage.setScene(menuScene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());

        btnText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage textStage = new Stage();
                TextMenu textMenu = new TextMenu();
                try {
                    textMenu.start(textStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage fileStage = new Stage();
                FileMenu fileMenu = new FileMenu();
                try {
                    fileMenu.start(fileStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
