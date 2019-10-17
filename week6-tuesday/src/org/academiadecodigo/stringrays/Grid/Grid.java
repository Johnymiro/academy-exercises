package org.academiadecodigo.stringrays.Grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stringrays.Cursor;
import org.academiadecodigo.stringrays.Input;

import java.io.*;

public class Grid implements Serializable {

    private int cols;
    private int rows;
    private String saved = "";


    private Cursor cursor;
    private Input input;

    private Cell[][] cells;
    public static int PADDING = 3;


    public Grid(int cols, int rows) {
        cells = new Cell[cols][rows];

        this.cols = cols;
        this.rows = rows;

        this.input = new Input(new Cursor(this), this);

        spawnCells();
    }


    public void spawnCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {


                cells[i][j] = new Cell(i + 0.5, j + 0.5);
                cells[i][j].drawCell();
            }
        }
    }


    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }


    public Cell[][] getCells() {
        return this.cells;
    }

    public String getSaved() {

        return saved;
    }


    public void setSaved() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {

                if (cells[i][j].isPainted()) {

                    saved += i + "/" + j + "#" + cells[i][j].getColor() + " \n";
                    new Save().saveToMemory();
                }
            }
        }
        saved = "";
    }

    public String[] loadFromMemory() {

        return new Save().loadFromMemory();
    }


    private class Save {

        File file = new File
                ("/Users/codecadet/Desktop/academy-exercises/week6-tuesday/resources/save0.txt");


        public void saveToMemory() {

            try {

                FileWriter writer = new FileWriter(file);
                new PrintWriter(file).close();
                BufferedWriter bWriter = new BufferedWriter(writer);


                bWriter.write(saved);
                bWriter.close();
                writer.close();


            } catch (IOException ex) {
                System.out.println("saveToMemory --> " + ex.getMessage());
            }
        }

        public String[] loadFromMemory() {

            String line = "";
            String result = "";
            String[] resultArr;

            try {

                FileReader reader = new FileReader(file);
                BufferedReader bReader = new BufferedReader(reader);

                while ((line = bReader.readLine()) != null) {

                    result += line;
                }

            } catch (IOException ex) {
                System.out.println("loadFromMemory -->" + ex.getMessage());
            }

            resultArr = result.split(" ");
            return resultArr;


        }
    }
}
