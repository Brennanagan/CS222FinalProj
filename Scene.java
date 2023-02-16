import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel {
    private ArrayList<GameElement> elements;
    Player player;

    public Scene(){

        setLayout(null);
        setBounds(0, 0, 800, 500);
        elements = new ArrayList<GameElement>();
    }

    public void add(GameElement ge){
        super.add(ge);
        elements.add(ge);
    }

    public static void main(String[] args){
        JFrame f = new JFrame("test");
        f.setVisible(true);
        f.setBounds(100, 100, 800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scene s = new Scene();
        f.add(s);

        Wall groud = new Wall(s);
        groud.setBounds(0, 400, 800, 40);
        groud.setOpaque(true);
        groud.setBackground(Color.DARK_GRAY);

        Wall wall1 = new Wall(s);
        wall1.setBounds(180, 360, 40, 40);
        wall1.setBackground(Color.GREEN);
        wall1.setOpaque(true);

        Wall wall2 = new Wall(s);
        wall2.setBounds(260, 340, 40, 80);
        wall2.setBackground(Color.GREEN);
        wall2.setOpaque(true);

        Wall wall3 = new Wall(s);
        wall3.setBounds(340, 300, 40, 120);
        wall3.setBackground(Color.GREEN);
        wall3.setOpaque(true);

        Wall wall4 = new Wall(s);
        wall4.setBounds(420, 340, 40, 80);
        wall4.setBackground(Color.GREEN);
        wall4.setOpaque(true);

        Player player = new Player(s, 5, 20);
        player.setText("       Hi");
        player.setHorizontalTextPosition(JLabel.RIGHT);
        player.setVerticalTextPosition(JLabel.CENTER);
        player.setBackground(Color.YELLOW);
        player.setSize(40, 40);
        player.setOpaque(true);
        player.setLocation(50, 50);
        f.addKeyListener(player);
        player.setEnabled(true);
    }

}
