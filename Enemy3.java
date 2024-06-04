import greenfoot.*;
import java.util.Random;

public class Enemy3 extends Enemy {
    private int speed = 2;
    private int directionChangeInterval = 50; // Cambiar de dirección cada 50 actos
    private int actCounter = 0;
    private Random random = new Random();
    
    public Enemy3() {
        super(6);  // Número de vidas inicial para Enemy3
    }

    public void act() {
        moveInZigzag();
        checkCollisionWithHero(); // Añadir la detección de colisión
    }

    private void moveInZigzag() {
        actCounter++;
        if (actCounter >= directionChangeInterval) {
            int angle = random.nextInt(120) - 60; // Cambiar dirección en un ángulo aleatorio entre -60 y 60 grados
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
