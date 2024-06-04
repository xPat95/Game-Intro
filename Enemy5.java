import greenfoot.*;

public class Enemy5 extends Enemy {

    public Enemy5() {
        super(20);  // Número de vidas inicial para Enemy5
    }

    public void act() {
        moveAndTurn();
        eat();
    }

    public void moveAndTurn() {
        Actor heroe = (Heroe) getWorld().getObjects(Heroe.class).get(0);
        turnTowards(heroe.getX(), heroe.getY());
        move(3);
    }

    public void eat() {
        Actor heroe = getOneObjectAtOffset(0, 0, Heroe.class);
        if (heroe != null) {
            World world = getWorld();
            world.removeObject(heroe);
        }
    }

    @Override
    protected void onDeath(World world) {
        // Implementar comportamiento en caso de muerte si es necesario
    }
}