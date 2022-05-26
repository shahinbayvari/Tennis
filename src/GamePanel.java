import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = 1000;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 150;
    static final int PADDLE_HEIGHT = 25;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle;
    Ball ball;
    Score score;

    public GamePanel() {
        newPaddle();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        // random = new Random();
        ball = new Ball((GAME_WIDTH - BALL_DIAMETER) / 2, (GAME_HEIGHT - BALL_DIAMETER) / 2, BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddle() {
        paddle = new Paddle((GAME_WIDTH - PADDLE_WIDTH) / 2, GAME_HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        paddle.draw(g);
        ball.draw(g);
    }

    public void move() {
        paddle.move();
        ball.move();
    }

    public void checkCollision() {
        // stops paddle at window edges
        if (paddle.x <= 0) {
            paddle.x = 0;
        }
        if (paddle.x >= GAME_WIDTH - PADDLE_WIDTH) {
            paddle.x = GAME_WIDTH - PADDLE_WIDTH;
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }
    }
}
