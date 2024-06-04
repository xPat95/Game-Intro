import greenfoot.*;
import java.util.Random;

public class Enemy3 extends Enemy {
    private int speed = 2;
    private int directionChangeInterval = 50; // Cambiar de direcci�n cada 50 actos
    private int actCounter = 0;
    private Random random = new Random();
    
    public Enemy3() {
        super(6);  // N�mero de vidas inicial para Enemy3
    }

    public void act() {
        moveInZigzag();
        checkCollisionWithHero(); // A�adir la detecci�n de colisi�n
    }

    private void moveInZigzag() {
        actCounter++;
        if (actCounter >= directionChangeInterval) {
            int angle = random.nextInt(120) - 60; // Cambiar direcci�n en un �ngulo aleatorio entre -60 y 60 grados
            turn(angle);
            actCounter = 0;
        }
        move(speed);
        if (isAtEdge()) {
            turn(180); // Girar 180 grados al llegar al borde
            move(5); // Alejarse un poco del borde
        }
    }

    @Override
    protected void onDeath(World world) {
        // Implementar comportamiento en caso de muerte si es necesario
    }
}
