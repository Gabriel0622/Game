package presenters;

import models.Game;
import views.WindowGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Presenter implements ActionListener, KeyListener {

    private final Game game;
    private WindowGame window;

    public Presenter() {
        this.game = new Game();
        try {
            this.window = new WindowGame(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateUi();
    }

    private void updateUi() {
        final Timer timerUpdateEnemies = new Timer(1, e -> {
            if(game.getHeroHealth() <= 0){
                JOptionPane.showMessageDialog(window, "Game over", "Mario", JOptionPane.ERROR_MESSAGE);
                ((Timer)e.getSource()).stop();
            }else{
                window.refreshGame(game);
            }
        });
        timerUpdateEnemies.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getExtendedKeyCode();
        switch (code) {
            case KeyEvent.VK_LEFT -> game.moveHeroLeft();
            case KeyEvent.VK_RIGHT -> game.moveHeroRight();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }
}
