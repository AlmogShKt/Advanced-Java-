package mmn11.mmn12q2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Random;

public class LifeGameController {
    private static final int CELL_SIZE = 25;
    private static final int GRID_SIZE = 10;
    private int generation = 0;
    private int[][] grid = new int[GRID_SIZE][GRID_SIZE];
    private int[][] nextGrid = new int[GRID_SIZE][GRID_SIZE];


    @FXML
    private Button nextGenBt;

    @FXML
    private Canvas canvas;


    @FXML
    private Label label;

    @FXML
    void onNextGenClick(MouseEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        clearCanvas(gc);
        //For the first gen, just draw the init state
        if (generation == 0) {
            fillGrid();
            drawCanvas(gc);
        } else {
            // for each other gen, calc and draw the new gen
            drawNextGen(gc);
        }

        generation += 1;
        setTitle();
    }

    public void initBoard() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        setTitle();
        drawCanvas(gc);
    }

    private void drawNextGen(GraphicsContext gc) {
        // Loop for each cell in the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int liveNeighbors = countLiveNeighbors(row, col);
                fillNextGenCell(row, col, liveNeighbors);
            }
        }
        copyGrid();
        drawCanvas(gc);
    }

    private void fillNextGenCell(int row, int col, int liveNeighbors) {
        // Apply the birth, death, and exist rules
        if (grid[row][col] == 0) {
            // Birth rule: dead cell becomes alive if it has exactly 3 live neighbors
            if (liveNeighbors == 3) {
                nextGrid[row][col] = 1; // Birth
            } else {
                nextGrid[row][col] = 0; // Remains dead
            }
        } else if (grid[row][col] == 1) {
            // Death rules:
            if (liveNeighbors <= 1) {
                nextGrid[row][col] = 0; // Dies from loneliness
            } else if (liveNeighbors >= 4) {
                nextGrid[row][col] = 0; // Dies from overcrowding
            } else {
                nextGrid[row][col] = 1; // Continues to live (exist rule)
            }
        }
    }

    private void setTitle() {
        if (label != null) {
            label.setText("Gen: " + this.generation);
        }
    }

    private void copyGrid() {
        for (int row = 0; row < grid.length; row++) {
            System.arraycopy(nextGrid[row], 0, grid[row], 0, grid[row].length);

        }
    }

    private void fillGrid() {
        double probability = 0.5; // just a small probability
        Random random = new Random();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                // Randomly assign 1 or 0
                if (random.nextDouble() < probability) {
                    grid[row][col] = 1;
                } else {
                    grid[row][col] = 0;
                }
            }

        }
    }

    private int countLiveNeighbors(int row, int col) {
        int liveCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the cell itself
                if (i == 0 && j == 0) continue;

                // Check neighbors bounds and count live cells
                int neighborRow = row + i;
                int neighborCol = col + j;

                if (neighborRow >= 0 && neighborRow < grid.length && neighborCol >= 0 && neighborCol < grid[row].length) {
                    liveCount += grid[neighborRow][neighborCol];
                }
            }
        }
        return liveCount;
    }

    private void clearCanvas(GraphicsContext gc) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawCanvas(GraphicsContext gc) {
        gc.setLineWidth(1);
        gc.setStroke(Color.BLACK);

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == 1) {
                    gc.setFill(Color.GRAY);
                    gc.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
                gc.strokeRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}