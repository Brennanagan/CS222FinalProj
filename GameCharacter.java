import java.awt.*;

public abstract class GameCharacter extends GameElement implements Collidable{
    private int[] velocity;
    private int facing;
    private boolean onGround;
    private boolean[] moving;
    private int movingSpeed;
    private int jumpingSpeed;
    private boolean enabled;

    private int health;


    /**
     * Time between two frames
     */
    public static final int period = 20;

    public static final int LEFT = -1;
    public static final int RIGHT = 1;

    public static final int G = 3;

    public GameCharacter(Scene scene, int movingSpeed, int jumpingSpeed){
        super(scene);
        velocity = new int[2];
        moving = new boolean[2];
        this.movingSpeed = movingSpeed;
        this.jumpingSpeed = jumpingSpeed;

    }

    private int getFacing(){
        return facing;
    }

    private void setFacing(int facing){
        if (this.facing != facing) {
            stop(this.facing);
            this.facing = facing;
            if (facing == LEFT) {
                //flip the Icon to facing left
                moving[1] = false;
            } else {
                //flip the Icon to facing right
                moving[0] = false;
            }
        }
    }

    @Override
    public boolean isEnabled(){
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
        if (enabled){
            start();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private void start(){
        new Thread(){
            public void run(){
                while (enabled){
                    move();
                    try {
                        sleep(period);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private void move(){
        Collidable xHit = checkXHit();
        Collidable yHit = checkYHit();
        if (xHit != null){
            if (velocity[0] > 0){
                setLocation(xHit.getX() - getWidth(), getY());
            }
            else {
                setLocation(xHit.getX() + xHit.getWidth(), getY());
            }
            xHit.collideReaction(this, SIDE);
        }
        else {
            setLocation(getX() + velocity[0], getY());
        }
        if (yHit != null){
            if (velocity[1] > 0){
                setLocation(getX(), yHit.getY() + yHit.getHeight());
                yHit.collideReaction(this, Collidable.BOTTOM);
            }
            else {
                setLocation(getX(), yHit.getY() - getHeight());
                yHit.collideReaction(this, Collidable.TOP);
            }
        }
        else {
            setLocation(getX(), getY() - velocity[1]);
        }
        onGround = yHit != null;
        updateVelocity();
    }

    private Collidable checkXHit(){
        int dx = velocity[0];
        int targetX;
        Collidable hit = null;
        if (dx != 0) {
            if (dx > 0) {
                targetX = getX() + getWidth() + dx;
            }
            else{
                targetX = getX() + dx;
            }
            for (int y = getY(); y < getY() + getHeight(); y++) {
                Component h = getScene().getComponentAt(targetX, y);
                if (h instanceof Collidable) {
                    hit = (Collidable) h;
                }
            }
        }
        return hit;
    }

    private Collidable checkYHit(){
        int dy = velocity[1];
        Collidable hit = null;
        int targetY;
        if (dy > 0) {
            targetY = getY() - dy;
        }
        else{
            targetY = getY() + getHeight() - dy;
        }
        for (int x = getX(); x < getX() + getWidth(); x++) {
            Component h = getScene().getComponentAt(x, targetY);

            if (h instanceof Collidable) {
                hit = (Collidable) h;
            }
        }
        return hit;
    }

    public void move(int facing){
        setFacing(facing);
        moving[facing == -1? 0: facing] = true;
    }

    public void stop(int facing){
        moving[facing == -1? 0: facing] = false;
    }

    public void jump(){
        if (onGround){
            velocity[1] = jumpingSpeed;
        }
    }

    public void updateVelocity(){
        if (moving[0] || moving[1]) {
            velocity[0] = facing * movingSpeed;
        }
        else {
            velocity[0] = 0;
        }
        if (!onGround){
            fall();
        }
        else {
            velocity[1] = 0;
        }
    }

    public void fall(){
        velocity[1] -= G;
    }

    public void loseHealth(int damage){
        health -= damage;
        if (health <= 0){
            die();
        }
    }

    public abstract void die();
}
