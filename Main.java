import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

            File file = new File("Level1.txt");

            JPanel menu = new JPanel();
            GameFrame frame = new GameFrame(file, menu);
            GameLevel gameLevel = null;
        try {
            gameLevel = new GameLevel(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
            //gameLevel.setVisible(true);

        frame.addKeyListener(gameLevel.getPlayer());

        gameLevel.start();
        frame.add(gameLevel);
        frame.repaint();
    }
}