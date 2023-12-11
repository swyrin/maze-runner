package Engine.Demo;

import Engine.Core.KeyBinding;
import Engine.GameController;
import Engine.Helper.RenderHelper;
import Engine.Object.BaseEntity;
import Engine.UI.Screen;
import Engine.UI.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class Square extends BaseEntity {
    private Color color;
    /**
     * Create an entity.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public Square(int x, int y) {
        super(x, y); this.color = Color.cyan;
    }

    /**
     * Change into to Color.a
     * @param a
     */
    public void colorChange(Color a){
        this.color = a;
    }
    public Color getColor(){ return this.color;}
}

abstract class GameScreen extends Screen {
    private final Square sq;

    public GameScreen(Square sq) {
        super();
        this.sq = sq;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(sq.getColor());
        g.fillRect(sq.getX(), sq.getY(), 30, 30);
    }
}

public class BasicBlockDemo {
    public static void main(String[] args) {
        Window w = new Window(new Dimension(800, 800));
        GameController controller = new GameController();
        Square sq = new Square(300, 300);

        //controller.start();

        GameScreen screen = new GameScreen(sq) {
            @Override
            public void render(Graphics2D g2d) {

            }

            @Override
            public void init() {

            }
        };
        screen.setBackground(Color.black);

        screen.registerKeyEvent(
                new KeyBinding("up",
                        "W",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("W hit");
                                sq.move(0, -10);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("left",
                        "A",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("A hit");
                                sq.move(-10, 0);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("back",
                        "S",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("S hit");
                                sq.move(0, 10);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("right",
                        "D",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("D hit");
                                sq.move(10, 0);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("Temporal Mantle",
                        "Q",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("Change into Yellow");
                                sq.colorChange(Color.yellow);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("Gillie Mantle",
                        "E",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("Change into Green");
                                sq.colorChange(Color.green);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("Mantle - Off",
                        "N",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("No - mantle");
                                sq.colorChange(Color.cyan);
                                w.repaint();
                            }
                        }));


        w.replaceCurrentScreenWith(screen);
        w.setVisible(true);
    }
}
