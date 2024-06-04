import greenfoot.*;

public class MyWorld extends World {
    private boolean enemy5Spawned = false;

    public MyWorld() {    
        super(600, 400, 1); 
        setBackground("Coliseo.jpg"); // Asegúrate de que la imagen esté en el directorio de imágenes del proyecto
        addInitialEnemies();
        prepare();
    }

    private void addInitialEnemies() {
        addObject(new Enemy1(), 100, 200); // Añadir Enemy1 al inicio
    }

    public void act() {
        checkAndSpawnEnemy5();
    }

    private void checkAndSpawnEnemy5() {
        if (!enemy5Spawned && 
        getObjects(Enemy1.class).isEmpty() && 
        getObjects(Enemy2.class).isEmpty() && 
        getObjects(Enemy3.class).isEmpty() && 
        getObjects(Enemy4.class).isEmpty()) {
            System.out.println("Spawning Enemy5");
            spawnEnemy5();
            enemy5Spawned = true;
        } else {
            System.out.println("Enemy1, Enemy2, Enemy3, or Enemy4 still exist");
        }
    }

    private void spawnEnemy5() {
        int spawnX = getWidth() / 2;  // Puedes ajustar la posición de spawn
        int spawnY = getHeight() / 2;
        addObject(new Enemy5(), spawnX, spawnY);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Heroe heroe = new Heroe();
        addObject(heroe,427,216);
        heroe.setLocation(504,237);
        heroe.setLocation(87,260);
        heroe.setLocation(71,225);
        heroe.setLocation(485,224);
        heroe.setLocation(103,250);
        heroe.setLocation(119,277);
        heroe.setLocation(98,280);
        heroe.setLocation(456,240);
        heroe.setLocation(517,318);
        heroe.setLocation(514,211);
    }
}
