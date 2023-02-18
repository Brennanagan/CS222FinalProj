public interface Collidable {
    int TOP = 0;
    int BOTTOM = 1;
    int SIDE = 2;
    void collideReaction(Collidable other, int from);

    int getX();
    int getY();
    int getWidth();
    int getHeight();
}