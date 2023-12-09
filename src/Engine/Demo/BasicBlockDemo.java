package Engine.Demo;

import Engine.Core.KeyBinding;
import Engine.Demo.Entity.Square;
import Engine.Demo.Screen.BlackScreenWithSquare;
import Engine.UI.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class BasicBlockDemo {
    public static void main(String[] args) {
        Window w = new Window(new Dimension(800, 800));
        Square sq = new Square(300, 300);

        BlackScreenWithSquare screen = new BlackScreenWithSquare(sq);
        screen.setBackground(Color.black);

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
