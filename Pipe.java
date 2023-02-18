import java.awt.*;

public class Pipe extends Block{

    boolean usable; //true = able to transport, false = act like wall block

    public Pipe(Scene s, boolean usable) {
        super(s);
        this.usable = usable;
        this.setBackground(Color.green);
        setOpaque(true);
    }

    @Override
    public void collideReaction(Collidable other, int from) {
        if (usable && from == SIDE)
        {
            s.makeNextScene();
        }
        else
        {
            // Do not change scene due to wrong side interaction or not a usable pipe
        }
    }
}
