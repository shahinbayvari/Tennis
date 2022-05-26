import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 1000;
    private static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

    public Board() {
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(Color.BLACK);
    }
}
