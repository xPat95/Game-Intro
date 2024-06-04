import greenfoot.*;

public class Projectile extends Actor {
    public void act() {
        move(4);
        hitpoints();
    }

    public void hitpoints() {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            System.out.println("Projectile hit enemy"); // Mensaje de depuración
            ((Enemy) enemy).decreaseLife();
            getWorld().removeObject(this);
        } else if (this.isAtEdge()) {
            getWorld().removeObject(this);           
        }  
    }
}
