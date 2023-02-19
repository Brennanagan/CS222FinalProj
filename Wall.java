import javax.swing.*;
import java.awt.*;

public class Wall extends Block{
    int type; // 1 = ground, 2 = elevation block

    public Wall(Scene s, int type) {   // add type
        super(s);
        this.type = type;
        setIcon();
        setOpaque(true);
    }

    public void setIcon()
    {
        if (type == 1) {
            //this.setIcon(new ImageIcon()); // get scaled ground block from Serena
            setBackground(Color.PINK);
        } else if (type == 2) {
          //  this.setIcon(new ImageIcon()); // get scaled elevation block from Serena
            this.setBackground(Color.black);
        }
    }

    @Override
    public void collideReaction(Collidable other, int from) {

    }
}
