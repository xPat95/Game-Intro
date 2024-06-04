import greenfoot.*;

public abstract class Enemy extends Actor {
    protected int lifes;

    public Enemy(int initialLifes) {
        this.lifes = initialLifes;
    }

    public void decreaseLife() {
        lifes--;
        System.out.println("Enemy lives: " + lifes); // Mensaje de depuración
        if (lifes <= 0) {
            die();
        }
    }

    public void die() {
        System.out.println("Enemy is dying"); // Mensaje de depuración
        World world = getWorld(); // Obtener referencia al mundo antes de eliminar el objeto
        if (world != null) {
            onDeath(world); // Pasar la referencia del mundo a onDeath
            world.removeObject(this); // Eliminar el objeto después de llamar onDeath
        }
    }

    protected abstract void onDeath(World world); // Cambiar firma para aceptar la referencia del mundo

    protected void checkCollisionWithHero() {
        Actor heroe = getOneObjectAtOffset(0, 0, Heroe.class);
        if (heroe != null) {
            World world = getWorld();
            if (world != null) {
                world.removeObject(heroe);
                System.out.println("Hero killed by " + getClass().getSimpleName());
            }
        }
    }
}
