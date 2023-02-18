import javax.swing.*;
import java.awt.*;

public class Block extends GameElement implements Collidable{
    public Block(Scene s) {
        super(s);
    }

    public void setIcon()
    {
        this.setIcon(new ImageIcon()); // get scaled Q Block from Serena
    }

    @Override
    public void collideReaction(Collidable other, int from) {
        /// ASK Li An how to implement
    }
}
