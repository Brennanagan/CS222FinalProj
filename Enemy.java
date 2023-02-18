public class Enemy extends GameCharacter{

    final int xVelocity = 1; // figure out based on Serena's scaling

    public Enemy(Scene scene, int movingSpeed, int jumpingSpeed) {
        super(scene, movingSpeed, jumpingSpeed);
    }

    public void collideReaction(Collidable other, int from) {

    }

    @Override
    void loseHealth() {

    }

    @Override
    void die() {

    }
}
