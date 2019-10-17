package org.academiadecodigo.stringrays;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.stringrays.Grid.Grid;

public class Cursor {

    private int col = 0;
    private int row = 0;

    private int cols;
    private int rows;

    private Color color = Color.CYAN;

    Grid grid;

    public Cursor(Grid grid) {
        this.grid = grid;
        this.cols = grid.getCols();
        this.rows = grid.getRows();

    }


    public void moveRight() {

        if (col >= cols - 1) {
            return;
        }

        fillCell(col + 1, row);
        drawCell(col, row);
        col++;
    }


    public void moveLeft() {

        if (col <= 0) {
            return;
        }

        fillCell(col - 1, row);
        drawCell(col, row);
        col--;
    }

    public void moveUp() {

        if (row <= 0) {
            return;
        }

        fillCell(col, row - 1);
        drawCell(col, row);
        row--;
    }


    public void moveDown() {

        if (row >= rows - 1) {

            return;
        }

        fillCell(col, row + 1);
        drawCell(col, row);
        row++;
    }


    public int getCol() {
        return this.col;
    }

    public int getCols() {
        return this.cols;
    }


    public void paint() {

        grid.getCells()[col][row].setPainted(true);
    }

    public void unpaint() {

        grid.getCells()[col][row].setPainted(false);
    }

    public void loadPaint() {

        String[] cellInfo = grid.loadFromMemory();
        String[] strArr;
        String[] temp;
        for (int i = 0; i < cellInfo.length; i++) {

            strArr = cellInfo[i].split("#");
            temp = strArr[0].split("/");


            switch (strArr[1]) {
                case "CYAN":
                    setColor(Color.CYAN);
                    break;
                case "RED":
                    setColor(Color.RED);
                    break;
                case "YELLOW":
                    setColor(Color.YELLOW);
                    break;
                case "BLUE":
                    setColor(Color.BLUE);
                    break;
            }

            fillCell(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            grid.getCells()[Integer.parseInt(temp[0])]
                    [Integer.parseInt(temp[1])].setPainted(true);
        }
    }


    public void clear() {
        for (int i = 0; i < grid.getCells().length; i++) {
            for (int j = 0; j < grid.getCells()[i].length; j++) {

                grid.getCells()[i][j].setPainted(false);
                grid.getCells()[i][j].drawCell();

            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public void fillCell(int x, int y) {



        if (!grid.getCells()[x][y].isPainted()) {
            grid.getCells()[x][y].fillCell(color);
        }
    }

    public void drawCell(int x, int y) {

        if (!grid.getCells()[x][y].isPainted()) {
            grid.getCells()[x][y].drawCell();
        }
    }
}
