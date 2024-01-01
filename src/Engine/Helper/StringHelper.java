package Engine.Helper;

import java.time.Duration;

public class StringHelper {
    public static int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }

    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    public static String formatDuration(Duration d) {
        int hour = d.toHoursPart();
        int minute = d.toMinutesPart();
        int second = d.toSecondsPart();
        int nano = d.toNanosPart();

        return String.format("%d:%02d:%02d.%3d", hour, minute, second, nano);
    }
}
