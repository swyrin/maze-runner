/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Main game screen - with some keybindings.
*/

package Game.Screen;

import Engine.Helper.StringHelper;
import Engine.UI.Screen;
import Game.Core.ClockTimer;
import Game.Core.Maze;
import Game.Entity.Knight;
import Game.Entity.Player;
import Game.Utility.CoordinatePair;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameScreen extends Screen implements KeyListener {
    private final int currentMapNumber;
    private final String characterName;
    private Maze currentMaze;
    private Image wallImg, keyImg, extractionImg;
    private Player player;
    private HashMap<Knight, ArrayList<CoordinatePair>> pathList;
    private boolean shouldDrawKnightPath = false;
    private boolean knightShouldMoveOnce = false;

    public GameScreen(String character, int mapNumber) {
        this.currentMapNumber = mapNumber;
        this.characterName = character.toLowerCase();

        // first map?
        if (mapNumber == 0) ClockTimer.start();
    }

    public GameScreen(String character) {
        this(character, 0);
    }

    @Override
    public void render(Graphics2D g2d) {
        Maze maze = this.currentMaze;

        // time & fps draw.
        g2d.setColor(Color.yellow);
        g2d.drawString("Time: " + StringHelper.formatDuration(ClockTimer.getElapsedTime()), 10, 555);
        g2d.drawString("FPS: " + (int) this.fpsMeasure.getFps(), 640, 555);
        g2d.setColor(Color.gray); // reset
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
        double col = this.player.getPostPendingX();
        double row = this.player.getPostPendingY();

        if (0 <= row && row < maze.getHeight() && 0 <= col && col < maze.getWidth()) {
            int cell = map[(int) row][(int) col];

            // if we are stepping on the extraction point, just move and offload the processing to the underneath block.
            // else, perform a wall check.
            if (cell != Maze.EXTRACTION_CONST)
                if (cell != Maze.WALL_CONST) {
                    this.player.move();
                } else {
                    this.player.revokePending();
                }
            else {
                this.player.move();
            }
        }
        // ======================================
        // anything requires use of player position (i.e. item gather) goes below this

        g2d.drawImage(
                this.player.getAnimImg(),
                (int) (10 + player.getX() * 28),
                (int) (10 + player.getY() * 28),
                this
        );

        int playerCol = (int) this.player.getX();
        int playerRow = (int) this.player.getY();

        if (map[playerRow][playerCol] == Maze.KEY_CONST) {
            maze.removeKey();
            map[playerRow][playerCol] = Maze.PATH_CONST;
        }

        if (map[playerRow][playerCol] == Maze.EXTRACTION_CONST && maze.getKeyCount() == 0) {
            if (this.hasNextMap()) {
                this.getParentWindow().replaceCurrentScreenWith(
                        new GameScreen(this.characterName, this.currentMapNumber + 1)
                );
            } else {
                this.getRenderer().cancel();
                ClockTimer.stop();
                this.getParentWindow().replaceCurrentScreenWith(new WinScreen());
            }
        }

        for (Knight knight : maze.getKnightList()) {
            ArrayList<CoordinatePair> path = maze.findPath(knight, this.player);

            if (path == null) continue;

            // new path, we add.
            if (this.pathList.get(knight) == null) {
                this.pathList.put(knight, path);
            } else {
                ArrayList<CoordinatePair> storedPath = this.pathList.get(knight);

                // if not same path, we reset.
                if (!storedPath.equals(path)) {
                    pathList.put(knight, path);
                }
            }

            g2d.drawImage(
                    knight.getAnimImg(),
                    (int) (10 + knight.getX() * 28),
                    (int) (10 + knight.getY() * 28),
                    this
            );

            if (shouldDrawKnightPath) {
                ArrayList<CoordinatePair> clone = pathList.get(knight);

                // the final position of the path is the player's position.
                // we don't want to draw over the player.
                clone.removeLast();

                for (CoordinatePair pair : pathList.get(knight)) {
                    g2d.drawImage(
                            knight.getAnimImg(),
                            (10 + pair.getX() * 28),
                            (10 + pair.getY() * 28),
                            this
                    );
                }
            }

            if (knightShouldMoveOnce) {
                CoordinatePair pair = pathList.get(knight).get(0);

                knight.moveTo(pair.getX(), pair.getY());

                g2d.drawImage(
                        knight.getAnimImg(),
                        (int) (10 + knight.getX() * 28),
                        (int) (10 + knight.getY() * 28),
                        this
                );

                knightShouldMoveOnce = false;
            }
        }

        for (Knight knight : this.currentMaze.getKnightList()) {
            if (this.player.isCollideWith(knight)) {
                ClockTimer.stop();
                this.getRenderer().cancel();
                this.getParentWindow().replaceCurrentScreenWith(new LoseScreen());

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
        this.getParentWindow().setSize(705, 600);

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
        this.player.setScreen(this);

        for (Knight k : this.currentMaze.getKnightList()) k.setScreen(this);

        this.pathList = new HashMap<>();

        // Java task scheduling is wonky, so I decided to create a timer for this.
        // ==========================
        javax.swing.Timer knightDrawTimer = getKnightDrawTimer(650);
        knightDrawTimer.start();
        // ==========================
        this.addKeyListener(this.player);
        this.addKeyListener(this);
    }

    private javax.swing.Timer getKnightDrawTimer(int delay) {
        ActionListener knightDraw = x -> {
            for (Knight k : this.currentMaze.getKnightList()) {
                ArrayList<CoordinatePair> path = this.pathList.get(k);
                if (path.isEmpty()) continue;

                CoordinatePair next = path.get(0);

                k.moveTo(next.getX(), next.getY());
            }
        };
        return new javax.swing.Timer(delay, knightDraw);
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            ClockTimer.stop();
            this.getParentWindow().replaceCurrentScreenWith(new MainScreen());
        }

        if (e.getKeyCode() == (KeyEvent.VK_ALT | KeyEvent.VK_F4)) {
            this.getParentWindow().exit();
        }

        if (e.getKeyCode() == KeyEvent.VK_E) {
            this.shouldDrawKnightPath = !this.shouldDrawKnightPath;
        }

        if (e.getKeyCode() == KeyEvent.VK_C) {
            this.knightShouldMoveOnce = !this.knightShouldMoveOnce;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
