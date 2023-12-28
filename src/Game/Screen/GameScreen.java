package Game.Screen;

import Engine.UI.Screen;
import Game.Entity.Knight;
import Game.Entity.Maze;
import Game.Entity.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class GameScreen extends Screen implements KeyListener {
    private final int currentMapNumber;
    private Maze currentMaze;
    private Image wallImg, keyImg, extractionImg;
    private Player player;
    private final String characterName;
    private volatile boolean loseShown = false, wonShow = false;

    public GameScreen(String character, int mapNumber) {
        this.currentMapNumber = mapNumber;
        this.characterName = character.toLowerCase();

        try {
            this.wallImg = ImageIO.read(Files.newInputStream(Paths.get("resources/Playground/wall.png")));
            this.keyImg = ImageIO.read(Files.newInputStream(Paths.get("resources/Playground/key.png")));
            this.extractionImg = ImageIO.read(Files.newInputStream(Paths.get("resources/Playground/extraction.png")));
        } catch (IOException e) {
            //
        }
    }

    public GameScreen(String character) {
        this(character, 0);
    }

    @Override
    public void render(Graphics2D g2d) {
        Maze maze = this.currentMaze;

        int[][] map = maze.getMazeMatrix();

        // draw maze stuffs (maze itself, enemy, keys)
        for (int i = 0; i < maze.getHeight(); i++)
            for (int j = 0; j < maze.getWidth(); j++) {
                if (map[i][j] == Maze.WALL_CONST) {
                    g2d.drawImage(this.wallImg, 10 + j * 28, 10 + i * 28, null);
                }

                if (map[i][j] == Maze.KEY_CONST) {
                    g2d.drawImage(this.keyImg, 10 + j * 28, 10 + i * 28, null);
                }

                if (map[i][j] == Maze.EXTRACTION_CONST) {
                    g2d.drawImage(this.extractionImg, 10 + j * 28, 10 + i * 28, null);
                }
            }

        // anything not relating to player movements (i.e. drawing) goes above this
        // ======================================
        int col = this.player.getPostPendingX();
        int row = this.player.getPostPendingY();

        // I don't get how the addition of the next if prevent the console from flooding errors
        // but since it works, it's ok.
        if (0 <= row && row < maze.getHeight() && 0 <= col && col < maze.getWidth())
            if (map[row][col] != Maze.WALL_CONST) {
                this.player.move();
            } else {
                this.player.revokePending();
            }
        // ======================================
        // anything requires use of player movements (i.e. item gather) goes below this

        col = this.player.getX();
        row = this.player.getY();

        if (map[row][col] == Maze.KEY_CONST) {
            maze.removeKey();
            map[row][col] = Maze.PATH_CONST;
        }

        if (map[row][col] == Maze.EXTRACTION_CONST && maze.getKeyCount() == 0) {
            if (this.hasNextMap()) {
                this.getParentWindow().replaceCurrentScreenWith(new GameScreen(this.characterName, this.currentMapNumber + 1));
            } else {
                this.getRenderer().cancel();
                if (!wonShow) {
                    JOptionPane.showMessageDialog(null, "You won");
                    wonShow = true;
                }
                this.getParentWindow().replaceCurrentScreenWith(new MainScreen());
            }
        }

        g2d.drawImage(
                this.player.getAnimImg(),
                10 + player.getX() * 28,
                10 + player.getY() * 28,
                null
        );

        for (Knight knight: maze.getKnightList()) {
            knight.addX(new Random().nextInt(-1, 2));
            knight.addY(new Random().nextInt(-1, 2));

            int kcol = knight.getPostPendingX();
            int krow = knight.getPostPendingY();

            if (0 <= krow && krow < maze.getHeight() && 0 <= kcol && kcol < maze.getWidth())
                if (map[krow][kcol] != Maze.WALL_CONST
                        && map[krow][kcol] != Maze.KEY_CONST
                        && map[krow][kcol] != Maze.EXTRACTION_CONST
                ) {
                    knight.move();
                } else {
                    knight.revokePending();
                    continue;
                }

            g2d.drawImage(
                    knight.getAnimImg(),
                    10 + knight.getX() * 28,
                    10 + knight.getY() * 28,
                    null
            );

            if (this.player.isCollideWith(knight)) {
                this.getRenderer().cancel();
                if (!loseShown) {
                    JOptionPane.showMessageDialog(null, "You lose");
                    loseShown = true;
                }
                this.getParentWindow().replaceCurrentScreenWith(new MainScreen());
            }
        }
    }

    private boolean hasNextMap() {
        File f = new File("resources/Map/map" + (this.currentMapNumber + 1) + ".txt");
        return !f.isDirectory() && f.exists();
    }

    @Override
    public void init() {
        this.setBackground(Color.black);
        this.getParentWindow().setSize(720, 600);

        String mapStr = "";

        // process map file to string.
        try {
            Scanner scn = new Scanner(Files.newInputStream(Paths.get("resources/Map/map" + this.currentMapNumber + ".txt")));
            StringBuilder sb = new StringBuilder();
            String line;
            while (scn.hasNextLine()) {
                line = scn.nextLine();
                sb.append(line).append('\n');
            }
            mapStr = sb.toString();
        } catch (Exception e) {
            System.err.println("Error Reading Map File !");
        }
        if (mapStr.isEmpty()) {
            System.err.println("Map is Empty !");
        }

        this.currentMaze = Maze.setupFromString(mapStr);
        this.player = new Player(this.currentMaze.getPlayerStartX(), this.currentMaze.getPlayerStartY(), this.characterName);

        this.player.setAnimType("idle");
        this.player.resetAnimCounter();

        this.addKeyListener(this.player);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            this.getParentWindow().replaceCurrentScreenWith(new MainScreen());
        }

        if (e.getKeyCode() == (KeyEvent.VK_ALT | KeyEvent.VK_F4)) {
            this.getParentWindow().exit();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
