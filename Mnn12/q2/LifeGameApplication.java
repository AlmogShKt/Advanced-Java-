package mmn11.mmn12q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LifeGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LifeGameApplication.class.getResource("Llfegame-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        LifeGameController controller = fxmlLoader.getController();

        controller.initBoard();

        stage.setTitle("LifeGameController!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}