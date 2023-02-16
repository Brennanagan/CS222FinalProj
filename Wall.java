public class Wall extends Block implements Collidable{
    public Wall(Scene s) {
        super(s);
    }

    @Override
    public void collideReaction(Collidable other, int from) {
        if (from == SIDE) {
            System.out.println("hi, I'm collided from side!");
        }
        else if (from == Collidable.TOP){
            System.out.println(("Someone is standing on me"));
        }
    }
}
