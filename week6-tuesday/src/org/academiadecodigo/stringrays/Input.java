package org.academiadecodigo.stringrays;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.stringrays.Grid.Cell;
import org.academiadecodigo.stringrays.Grid.Grid;

public class Input implements KeyboardHandler {

    private Keyboard k;
    private Cursor cursor;
    private Grid grid;
    private Cell cell;

    public Input(Cursor cursor, Grid grid) {

        this.cursor = cursor;
        this.grid = grid;

        k = new Keyboard(this);


        int[] keys = {
                KeyboardEvent.KEY_UP,
                KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_RIGHT,
                KeyboardEvent.KEY_LEFT,
                KeyboardEvent.KEY_X,
                KeyboardEvent.KEY_C,
                KeyboardEvent.KEY_E,
                KeyboardEvent.KEY_S,
                KeyboardEvent.KEY_L,
                KeyboardEvent.KEY_R,
                KeyboardEvent.KEY_Y,
                KeyboardEvent.KEY_B,
                KeyboardEvent.KEY_O,
                KeyboardEvent.KEY_Q,
        };

        for (int key : keys) {
            setKeybindPressed(key);
            setKeybindReleased(key);
        }
    }


    @Override
    public void keyPressed(KeyboardEvent ev) {

        switch (ev.getKey()) {

            case KeyboardEvent.KEY_UP:
                cursor.moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
                cursor.moveDown();
                break;

            case KeyboardEvent.KEY_RIGHT:
                cursor.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
                cursor.moveLeft();
                break;

            case KeyboardEvent.KEY_X:
                cursor.paint();
                break;

            case KeyboardEvent.KEY_C:
                cursor.unpaint();
                break;

            case KeyboardEvent.KEY_E:
                cursor.clear();
                break;
            case KeyboardEvent.KEY_S:
                grid.setSaved();
                System.out.println(grid.getSaved());
                break;

            case KeyboardEvent.KEY_L:
                cursor.loadPaint();
                break;

            case KeyboardEvent.KEY_R:
                cursor.setColor(Color.RED);
                break;

            case KeyboardEvent.KEY_B:
                cursor.setColor(Color.BLUE);
                break;

            case KeyboardEvent.KEY_Y:
                cursor.setColor(Color.YELLOW);
                break;

            case KeyboardEvent.KEY_O:
                cursor.setColor(Color.ORANGE);
                break;

            case KeyboardEvent.KEY_Q:
                cursor.setColor(Color.CYAN);
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent ev) {}

    private void setKeybindPressed(int event) {
        KeyboardEvent newBind = new KeyboardEvent();
        newBind.setKey(event);
        newBind.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(newBind);
    }

    private void setKeybindReleased(int event) {
        KeyboardEvent newBind = new KeyboardEvent();
        newBind.setKey(event);
        newBind.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(newBind);
    }

}
