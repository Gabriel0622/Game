package models;

public class Enemy {

    public static final int SIZE = 30;
    private static final int INITIAL_Y = 10;
    private static final int MOVE = 5;
    private int x;
    private int y;
    private boolean isAttack;

    public Enemy(int x){
        this.x = x;
        this.y = INITIAL_Y;
        isAttack = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean descend(){
        y += MOVE;
        return y >= Game.MAP_SIZE;
    }

    public void disableAttack(){
        isAttack = false;
    }

    public boolean isAttack() {
        return isAttack;
    }
}
