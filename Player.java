import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameCharacter implements KeyListener {

    final int xVelocity = 1; // Serena for scaling values

    public Player(Scene scene, int movingSpeed, int jumpingSpeed) {
        super(scene, movingSpeed, jumpingSpeed);
    }

    @Override
    public void collideReaction(Collidable other, int from) {

    }

    @Override
    void loseHealth() {

    }

    @Override
    void die() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                move(LEFT);
                break;
            case KeyEvent.VK_D:
                move(RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                jump();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                stop(LEFT);
                break;
            case KeyEvent.VK_D:
                stop(RIGHT);
                break;
        }
    }


}


// Li An for KeyListener