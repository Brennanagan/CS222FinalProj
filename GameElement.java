import javax.swing.*;

public class GameElement extends JLabel {

    Scene s;

    public GameElement(Scene s)
    {
        this.s = s;
        this.setOpaque(true);
        this.setVisible(true);
    }

    public Scene getScene(){
        return s;
    }
}
