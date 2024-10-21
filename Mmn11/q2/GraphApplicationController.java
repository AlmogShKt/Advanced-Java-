package mmn11.mmn11q2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import mmn11.mmn11q2.Temp.TemperatureData;
import mmn11.mmn11q2.Temp.YearTemperatures;

public class GraphApplicationController {
    private int currentYear = 0;

    @FXML
    private Button nextBt;
    @FXML
    private Label titleText;
    @FXML
    private Canvas canvas;

    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public void initData() {
        updateTitle();
        drawGraph();
    }

    @FXML
    void onNextButtonClick(MouseEvent event) {
        currentYear = (currentYear + 1) % TemperatureData.getTotalYears();
        updateTitle();
        drawGraph();
    }

    private void updateTitle() {
        if (titleText != null && !TemperatureData.getTemps().isEmpty()) {
            titleText.setText("This is the Avg' Temp for " + TemperatureData.getTemps().get(currentYear).getYear());
        }
    }

    private void drawGraph() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        YearTemperatures temp = TemperatureData.getTemperatures().get(currentYear);
        GraphDimensions dim = calculateGraphDimensions();

        clearCanvas(gc);
        drawAxesAndGrid(gc, dim, temp.getMaxTemp());
        drawBars(gc, dim, temp);
    }

    private void clearCanvas(GraphicsContext gc) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private GraphDimensions calculateGraphDimensions() {
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        double yAxisX = 50;
        double xAxisY = height - 30;
        double graphHeight = height - 60;
        double graphWidth = width - 70;
        return new GraphDimensions(width, height, yAxisX, xAxisY, graphHeight, graphWidth);
    }

    private void drawAxesAndGrid(GraphicsContext gc, GraphDimensions dim, int maxTemp) {
        double scale = dim.graphHeight / maxTemp;

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        for (int t = 0; t <= maxTemp; t += 5) {
            double y = dim.xAxisY - t * scale;
            gc.setStroke(Color.LIGHTGRAY);
            gc.strokeLine(dim.yAxisX, y, dim.width - 20, y);
            gc.setStroke(Color.BLACK);
            gc.strokeText(String.valueOf(t), dim.yAxisX - 30, y + 5);
        }

        gc.strokeLine(dim.yAxisX, 30, dim.yAxisX, dim.xAxisY);
        gc.strokeLine(dim.yAxisX, dim.xAxisY, dim.width - 10, dim.xAxisY);
    }

    private void drawBars(GraphicsContext gc, GraphDimensions dim, YearTemperatures temp) {
        int[] temperatures = temp.getTemperatures();
        double scale = dim.graphHeight / temp.getMaxTemp();
        double barWidth = dim.graphWidth / 12;

        for (int month = 0; month < 12; month++) {
            drawBar(gc, dim, temp, temperatures, scale, barWidth, month);
        }
    }

    private void drawBar(GraphicsContext gc, GraphDimensions dim, YearTemperatures temp, int[] temperatures, double scale, double barWidth, int month) {
        double x = dim.yAxisX + month * barWidth + 5;
        double barHeight = temperatures[month] * scale;
        double barY = dim.xAxisY - barHeight;

        setBarColor(gc, temp, month);
        gc.fillRect(x, barY, barWidth - 10, barHeight);

        drawMonthLabel(gc, x, barWidth, dim.xAxisY, month);
        drawTemperatureValue(gc, x, barWidth, barY, temperatures[month]);
    }

    private void setBarColor(GraphicsContext gc, YearTemperatures temp, int month) {
        if (month == temp.getMaxTempMonth()) {
            gc.setFill(Color.RED);
        } else if (month == temp.getMinTempMonth()) {
            gc.setFill(Color.BLUE);
        } else {
            gc.setFill(Color.GRAY);
        }
    }

    private void drawMonthLabel(GraphicsContext gc, double x, double barWidth, double xAxisY, int month) {
        gc.setFill(Color.BLACK);
        gc.fillText(MONTHS[month], x + barWidth / 2 - 10, xAxisY + 15);
    }

    private void drawTemperatureValue(GraphicsContext gc, double x, double barWidth, double barY, int temperature) {
        gc.setFill(Color.BLACK);
        gc.fillText(String.valueOf(temperature), x + barWidth / 2 - 10, barY - 5);
    }

    private static class GraphDimensions {
        final double width;
        final double height;
        final double yAxisX;
        final double xAxisY;
        final double graphHeight;
        final double graphWidth;

        GraphDimensions(double width, double height, double yAxisX, double xAxisY, double graphHeight, double graphWidth) {
            this.width = width;
            this.height = height;
            this.yAxisX = yAxisX;
            this.xAxisY = xAxisY;
            this.graphHeight = graphHeight;
            this.graphWidth = graphWidth;
        }
    }
}