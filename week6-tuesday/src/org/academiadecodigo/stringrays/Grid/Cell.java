package org.academiadecodigo.stringrays.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    enum Colors{
        RED,
        BLUE,
        YELLOW,
        CYAN,
        GRAY,
        ORANGE
    }

    private int cellSize = 150;
    private boolean painted;
    private Rectangle cell;


    public Cell(double x, double y){

        cell = new Rectangle(x * cellSize, y * cellSize, cellSize, cellSize);
        drawCell();
    }


    public void fillCell(Color color){

        cell.setColor(color);
        cell.fill();
    }

    public void drawCell(){

        cell.setColor(Color.GRAY);
        cell.draw();
    }

    public boolean isFilled(){

        return cell.isFilled();
    }

    public int getCellSize(){
        return cellSize;
    }

    public Colors getColor(){

        if(cell.getColor()== Color.BLUE){
            return Colors.BLUE;
        }
        if(cell.getColor() == Color.CYAN){
            return  Colors.CYAN;
        }
        if(cell.getColor() == Color.YELLOW){
            return  Colors.YELLOW;
        }
        if(cell.getColor() == Color.RED){
            return  Colors.RED;
        }
        if(cell.getColor() == Color.ORANGE){
            return  Colors.ORANGE;
        }

        return Colors.GRAY;
    }

    public void setPainted(boolean b){

        this.painted = b;
    }

    public boolean isPainted(){
        return painted;
    }

}
