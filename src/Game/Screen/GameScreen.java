package Game.Screen;

import Engine.UI.Screen;
import Game.Core.ClockTimer;
import Game.Core.Maze;
import Game.Entity.Knight;
import Game.Entity.Player;
import Game.Utility.CoordinatePair;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameScreen extends Screen implements KeyListener {
    private final int currentMapNumber;
    private final String characterName;
    private final double moveWeight = 9.5f;
    private Maze currentMaze;
    private Image wallImg, keyImg, extractionImg;
    private Player player;
    private volatile boolean loseShown = false, wonShow = false;
    // position index in path tracing.
    // will be reset if the player moves, and increments when the player stands still.
    // to balance the game, an (moveWeight)-stay:(10-mW)-move weightage will be applied.
    // more details in the usage of this code.
    private int listIndex;
    private ArrayList<CoordinatePair> path;

    public GameScreen(String character, int mapNumber) {
        this.currentMapNumber = mapNumber;
        this.characterName = character.toLowerCase();

        // first map? start timer
        if (mapNumber == 0) ClockTimer.start();
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
                    wonShow = true;
                    this.getRenderer().cancel();
                    ClockTimer.stop();
                    this.getParentWindow().replaceCurrentScreenWith(new WinScreen());
                }
            }
        }

        g2d.drawImage(
                this.player.getAnimImg(),
                10 + player.getX() * 28,
                10 + player.getY() * 28,
                this
        );

        this.listIndex = this.player.isHasMoved() ? 0 : this.listIndex + 1;
        double randomFactor = new Random().nextDouble(1, 10 + 1);

        for (Knight knight : maze.getKnightList()) {
            if (path != null) {
                if (randomFactor <= this.moveWeight) {
                    path = maze.findPath(knight, player);
                }
            } else
                path = maze.findPath(knight, player);

            CoordinatePair coordinate;

            this.listIndex %= path.size();

            if (randomFactor <= this.moveWeight) this.listIndex = 0;

            coordinate = path.get(this.listIndex);

            knight.moveTo(coordinate.getX(), coordinate.getY());

            g2d.drawImage(
                    knight.getAnimImg(),
                    10 + coordinate.getX() * 28,
                    10 + coordinate.getY() * 28,
                    this
            );

            if (this.player.isCollideWith(knight)) {
                if (!loseShown) {
                    loseShown = true;
                    this.getRenderer().cancel();
                    this.getParentWindow().replaceCurrentScreenWith(new LoseScreen());
                }
            }
        }
    }

    private boolean hasNextMap() {
        File f = new File("resources/Map/map" + (this.currentMapNumber + 1) + ".txt");
        return !f.isDirectory() && f.exists();
    }

    @Override
    public void init() {
        try {
            this.wallImg = ImageIO.read(Files.newInputStream(Paths.get("resources/Playground/wall.png")));
            this.keyImg = ImageIO.read(Files.newInputStream(Paths.get("resources/Playground/key.png")));
            this.extractionImg = ImageIO.read(Files.newInputStream(Paths.get("resources/Playground/extraction.png")));
        } catch (IOException e) {
            //
        }

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
        this.player.setMaze(this.currentMaze);

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
