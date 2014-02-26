import java.awt.Graphics2D;
import java.awt.Color;
import java.io.PrintStream;
import java.util.Scanner;

public class LifeModel implements ILifeModel {
    private int rows;
    private int cols;
    private int cellSize;
    private boolean[][] board;
    private boolean isScreenWrapped;
    
    /**
     * An interface for a model for Conway's Game of Life.
     * You need to keep track of the on or off state of each
     * cell in the game.
     * 
     * You should include a constructor that allows the user
     * to set the number of rows and columns and the size of
     * each cell in the game.
     */
    public LifeModel(int rows, int cols, int cellSize) {
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.board = new boolean[this.rows][this.cols];
        this.isScreenWrapped = false;
    }
    
    /**
     * returns the correct width of the Life canvas
     */
    public int getCanvasWidth() {
        return this.cols * this.cellSize;
    }
    
    /**
     * returns the correct height of the Life canvas
     */
    public int getCanvasHeight() {
        return this.rows * this.cellSize;
    }
    
    /**
     * contains code to draw the canvas correctly
     * you'll probably want to use the Graphics2D
     * fillRect() method
     */
    public void drawOnCanvas(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getCanvasWidth(), this.getCanvasHeight());
        g.setColor(Color.WHITE);
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (this.board[r][c]) {
                    g.fillRect(c * this.cellSize, r * this.cellSize, this.cellSize, this.cellSize);
                }
            }
        }
    }
        

    /**
     * given the x and y coordinate where a user clicked,
     * changes the state of the correct cell. If it was on,
     * change it to off, if off, change to on.
     */
    public void handleClick(int x, int y) {
        int row = y / this.cellSize;
        int col = x / this.cellSize;
        this.board[row][col] = !this.board[row][col];
    }

    /**
     * sets all cells to off
     */
    public void clearCells() {
        for (int r = 0; r < this.rows; r++) {
            for (int c= 0; c < this.cols; c++) {
                this.board[r][c] = false;
            }
        }
    }

    /**
     * determines whether the screen is considered "wrapped",
     * i.e. if the top row considers the bottom row a neighbor
     * and the left-most row considers the right-most a neighbor
     * and vice versa
     */
    public void setIsScreenWrapped(boolean isScreenWrapped) {
        this.isScreenWrapped = isScreenWrapped;
    }
    
    private int normalize(int value, int max) {
        if (value < 0 && this.isScreenWrapped) {
            return max + value;
        } else if (value >= max && this.isScreenWrapped) {
            return value - max;
        } else {
            return value;
        }
    }
    
    private boolean isCellAlive(int row, int col) {
        int newRow = normalize(row, this.rows);
        int newCol = normalize(col, this.cols);
        if (0 <= newRow && newRow < this.rows && 0 <= newCol && newCol < this.cols) {
            return this.board[newRow][newCol];
        } else {
            return false;
        }
    }
    
    private int getNeighbors(int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if ((r != row || c != col) && this.isCellAlive(r, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * changes the state of the model to the next state
     * off cells with exactly three on neighbors turn on
     * on cells with exactly two or three neighbors stay on
     * all other cells end up off
     */
    public void step() {
        boolean[][] newBoard = new boolean[this.rows][this.cols];
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.rows; c++) {
                int neighbors = this.getNeighbors(r, c);
                if (this.board[r][c] && (neighbors < 2 || neighbors > 3)) {
                    newBoard[r][c] = false;
                } else if (!this.board[r][c] && neighbors == 3) {
                    newBoard[r][c] = true;
                } else {
                    newBoard[r][c] = this.board[r][c];
                }
            }
        }
        this.board = newBoard;
    }
                        

    /**
     * prints a text file from which the current state can be
     * determined. The format is
     * +-------------------+
     * |rows cols cellSize |
     * |r1 c1              |
     * |r2 c2              |
     * |...                |
     * |rn cn              |
     * |                   |
     * +-------------------+
     * where each cell at row r and column c is on
     * for each of the r's and c's
     */
    public void printToFile(PrintStream out) {
        out.println(this.rows + " " + this.cols + " " + this.cellSize);
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (this.board[r][c]) {
                    out.println(r + " " + c);
                }
            }
        }
        
    }

    /**
     * reads a text file in the form given by printToFile and
     * sets the state of this model appropriately
     */
    public void readFromScanner(Scanner in) {
        int newRows = in.nextInt();
        int newCols = in.nextInt();
        int newCellSize = in.nextInt();
        boolean[][] newBoard = new boolean[newRows][newCols];
        while (in.hasNextInt()) {
            int r = in.nextInt();
            int c = in.nextInt();
            newBoard[r][c] = true;
        }
        this.rows = newRows;
        this.cols = newCols;
        this.cellSize = newCellSize;
        this.board = newBoard;
    }
    
    public static void main(String[] args) {
        new LifeGUI(new LifeModel(50, 50, 10));
    }
}
