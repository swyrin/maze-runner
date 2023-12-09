package Engine.Demo;

import Engine.Core.KeyBinding;
import Engine.Demo.Entity.Square;
import Engine.Demo.Screen.BlackScreenWithSquare;
import Engine.GameController;
import Engine.UI.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CompleteDemo {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.init();

        Window w = new Window(new Dimension(800, 800));
        Square sq = new Square(300, 300);
        BlackScreenWithSquare screen = new BlackScreenWithSquare(sq);

        screen.setBackground(Color.black);

        screen.registerKeyEvent(
                new KeyBinding("to blue",
                        "F1",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("To blue");
                                w.setBackground(Color.blue);
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("up",
                        "W",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                // System.out.println("W hit");
                                sq.move(0, -10);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("left",
                        "A",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                // System.out.println("A hit");
                                sq.move(-10, 0);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("back",
                        "S",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                // System.out.println("S hit");
                                sq.move(0, 10);
                                w.repaint();
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("right",
                        "D",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                // System.out.println("D hit");
                                sq.move(10, 0);
                                w.repaint();
                            }
                        }));

        controller.start(w, screen);
    }
}
