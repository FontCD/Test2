package logic;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainScene.fxml")));
        Scene mainScene = new Scene(root);
        stage.setTitle("Moteeve");
        stage.setResizable(false);

        stage.setScene(mainScene);
        stage.show();

    }

}
