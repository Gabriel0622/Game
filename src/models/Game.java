package models;

import java.util.ArrayList;
import java.util.Random;

public class Game extends Thread implements IGame{

    private static final int MAX_ENEMIES = 10;
    public static final int MAP_SIZE = 700;
    private static final Random randomGenerator = new Random();
    private final Hero hero;
    private final ArrayList<Enemy> enemies;
    private boolean play;

    public Game() {
        hero = new Hero(randomGenerator.nextInt(MAP_SIZE - Hero.SIZE));
        enemies = new ArrayList<>();
        play = true;
        start();
    }

    @Override
    public void run() {
        while (play){
            if(enemies.size() < MAX_ENEMIES){
                createEnemy();
            }
            enemies.removeIf(Enemy::descend);
            checkCollisions();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkCollisions() {
        for (Enemy enemy : enemies) {
            if(hero.checkCollision(enemy)){
                hero.reduceHealth();
                enemy.disableAttack();
                if(hero.isDead()){
                    play = false;
                    break;
                }
            }
        }
    }

    private void createEnemy() {
        enemies.add(new Enemy(randomGenerator.nextInt(MAP_SIZE - Hero.SIZE)));
    }

    public void moveHeroLeft(){
        hero.moveLeft();
    }

    public void moveHeroRight(){
        hero.moveRight();
    }

    @Override
    public int getPosition() {
        return hero.getX();
    }

    @Override
    public Enemy[] getEnemies() {
        return enemies.toArray(new Enemy[0]);
    }

    @Override
    public int getHeroHealth() {
        return hero.getHealth();
    }
}
