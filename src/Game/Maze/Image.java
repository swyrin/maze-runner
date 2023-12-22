package Game.Maze;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    public static void main(String[] args) throws IOException {
        JFrame frame = buildFrame();

        final BufferedImage edgebottomleft = ImageIO.read(new File("d:\\_maze\\resources\\Wall\\wall_edge_bottom_left.pngl"));
        final BufferedImage edgebottomright = ImageIO.read(new File("D:\\_maze\\resources\\Wall\\wall_edge_bottom_right.png"));
        final BufferedImage edgetopleft = ImageIO.read(new File("D:\\_maze\resources\\Wall\\wall_edge_top_left.png"));
        final BufferedImage edgetopright = ImageIO.read(new File("d:\\_maze\resources\\Wall\\wall_edge_top_right.png"));
        final BufferedImage edgeleft = ImageIO.read(new File("d:\\_maze\\resources\\Wall\\wall_edge_left.png"));
        final BufferedImage edgeright = ImageIO.read(new File("d:\\_maze\resources\\Wall\\wall_edge_right.png"));

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(edgebottomleft, 1, 15, null);
                g.drawImage(edgebottomright,15, 0, null);
                g.drawImage(edgetopright,15, 1, null);
                g.drawImage(edgetopleft,1, 1, null);
                g.drawImage(edgeleft,0, 0, null);
                g.drawImage(edgeright,0, 0, null);
            }
        };


        frame.add(pane);
    }


    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }


}