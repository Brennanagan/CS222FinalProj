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
    public Scene thisScene;

    public GameLevel()
    {
        this.setLayout(null);
        currentScene = scenes.get(0);
        timer = 500; //500 seconds to complete level
        score = 0;
        this.setVisible(true);
        this.setOpaque(true);
        this.setBounds(0,0, 1300, 800);
    }
    public GameLevel(File file) throws IOException {
        this.setLayout(null);
        this.LoadLevelFromFile(file);
        currentScene = scenes.get(0);
        timer = 500; //500 seconds to complete level
        score = 0;
        this.setBounds(0,0,1300, 800);

        this.setVisible(true);
        currentScene.addComponents();
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

        int sceneQuant = sceneArray.length-1;

        System.out.println(sceneQuant);
        int visIdx = 0;
        for(int w = 0; w<=sceneQuant; w++) {

            String stringScene = (sceneArray[w]);
            stringScene = stringScene.replace("\r\n", "");
            String[] splitScene = stringScene.split("");

            thisScene = new Scene(this);

            for (int z = 0; z < sceneElementQuant; z++) {

                String splitGameElement = splitScene[z];
                visIdx++;
                System.out.println(splitGameElement);
                thisScene = addElement(thisScene, splitGameElement, (z+(w*sceneElementQuant)));
            }

            scenes.add(thisScene);
            visIdx++;
        }
    }

    // A = air, G = ground, Q = Q-block, B = brick, PU = usable pipe, PN = non-usable pipe (maybe multiple parts?), E = elevation block
    Scene addElement(Scene scene, String sGE, int visualIndex)
    {

    visualIndex++;

    int yBound = (visualIndex/65)*20;
    int xBound = (visualIndex%65)*20;

    if (visualIndex%65 == 0)
    {
        xBound = 1280;
    }
    String letter = sGE;
    System.out.println(letter);

        if (letter.equalsIgnoreCase("G")) //will autoadding GameElement through GameElement constructor create issues here?
        {
            Wall ground = new Wall(thisScene, 1);
            ground.setBounds(xBound, yBound, unitLength, unitLength);
            scene.addWall(ground);
        } else if (letter.equalsIgnoreCase("E")) {
            Wall elevation = new Wall(thisScene, 2);
            elevation.setBounds(xBound, yBound, unitLength, unitLength);
            scene.addWall(elevation);
        } else if (letter.equalsIgnoreCase("B")) {
            Brick brick = new Brick(thisScene);
            brick.setBounds(xBound, yBound, unitLength, unitLength);
            scene.addBrick(brick);
        } else if (letter.equalsIgnoreCase("Q")) {
            QuestionBlock qBlock = new QuestionBlock(thisScene);
            qBlock.setBounds(xBound, yBound, unitLength, unitLength);
            scene.addQBlock(qBlock);
        } else if (letter.equalsIgnoreCase("PU")) {
            Pipe goodPipe = new Pipe(thisScene, true);
            goodPipe.setBounds(xBound, yBound, unitLength, unitLength);
            scene.addPipe(goodPipe);
        } else if (letter.equalsIgnoreCase("PN")) {
            Pipe badPipe = new Pipe(thisScene, false);
            badPipe.setBounds(xBound, yBound, unitLength, unitLength);
            scene.addPipe(badPipe);
        } else if (letter.equalsIgnoreCase("A")) {
//            Air air = new Air(scene);
//            air.setBounds(xBound, yBound, unitLength, unitLength);
//            air.setBackground(Color.cyan);
//            scene.addAir(air);
        } else {
            System.out.println("Error reading block type");
            System.out.println(sGE);
            if (sGE == " ")
            System.out.println("Incorrect Space");
        }


        //...
        return scene;
    }

    Scene getScene()
    {
        return currentScene;
    }


    void start()
    {
        add(currentScene);
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
