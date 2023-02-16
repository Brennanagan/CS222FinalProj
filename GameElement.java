import javax.swing.*;

public class GameElement extends JLabel {
    private Scene scene;

    public GameElement(Scene s){
        scene = s;
    }

    public Scene getScene(){
        return scene;
    }
}
