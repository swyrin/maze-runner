/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: The screen appears when you completed all zones.
*/

package Game.Screen;

import Engine.Helper.StringHelper;
import Engine.Loader.FontLoader;
import Engine.UI.Screen;
import Game.Core.ClockTimer;
import Game.UI.StyleButton;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Scanner;

public class WinScreen extends Screen {
    @Override
    public void render(Graphics2D g2d) {
    }

    @Override
    public void init() {
        this.getParentWindow().setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);

        Font font = FontLoader.createFont("pixeloid_mono", 60);

        JLabel bigText = new JLabel("You won");
        bigText.setFont(font);
        bigText.setHorizontalAlignment(JLabel.CENTER);
        bigText.setForeground(Color.yellow);

        JLabel favorText = new JLabel("It's time for celebration?");
        favorText.setHorizontalAlignment(JLabel.CENTER);
        favorText.setForeground(Color.orange);

        Duration totalTime = ClockTimer.getElapsedTime();
        String totalTimeString = StringHelper.formatDuration(ClockTimer.getElapsedTime());

        favorText.setText(favorText.getText().concat("\n").concat("Total time: " + totalTimeString));

        File achievementFile = new File("resources/Map/best_time.txt");

        if (!achievementFile.exists()) {
            String newFav = favorText.getText().concat("\n").concat("Sounds like your first time playing this.");
            favorText.setText(newFav);

            try {
                achievementFile.createNewFile();
                PrintWriter out = new PrintWriter(achievementFile);
                out.println(totalTime.toNanos());
                out.close();
            } catch (IOException e) {
                //
            }
        } else {
            try {
                Scanner fileReader = new Scanner(achievementFile);
                long currentBest = Long.parseLong(fileReader.nextLine());

                String bestTime = StringHelper.formatDuration(Duration.ofNanos(currentBest));
                String newFav = favorText.getText().concat("\n").concat("Best score: " + bestTime);

                if (totalTime.toNanos() < currentBest) {
                    newFav = newFav.concat("\n").concat("Sounds like a new best score.");
                    favorText.setText(newFav);

                    PrintWriter out = new PrintWriter(achievementFile);
                    out.println(totalTime.toNanos());
                    out.close();
                } else {
                    newFav = newFav.concat("\n").concat("Try harder next time!");
                    favorText.setText(newFav);
                }
            } catch (FileNotFoundException e) {
                //
            }
        }

        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setOpaque(false);
        buttonsContainer.setBackground(Color.black);
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.Y_AXIS));

        StyleButton startButton = new StyleButton("Start Again");
        StyleButton returnButton = new StyleButton("Main Screen");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new CharacterSelectScreen()));

        returnButton.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new MainScreen()));

        buttonsContainer.add(startButton, BorderLayout.SOUTH);
        buttonsContainer.add(returnButton, BorderLayout.SOUTH);

        this.add(bigText, BorderLayout.NORTH);

        String text;

        text = favorText.getText();
        favorText.setText("<html>" + text.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        favorText.setFont(font.deriveFont(16f));
        this.add(favorText);

        this.add(buttonsContainer, BorderLayout.SOUTH);
    }
}
