import javax.swing.*;
import java.awt.*;

public class QuestionBlock extends Block{
    boolean disabled;

    public QuestionBlock(Scene s) {
        super(s);
        disabled = false;
        this.setBackground(Color.yellow);
        setOpaque(true);
    }

    @Override
    public void collideReaction(Collidable other, int from) {
        if (from == Collidable.BOTTOM)
        {
            System.out.println("Ahhh");
            disabled = true;
            setBackground(Color.green);
//            setIcon(new ImageIcon()); // used q block from Serena
        }
    }

    //inherits setIcon from Block
}
