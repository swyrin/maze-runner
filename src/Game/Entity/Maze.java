package Game.Entity;

import Engine.Helper.StringHelper;

import java.util.ArrayList;

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
    // REMINDER: NO HARDCODE!!!!
    private final int[][] mazeMatrix;
    private int playerStartX, playerStartY;
    private int keyCount;
    private final ArrayList<Knight> knightList;

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
            }

            if (c == ENEMY_CHAR) {
                m.getKnightList().add(new Knight(col, row));
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
}
