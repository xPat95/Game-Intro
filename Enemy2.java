import greenfoot.*;

public class Enemy2 extends Enemy {
    private int speed = 3;

    public Enemy2() {
        super(6);  // Número de vidas inicial para Enemy2
    }

    public void act() {
        followHero();
        checkCollisionWithHero(); // Añadir la detección de colisión
    }

    public void followHero() {
        Actor heroe = (Heroe) getWorld().getObjects(Heroe.class).get(0);
        if (heroe != null) {
            turnTowards(heroe.getX(), heroe.getY());
            move(speed);
        }
    }

    @Override
    protected void onDeath(World world) {
        // Implementar comportamiento en caso de muerte si es necesario
    }
}
