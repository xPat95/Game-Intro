import greenfoot.*;

public class Enemy1 extends Enemy {

    public Enemy1() {
        super(10);  // Número de vidas inicial para Enemy1
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
        System.out.println("Enemy1 is dying and spawning Enemy2, Enemy3, and Enemy4");
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int spawnX = worldWidth - 1;  // esquina superior derecha
        int spawnY = 1;

        world.addObject(new Enemy2(), spawnX, spawnY);
        System.out.println("Spawned Enemy2");
        world.addObject(new Enemy3(), spawnX, spawnY);
        System.out.println("Spawned Enemy3");
        world.addObject(new Enemy4(), spawnX, spawnY);
        System.out.println("Spawned Enemy4");
    }
}