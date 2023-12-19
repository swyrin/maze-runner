package Engine.Demo;

import Engine.Core.KeyBinding;
import Game.Enitity.Player;
import Game.PlayerSquare;
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
     //   Square sq = new Square(300, 300);
        Player pl1 = new Player(300,300);
       PlayerSquare screen = new PlayerSquare(pl1);

        screen.setBackground(Color.black);

        screen.registerKeyEvent(
                new KeyBinding("to blue",
                        "F1",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                if (screen.getBackground() == Color.black) {
                                    System.out.println("To blue");
                                    screen.setBackground(Color.blue);
                                } else {
                                    System.out.println("Back to blue");
                                    screen.setBackground(Color.black);
                                }
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("up",
                        "W",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                pl1.move(0, -10);
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("left",
                        "A",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                pl1.move(-10, 0);
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("back",
                        "S",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                pl1.move(0, 10);
                            }
                        }));

        screen.registerKeyEvent(
                new KeyBinding("right",
                        "D",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                pl1.move(10, 0);
                            }
                        }));

      /*  screen.registerKeyEvent(
                new KeyBinding("yellow square",
                        "Q",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                if (pl1.getColor() != Color.yellow)
                                    pl1.changeColor(Color.yellow);
                                else
                                    pl1.changeColor(Color.cyan);
                            }
                        }));   */

        controller.start(w, screen);
    }
}
