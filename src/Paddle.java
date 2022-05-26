import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {
    int xVelocity;

    public Paddle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setXDirection(10);
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setXDirection(-10);
            move();
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setXDirection(0);
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setXDirection(0);
            move();
        }
    }

    public void setXDirection(int xDirection) {

    }

    public void move() {

    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}
