package views;

import models.Enemy;
import models.Hero;
import models.IGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class PanelGame extends JPanel {

    public BufferedImage background;
    private final Image imgBack;
    private final Image imgHero;
    private final Image imgEnemy;
    private final Image imgHeart;

    public PanelGame(KeyListener listener) {
        imgBack = new ImageIcon(Objects.requireNonNull(getClass().getResource("/background.png"))).getImage();
        imgHero = new ImageIcon(Objects.requireNonNull(getClass().getResource("/hero.png"))).getImage();
        imgEnemy = new ImageIcon(Objects.requireNonNull(getClass().getResource("/enemy.png"))).getImage();
        imgHeart = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Heart.png"))).getImage();
        addKeyListener(listener);
    }

    public void init(){
        paintBackground();
        requestFocus();
        requestFocusInWindow();
    }

    public void updateGame(IGame gameData){
        paintBackground();
        paintHero(gameData);
        paintEnemies(gameData);
        repaint();
    }

    private void paintBackground() {
        if(background == null) {
            background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }
        Graphics g = background.getGraphics();
        g.drawImage(imgBack, 0,0, getWidth(), getHeight(), this);
    }

    public void paintHero(IGame gameData){
        Graphics g = background.getGraphics();
        g.drawImage(imgHero, gameData.getPosition(), Hero.Y, Hero.SIZE, Hero.SIZE, this);
        for (int i = 0; i < gameData.getHeroHealth() / 10; i++) {
            g.drawImage(imgHeart, 400 + (i * 25), 50, 20, 20, this);
        }
    }

    public void paintEnemies(IGame gameData){
        Graphics g = background.getGraphics();
        g.setColor(Color.GREEN);
        for (Enemy enemy : gameData.getEnemies()) {
            g.drawImage(imgEnemy, enemy.getX(), enemy.getY(), Enemy.SIZE, Enemy.SIZE, this);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, this);
    }
}
