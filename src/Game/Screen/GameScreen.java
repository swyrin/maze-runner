package Game.Screen;

import Engine.UI.Screen;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameScreen extends Screen {
    private Set<String> mapList;
    private int currentMapPosition = 0;

    @Override
    public void render(Graphics2D g2d) {

    }

    @Override
    public void init() {
        mapList = Stream.of(Objects.requireNonNull(new File("resources/Map").listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}
