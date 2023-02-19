import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLevel extends JPanel {
    ArrayList<Scene> scenes = new ArrayList<>();
    Scene currentScene;
    int score;
    int timer;
    final int unitLength = 20;
    Player player;

    public GameLevel(File file) throws IOException {
        this.setLayout(null);
        this.LoadLevelFromFile(file);
        currentScene = scenes.get(0);
        timer = 500; //500 seconds to complete level
        score = 0;
        this.setBounds(0,0,2000, 1000);

        this.setVisible(true);
//        currentScene.addComponents();
    }

    // A = air, G = ground, Q = Q-block, B = brick, PU = usable pipe, PN = non-usable pipe (maybe multiple parts?), E = elevation block
    // format -> |Letter for block|Q|B|A|PU|||...|............
    // ||| separates each scene
    void LoadLevelFromFile(File file) throws IOException {


        // each scene contains ((GameFrame.HEIGHT/unitLength)*(GrameFrame.WIDTH/unitLength)) GameElements
        final int sceneElementQuant = ((800/unitLength)*(1300/unitLength)); // 65 wide by 40 high
        Path path = Path.of(file.getPath());
        String fullFile = Files.readString(path);

        String[] sceneArray = fullFile.split("_");
        int visIdx = 0;
        for(int w = 0; w < sceneArray.length; w++) {

            String stringScene = sceneArray[w];
            stringScene = stringScene.replaceAll("\r\n", "");
            String[] splitScene = stringScene.split("");

            Scene thisScene = new Scene(this);

            for (int z = 0; z < sceneElementQuant; z++) {

                String splitGameElement = splitScene[z];
                visIdx++;
//                System.out.println(splitGameElement);
                addElement(thisScene, splitGameElement, (z+(w*sceneElementQuant)));
            }
            scenes.add(thisScene);
            visIdx++;
        }
        System.out.println(scenes);
    }

    // A = air, G = ground, Q = Q-block, B = brick, PU = usable pipe, PN = non-usable pipe (maybe multiple parts?), E = elevation block
    void addElement(Scene scene, String sGE, int visualIndex)
    {

    visualIndex++;

    int yBound = (visualIndex/65)*20;
    int xBound = (visualIndex%65)*20;

    if (visualIndex%65 == 0)
    {
        xBound = 1280;
    }
    String letter = sGE;
//    System.out.println(letter);


        if (letter.equalsIgnoreCase("P")) //will autoadding GameElement through GameElement constructor create issues here?
        {
            Player p = new Player(scene, 5, 15);
            p.setBounds(xBound, yBound, unitLength, unitLength);
            System.out.println((xBound + 1) + ", " + (yBound + 1));
            this.player = p;
        }else if (letter.equalsIgnoreCase("G")) {
            Wall ground = new Wall(scene, 1);
            ground.setBounds(xBound, yBound, unitLength, unitLength);
        } else if (letter.equalsIgnoreCase("E")) {
            Wall elevation = new Wall(scene, 2);
            elevation.setBounds(xBound, yBound, unitLength, unitLength);
        } else if (letter.equalsIgnoreCase("B")) {
            Brick brick = new Brick(scene);
            brick.setBounds(xBound, yBound, unitLength, unitLength);
        } else if (letter.equalsIgnoreCase("Q")) {
            QuestionBlock qBlock = new QuestionBlock(scene);
            qBlock.setBounds(xBound, yBound, unitLength, unitLength);
        } else if (letter.equalsIgnoreCase("PU")) {
            Pipe goodPipe = new Pipe(scene, true);
            goodPipe.setBounds(xBound, yBound, unitLength, unitLength);
        } else if (letter.equalsIgnoreCase("PN")) {
            Pipe badPipe = new Pipe(scene, false);
            badPipe.setBounds(xBound, yBound, unitLength, unitLength);
        } else if (letter.equalsIgnoreCase("A")) {

        } else {
            System.out.println("Error reading block type");
//            System.out.println(sGE);
            if (sGE == " ")
            System.out.println("Incorrect Space");
        }
    }

    Scene getScene()
    {
        return currentScene;
    }

    Player getPlayer(){
        return player;
    }

    void start()
    {
        add(currentScene);
        player.setEnabled(true);
    }

    void timer()
    {

    }



    void gameOver()
    {

    }

    // add endLevel JPanel info, add to Frame, remove "currentScene" from frame
    void endLevel()
    {
       Scene endLevel = new Scene();
       this.add(endLevel);
       this.remove(currentScene);

        // create endLevel below

    }

    //if there is another playable scene, sets to next
    //if on last playable scene, goes to endLevel JPanel
    //both functions remove "currentScene"

    void changeScene()
    {
        int currentSceneID = scenes.indexOf(currentScene);
        if (scenes.size()-2 > currentSceneID)
        {
            this.add(scenes.get(currentSceneID+1));
            this.remove(currentScene);
            currentScene = scenes.get(currentSceneID+1);
        }else if (scenes.size() - 2 == currentSceneID){
            endLevel();
        }
    }




}
