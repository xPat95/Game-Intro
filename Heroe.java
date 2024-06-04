import greenfoot.*;

public class Heroe extends Actor {
    private boolean isShooting;

    public void act() {
        moveAndTurn();
        shoot();
    }

    public void moveAndTurn() {
        if (Greenfoot.isKeyDown("up")) {
            this.turnTowards(this.getX(), 0);
            this.move(5);
        }
        if (Greenfoot.isKeyDown("down")) {
            this.turnTowards(this.getX(), 340);
            this.move(5);
        }
        if (Greenfoot.isKeyDown("left")) { 
            this.turnTowards(0, this.getY());
            this.move(5);
        }
        if (Greenfoot.isKeyDown("right")) { 
            this.turnTowards(540, this.getY());
            this.move(5);
        }
    }

    public void shoot() {
        if (Greenfoot.isKeyDown("space") && !isShooting) {
            isShooting = true; 
            World world = getWorld();
            Projectile projectile = new Projectile(); 
            world.addObject(projectile, this.getX(), this.getY());
            projectile.setRotation(this.getRotation());
        } else if (!Greenfoot.isKeyDown("space")) {
            isShooting = false;
        }
    }
}
