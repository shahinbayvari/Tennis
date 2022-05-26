import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 1000;
    private static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 25;
    public Paddle paddle;

    public Board() {
        newPaddle();
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(Color.BLACK);
    }

    public void newPaddle() {
        paddle = new Paddle((SCREEN_WIDTH - PADDLE_WIDTH) / 2, SCREEN_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
    }
}
