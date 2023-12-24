package Game.Maze;
<<<<<<< Updated upstream
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Maze extends JFrame  {
static char[][] maze = {
            {'*', '*', '*', '*','*','*','*','*','*','*','*','*','*','*','*'},
            {'*', 'O', ' ', ' ',' ',' ',' ',' ',' ',' ',' ','*',' ',' ','*'},
            {'*', ' ', '*', '*','*',' ','*',' ','*',' ',' ','*',' ',' ','*'},   
            {'*', ' ', '*', ' ',' ',' ','*',' ','*',' ',' ','*',' ',' ','*'},
            {'*', ' ', ' ', ' ',' ',' ','*',' ','*',' ',' ','*','*','*','*'},
            {'*', ' ', '*', '*',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','*'},
            {'*', '*', '*', '*',' ','*',' ',' ','*','*','*','*',' ',' ','*'},
            {'*', ' ', ' ', '*',' ','*',' ',' ','*',' ',' ','*',' ',' ','*'},
            {'*', ' ', ' ', '*',' ','*','*',' ','*',' ','*','*',' ','*','*'},
            {'*', ' ', ' ', ' ',' ','*','*',' ',' ',' ',' ','*','*','*','*'},
            {'*', ' ', ' ', ' ',' ',' ',' ',' ','*',' ',' ','*',' ',' ','*'},
            {'*', ' ', '*', '*',' ','*','*',' ','*',' ',' ','*',' ',' ','*'},
            {'*', ' ', '*', '*',' ','*','*',' ','*',' ',' ','*',' ',' ','*'},
            {'*', ' ', ' ', ' ',' ',' ',' ',' ','*',' ',' ',' ',' ',' ','*'},
            {'*', '*', '*', '*','*','*','*','*','*','*','*','*','*','*','*'},
        
        };
   
    
        
        
        int currentX = 0, currentY = 0; // Initial position of 'O'

        public Maze() {
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}
    
                @Override
                public void keyPressed(KeyEvent e) {
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_W && currentY > 0 && maze[currentY - 1][currentX] == ' ') {
                        maze[currentY][currentX] = ' ';
                        maze[--currentY][currentX] = 'O';
                    } else if (key == KeyEvent.VK_A && currentX > 0 && maze[currentY][currentX - 1] == ' ') {
                        maze[currentY][currentX] = ' ';
                        maze[currentY][--currentX] = 'O';
                    } else if (key == KeyEvent.VK_S && currentY < maze.length - 1 && maze[currentY + 1][currentX] == ' ') {
                        maze[currentY][currentX] = ' ';
                        maze[++currentY][currentX] = 'O';
                    } else if (key == KeyEvent.VK_D && currentX < maze[0].length - 1 && maze[currentY][currentX + 1] == ' ') {
                        maze[currentY][currentX] = ' ';
                        maze[currentY][++currentX] = 'O';
                    }
                    repaint(); // Redraw the maze
                }
    
                @Override
                public void keyReleased(KeyEvent e) {}
            });
    
            setVisible(true);
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
=======

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
>>>>>>> Stashed changes
            }
        }
    
        
    }
<<<<<<< Updated upstream
    public static char[][] getMaze(){
    return maze;
    }}

=======
>>>>>>> Stashed changes

    public static char[][] getMaze() {
        return maze;
    }
}
