package Game.Core;

import Engine.Helper.StringHelper;
import Engine.Object.BaseEntity;
import Game.Entity.Knight;
import Game.Utility.CoordinatePair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static final char KEY_CHAR = 'K';
    public static final char KEY_CONST = 1;
    public static final char WALL_CHAR = 'W';
    public static final char WALL_CONST = 2;
    public static final char PATH_CHAR = ' ';
    public static final char PATH_CONST = 3;
    public static final char PLAYER_CHAR = 'P';
    public static final char EXTRACTION_CHAR = 'E';
    public static final char EXTRACTION_CONST = 4;
    public static final char ENEMY_CHAR = 'N';
    private final int width;
    private final int height;
    private final int[][] mazeMatrix;
    private final ArrayList<Knight> knightList;
    private int playerStartX, playerStartY;
    private int keyCount;

    public Maze(int width, int height) {
        this.mazeMatrix = new int[height][width];
        this.width = width;
        this.height = height;
        this.keyCount = 0;
        this.knightList = new ArrayList<>();
    }

    public static Maze setupFromString(String str) {
        int width = str.indexOf('\n');
        int height = StringHelper.countLines(str);

        Maze m = new Maze(width, height);
        int[][] mat = m.getMazeMatrix();

        int row = 0;
        int col = 0;

        for (char c : str.toCharArray()) {
            if (c == WALL_CHAR) {
                mat[row][col] = WALL_CONST;
            }

            if (c == EXTRACTION_CHAR) {
                mat[row][col] = EXTRACTION_CONST;
            }

            if (c == KEY_CHAR) {
                mat[row][col] = KEY_CONST;
                m.addKey();
            }

            if (c == PATH_CHAR) {
                mat[row][col] = PATH_CONST;
            }

            if (c == PLAYER_CHAR) {
                m.setPlayerStartX(col);
                m.setPlayerStartY(row);
                mat[row][col] = PATH_CONST;
            }

            if (c == ENEMY_CHAR) {
                Knight k = new Knight(col, row);
                m.getKnightList().add(k);
                mat[row][col] = PATH_CONST;
            }

            col++;
            if (c == '\n') {
                row++;
                col = 0;
            }
        }

        return m;
    }

    public int getPlayerStartX() {
        return playerStartX;
    }

    public void setPlayerStartX(int playerStartX) {
        this.playerStartX = playerStartX;
    }

    public int getPlayerStartY() {
        return playerStartY;
    }

    public void setPlayerStartY(int playerStartY) {
        this.playerStartY = playerStartY;
    }

    public int[][] getMazeMatrix() {
        return this.mazeMatrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addKey() {
        ++this.keyCount;
    }

    public void removeKey() {
        --this.keyCount;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public ArrayList<Knight> getKnightList() {
        return knightList;
    }

    /**
     * Find the path using a home-made A* implementation.
     * This is a deterministic algorithm by the way.
     *
     * @param fromX Starting x-position
     * @param fromY Starting y-position
     * @param toX   Target x-position
     * @param toY   Target y-position
     * @return A list consisting of coordinates.
     */
    public ArrayList<CoordinatePair> findPath(int fromX, int fromY, int toX, int toY) {
        Queue<CoordinatePair> openList = new LinkedList<>();
        boolean[][] isVisited = new boolean[getHeight()][getWidth()];

        openList.add(new CoordinatePair(fromX, fromY));
        isVisited[fromY][fromX] = true;

        // parent[i][j] = the location node before (j, i) is visited
        CoordinatePair[][] parent = new CoordinatePair[getHeight()][getWidth()];

        while (!openList.isEmpty()) {
            CoordinatePair coordinates = openList.poll();

            int currentX = coordinates.getX();
            int currentY = coordinates.getY();

            // we found the way.
            if (currentX == toX && currentY == toY) {
                int toVisitX = toX;
                int toVisitY = toY;
                ArrayList<CoordinatePair> result = new ArrayList<>();

                // add target
                result.add(new CoordinatePair(toX, toY));

                // trace
                while (parent[toVisitY][toVisitX] != null) {
                    CoordinatePair parentLocation = parent[toVisitY][toVisitX];

                    result.add(parentLocation);

                    toVisitX = parentLocation.getX();
                    toVisitY = parentLocation.getY();
                }

                // I hate java, there is no even result.reverse()
                Collections.reverse(result);

                // remove first position, since we are already there.
                result.remove(0);

                return result;
            }

            for (int dx = -1; dx <= 1; ++dx) {
                for (int dy = -1; dy <= 1; ++dy) {
                    if (dx == 0 && dy == 0) continue;

                    int todoX = currentX + dx;
                    int todoY = currentY + dy;

                    // if OOB, next.
                    if (!(0 <= todoX && todoX < this.getWidth() && 0 <= todoY && todoY < this.getHeight())) continue;

                    // if not a path, next.
                    if (mazeMatrix[todoY][todoX] != Maze.PATH_CONST) continue;

                    // if visited, next.
                    if (isVisited[todoY][todoX]) continue;

                    openList.add(new CoordinatePair(todoX, todoY));
                    isVisited[todoY][todoX] = true;
                    parent[todoY][todoX] = new CoordinatePair(currentX, currentY);
                }
            }
        }

        // impossible case, but still.
        return null;
    }

    /**
     * Find the path using a home-made A* implementation.
     * This is a deterministic algorithm by the way.
     *
     * @param from Current {@link BaseEntity}.
     * @param to   Target  {@link BaseEntity}.
     * @return A list consisting of coordinates.
     */
    public ArrayList<CoordinatePair> findPath(BaseEntity from, BaseEntity to) {
        return findPath(
                (int) from.getX(),
                (int) from.getY(),
                (int) to.getX(),
                (int) to.getY()
        );
    }
}
