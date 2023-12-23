package Game.Maze;

import java.awt.Graphics;

public class Image {
    String edgebottomleft;
    String edgebottomright;
    String edgetopleft;
    String edgetopright;
    String edgeleft;
    String edgeright;
    String edgetshapebottomright;
    String edgetshapebottomleft;
    String edgetshaperight;
    String edgetshapeleft;
    String edgemidleft;
    String edgemidright;

    public Image() {
        edgebottomleft = "wall_edge_bottom_left.png";
        edgebottomright = "wall_edge_bottom_right.png";
        edgetopleft = "wall_edge_top_left.png";
        edgetopright = "wall_edge_top_right.png";
        edgeleft = "wall_edge_left.png";
        edgeright = "wall_edge_right.png";
        edgetshapebottomright = "wall_edge_tshape_bottom_right";
        edgetshapebottomleft = "wall_edge_tshape_bottom_left.png";
        edgetshaperight = "wall_edge_tshape_right.png";
        edgetshapeleft = "wall_edge_tshape_left.png";
        edgemidleft = "wall_edge_mid_left.png";
        edgemidright = "wall_edge_mid_right.png";
    }
    public void render(Graphics g) {
        char[][] maze = {
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
            {'*', '*', '*', '*','*','*','*','*','*','*','*','*','*','*','*'};
            
            Image image = new Image();
            int tileSize = 32; 
        
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    switch (maze[i][j]) {
                        case '*':
                            g.drawImage(image.edgetopleft, j * tileSize, i * tileSize, null);
                            break;
                        case 'O':
                            g.drawImage(image.edgebottomright, j * tileSize, i * tileSize, null);
                            break;
                        case ' ':
                            
                            break;
                       
                    }
                }
            }
        
            
        }
    }
    }

