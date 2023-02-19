import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

            File file = new File("C:\\Users\\Brennan\\IdeaProjects\\FinalProject\\Level1.txt");

            JPanel menu = new JPanel();
            GameFrame frame = new GameFrame(file, menu);
            GameLevel gameLevel;
        try {
            gameLevel = new GameLevel(file);
        } catch (IOException e) {
            System.out.println("Game level creation error");
            gameLevel = new GameLevel();
            throw new RuntimeException(e);
        }
            //gameLevel.setVisible(true);

        Player player = new Player(gameLevel.getScene(), 5, 20);
        player.setLayout(null);
        player.setText("       Hi");
        player.setHorizontalTextPosition(JLabel.RIGHT);
        player.setVerticalTextPosition(JLabel.CENTER);
        player.setBackground(Color.YELLOW);
        player.setSize(40, 40);
        player.setOpaque(true);
        player.setLocation(100, 300);
        frame.addKeyListener(player);
        player.setEnabled(true);
        player.setVisible(true);


        gameLevel.start();
        frame.add(player);
        frame.add(gameLevel);
        frame.repaint();
    }
}