import java.awt.*;

public class Brick extends Block{


    public Brick(Scene s) {
        super(s);
        this.setBackground(Color.red);
        setOpaque(true);
    }
    // inherits setIcon from Block


    @Override
    public void collideReaction(Collidable other, int from) {
        if (from ==Collidable.BOTTOM)
        {
            s.remove(this);
        }
    }
}
