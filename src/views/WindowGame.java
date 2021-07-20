package views;

import models.Game;
import models.IGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Objects;

public class WindowGame extends JFrame {

    public static final String TITLE = "Game";
    private final PanelGame panelGame;

    public WindowGame(KeyListener listener) throws IOException {
        setSize(Game.MAP_SIZE, Game.MAP_SIZE);
        setTitle(TITLE);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/icon.png"))).getImage());

        panelGame = new PanelGame(listener);
        add(panelGame, BorderLayout.CENTER);

        setVisible(true);
        panelGame.init();
    }

    public void refreshGame(IGame gameData) {
        panelGame.updateGame(gameData);
    }
}
