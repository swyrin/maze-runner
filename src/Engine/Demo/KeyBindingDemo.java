package Engine.Demo;

import Engine.Core.KeyBinding;
import Engine.UI.Screen;
import Engine.UI.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KeyBindingDemo {
    public static void main(String... args) {
        Window window = new Window(new Dimension(1366, 768));

        Screen screen1 = new Screen(), screen2 = new Screen(), screen3 = new Screen();

        screen1.setBackground(Color.red);
        screen2.setBackground(Color.blue);
        screen3.setBackground(Color.green);

        screen1.add(new TextArea("Red"));
        screen2.add(new TextArea("Blue"));
        screen3.add(new TextArea("Green"));

        screen1.registerKeyEvent(
                new KeyBinding("to blue",
                        "F1",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("To blue");
                                window.replaceCurrentScreenWith(screen2);
                            }
                        }));

        screen2.registerKeyEvent(
                new KeyBinding("to green",
                        "F1",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("To green");
                                window.replaceCurrentScreenWith(screen3);
                            }
                        }));

        screen3.registerKeyEvent(
                new KeyBinding("to red",
                        "F1",
                        new AbstractAction() {
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("To red");
                                window.replaceCurrentScreenWith(screen1);
                            }
                        }));


        window.replaceCurrentScreenWith(screen1);
        window.setVisible(true);
    }
}
