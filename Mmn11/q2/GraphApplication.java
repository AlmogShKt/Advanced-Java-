package mmn11.mmn11q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mmn11.mmn11q2.Temp.YearTemperatures;
import mmn11.mmn11q2.Temp.TemperatureData;

import java.util.ArrayList;

public class GraphApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        loadTemperatureData();

        FXMLLoader fxmlLoader = new FXMLLoader(GraphApplication.class.getResource("graph-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        GraphApplicationController controller = fxmlLoader.getController();
        controller.initData();

        stage.setTitle("Temperature Graph");
        stage.setScene(scene);
        stage.show();
    }

    private void loadTemperatureData() {
        ArrayList<YearTemperatures> temperatures = new ArrayList<>();

        temperatures.add(new YearTemperatures(new int[]{17, 22, 23, 26, 25, 40, 14, 29, 32, 25, 18, 12}, 2015));
        temperatures.add(new YearTemperatures(new int[]{50, 20, 25, 32, 38, 9, 45, 40, 33, 26, 17, 11}, 2016));
        temperatures.add(new YearTemperatures(new int[]{12, 23, 28, 33, 39, 43, 63, 41, 35, 27, 19, 13}, 2017));
        temperatures.add(new YearTemperatures(new int[]{9, 45, 11, 37, 12, 13, 16, 53,7, 14, 10, 3}, 2018));
        temperatures.add(new YearTemperatures(new int[]{12, 23, 28, 33, 39, 43, 63, 41, 35, 27, 19, 13}, 2019));

        TemperatureData.initializeData(temperatures);
    }

    public static void main(String[] args) {
        launch(args);
    }
}