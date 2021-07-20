package models;

import java.awt.*;

public class Hero{

    private int x;
    private int health;
    public static final int Y = 600;
    public static final int SIZE = 50;
    public static final int MOVE_SIZE = 5;
    public static final int MAX_HEALTH = 100;
    public static final int REDUCE_HEALTH = 10;

    public Hero(int x) {
        this.x = x;
        this.health = MAX_HEALTH;
    }

    public void moveLeft() {
        if(x - MOVE_SIZE > 0){
            x -= MOVE_SIZE;
        }
    }

    public void moveRight() {
        if(x + (SIZE) + (MOVE_SIZE * 4) < Game.MAP_SIZE){
            x += MOVE_SIZE;
        }
    }

    public boolean checkCollision(Enemy enemy){
        Rectangle heroRec = new Rectangle(x, Y, SIZE, SIZE);
        return heroRec.intersects(new Rectangle(enemy.getX(), enemy.getY(), Enemy.SIZE, Enemy.SIZE)) && enemy.isAttack();
    }

    public void reduceHealth(){
        this.health -= REDUCE_HEALTH;
    }

    public int getHealth() {
        return health;
    }

    public int getX() {
        return this.x;
    }

    public boolean isDead(){
        return health <= 0;
    }
}
