import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        JFrame frame = new JFrame();
        frame.add(board);
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
