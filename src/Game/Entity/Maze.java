package Game.Entity;

import Engine.Helper.StringHelper;

public class Maze {
    // REMINDER: NO HARDCODE!!!!
    private int[][] mazeMatrix;
    private final int width;
    private final int height;
    private int playerStartX, playerStartY;

    public static final char KEY_CHAR = 'K';
    public static final char KEY_CONST = 1;
    public static final char WALL_CHAR = 'W';
    public static final char WALL_CONST = 2;
    public static final char PATH_CHAR = ' ';
    public static final char PATH_CONST = 3;
    public static final char PLAYER_CHAR = 'P';

    public Maze(int width, int height) {
        this.mazeMatrix = new int[height][width];
        this.width = width;
        this.height = height;
    }

    public void setPlayerStartX(int playerStartX) {
        this.playerStartX = playerStartX;
    }

    public void setPlayerStartY(int playerStartY) {
        this.playerStartY = playerStartY;
    }

    public int getPlayerStartX() {
        return playerStartX;
    }

    public int getPlayerStartY() {
        return playerStartY;
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

    public void setMazeMatrix(int[][] mazeMatrix) {
        this.mazeMatrix = mazeMatrix;
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

            if (c == KEY_CHAR) {
                mat[row][col] = KEY_CONST;
            }

            if (c == PATH_CHAR) {
                mat[row][col] = PATH_CONST;
            }

            if (c == PLAYER_CHAR) {
                m.setPlayerStartX(row);
                m.setPlayerStartY(col);
            }

            col++;
            if (c == '\n') {
                row++;
                col = 0;
            }
        }

        m.setMazeMatrix(mat);

        return m;
    }
}
