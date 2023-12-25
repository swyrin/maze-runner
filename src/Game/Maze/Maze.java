package Game.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Maze extends JFrame {
    private static final char[][] maze = {
        {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
        {'*', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', '*'},
        {'*', ' ', '*', '*', '*', ' ', '*', ' ', '*', ' ', ' ', '*', ' ', ' ', '*'},
        {'*', ' ', '*', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ', '*', ' ', ' ', '*'},
        {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ', '*', '*', '*', '*'},
        {'*', ' ', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'},
        {'*', '*', '*', '*', ' ', '*', ' ', ' ', '*', '*', '*', '*', ' ', ' ', '*'},
        {'*', ' ', ' ', '*', ' ', '*', ' ', ' ', '*', ' ', ' ', '*', ' ', ' ', '*'},
        {'*', ' ', ' ', '*', ' ', '*', '*', ' ', '*', ' ', '*', '*', ' ', '*', '*'},
        {'*', ' ', ' ', ' ', ' ', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', '*'},
        {'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', '*', ' ', ' ', '*'},
        {'*', ' ', '*', '*', ' ', '*', '*', ' ', '*', ' ', ' ', '*', ' ', ' ', '*'},
        {'*', ' ', '*', '*', ' ', '*', '*', ' ', '*', ' ', ' ', '*', ' ', ' ', '*'},
        {'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', '*'},
        {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}
    };

    private int currentX = 0, currentY = 0; // Initial position of 'O'

    public Maze() {
    
            @Override
            public void keyTyped(KeyEvent e) {}

        
        ;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                switch (maze[i][j]) {
                    case '*':
                        g.setColor(Color.BLACK);
                        break;
                    case 'O':
                        g.setColor(Color.RED);
                        break;
                    case ' ':
                        g.setColor(Color.WHITE);
                        break;
                }
                g.fillRect(j * 20, i * 20 + 20, 20, 20); // Draw a 20x20 square
            }
        }
    
        
    }

    public static char[][] getMaze() {
        return maze;
    }
}
