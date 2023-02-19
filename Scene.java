import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Scene extends JPanel {
    ArrayList<GameElement> lmnts;
    Scene nextScene;
    GameLevel gameLevel;
    int id;

    public Scene() {
        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(0,0, 1300, 800);
        lmnts = new ArrayList<GameElement>();
    }


    public Scene(GameLevel gameLevel) {
        setLayout(null);
        lmnts = new ArrayList<GameElement>();
        this.gameLevel = gameLevel;
        setBounds(0, 0, 2000, 1000);

    }

    public void add(GameElement ge){
        super.add(ge);
        lmnts.add(ge);
    }

//    public void addWall(Wall wall) {
//        this.add(wall);
//        lmnts.add(wall);
//    }
//
//    public void addBrick(Brick brick) {
//        this.add(brick);
//        lmnts.add(brick);
//    }
//
//    public void addQBlock(QuestionBlock qBlock) {
//        this.add(qBlock);
//        lmnts.add(qBlock);
//    }
//
//    public void addPipe(Pipe pipe) {
//        this.add(pipe);
//        lmnts.add(pipe);
//    }
//
//    public void addAir(Air air) {
//        this.add(air);
//        lmnts.add(air);
//    }
//
//    public void addPlayer(Player p){
//        this.add(p);
//        lmnts.add(p);
//    }

    public void makeNextScene() {
        gameLevel.add(nextScene); // test this concept
        gameLevel.remove(this);
    }

    public void addComponents()
    {
        for (int i = 0; i< lmnts.size(); i++)
        {
            gameLevel.add(lmnts.get(i));
        }
    }

    public String toString(){
        return "Scene " + id;
    }



    public void makeNextSceneTest(Scene s) {
        gameLevel.add(s); // SEE lines 97-101 for proof of viability
        gameLevel.remove(this);
    }
}

//    public static void main(String[] args) throws InterruptedException {
//        JFrame f = new JFrame("test");
//        f.setVisible(true);
//        f.setBounds(0, 0, 800, 500);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Scene s = new Scene();
//        f.add(s);
//
//        Wall groud = new Wall(s, 1);
//        groud.setBounds(0, 400, 800, 40);
//        groud.setOpaque(true);
//
//        s.add(groud);
//
//        Wall wall1 = new Wall(s, 2);
//        wall1.setBounds(180, 360, 40, 40);
//
//        wall1.setOpaque(true);
//        s.add(wall1);
//
//        Wall wall2 = new Wall(s, 2);
//        wall2.setBounds(260, 340, 40, 80);
//        wall2.setBackground(Color.GREEN);
//        wall2.setOpaque(true);
//
//        Wall wall3 = new Wall(s, 2);
//        wall3.setBounds(340, 300, 40, 120);
//        wall3.setBackground(Color.GREEN);
//        wall3.setOpaque(true);
//
//        Wall wall4 = new Wall(s, 2);
//        wall4.setBounds(420, 340, 40, 80);
//        wall4.setBackground(Color.GREEN);
//        wall4.setOpaque(true);
//
//        Player player = new Player(s, 5, 20);
//        player.setText("       Hi");
//        player.setHorizontalTextPosition(JLabel.RIGHT);
//        player.setVerticalTextPosition(JLabel.CENTER);
//        player.setBackground(Color.YELLOW);
//        player.setSize(40, 40);
//        player.setOpaque(true);
//        player.setLocation(50, 50);
//        f.addKeyListener(player);
//        player.setEnabled(true);
//
//        s.add(player);
//
//
//
//
//
//        Thread.sleep(15000);
//        Scene newScene = new Scene();
//        f.add(newScene);
//        f.remove(s);
//
//
//
//
//
//        Wall groudNew = new Wall(newScene, 1);
//        groudNew.setBounds(0, 400, 800, 40);
//        groudNew.setOpaque(true);
//        groudNew.setBackground(Color.BLUE);
//
//        Wall wall1new = new Wall(newScene, 2);
//        wall1new.setBounds(180, 360, 40, 40);
//        wall1new.setOpaque(true);
//
//        Wall wall2new = new Wall(newScene, 2);
//        wall2new.setBounds(260, 340, 40, 80);
//        wall2new.setOpaque(true);
//
//        Wall wall3new = new Wall(newScene, 2);
//        wall3new.setBounds(500, 300, 40, 120);
//        wall3new.setOpaque(true);
//
//        Wall wall4new = new Wall(newScene, 2);
//        wall4new.setBounds(420, 340, 40, 200);
//        wall4new.setOpaque(true);
//
//        Player player1 = new Player(newScene, 5, 20);
//        player1.setText("       Hi");
//        player1.setHorizontalTextPosition(JLabel.RIGHT);
//        player1.setVerticalTextPosition(JLabel.CENTER);
//        player1.setBackground(Color.YELLOW);
//        player1.setSize(40, 40);
//        player1.setOpaque(true);
//        player1.setLocation(50, 50);
//        f.addKeyListener(player1);
//        player1.setEnabled(true);
//
//        newScene.add(player1);
//
//        f.repaint();
//    }
//}
