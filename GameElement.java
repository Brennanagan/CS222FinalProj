import javax.swing.*;

public class GameElement extends JLabel {
    private Scene scene;

    public GameElement(Scene s){
        scene = s;
        scene.add(this);
    }

    public Scene getScene(){
        return scene;
    }
}
