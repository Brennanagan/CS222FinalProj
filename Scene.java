import javax.swing.*;
import java.util.ArrayList;

public class Scene extends JPanel {
    private ArrayList<GameElement> elements;
    Player player;

    public Scene(){
        elements = new ArrayList<GameElement>();
    }

    public void add(GameElement ge){
        super.add(ge);
        elements.add(ge);
    }



}
