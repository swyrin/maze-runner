package Engine.Helper;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DiscordNativeFilesDownload {
    public static File downloadDiscordLibrary() throws IOException {
        String name = "discord_game_sdk";
        String suffix;

        String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        String arch = System.getProperty("os.arch").toLowerCase(Locale.ROOT);

        if (osName.contains("windows")) {
            suffix = ".dll";
        } else if (osName.contains("linux")) {
            suffix = ".so";
        } else if (osName.contains("mac os")) {
            suffix = ".dylib";
        } else {
            throw new RuntimeException("cannot determine OS type: " + osName);
        }

        if (arch.equals("amd64"))
            arch = "x86_64";
        String zipPath = "lib/" + arch + "/" + name + suffix;

        URL downloadUrl = new URL("https://dl-game-sdk.discordapp.net/2.5.6/discord_game_sdk.zip");
        HttpURLConnection connection = (HttpURLConnection) downloadUrl.openConnection();
        connection.setRequestProperty("User-Agent", "discord-game-sdk4j (https://github.com/JnCrMx/discord-game-sdk4j)");
        ZipInputStream zin = new ZipInputStream(connection.getInputStream());

        ZipEntry entry;
        while ((entry = zin.getNextEntry()) != null) {
            if (entry.getName().equals(zipPath)) {
                File tempDir = new File(System.getProperty("java.io.tmpdir"), "java-" + name + System.nanoTime());
                if (!tempDir.mkdir())
                    throw new IOException("Cannot create temporary directory");
                tempDir.deleteOnExit();

                File temp = new File(tempDir, name + suffix);
                temp.deleteOnExit();

                Files.copy(zin, temp.toPath());

                zin.close();
                return temp;
            }
            zin.closeEntry();
        }
        zin.close();
        return null;
    }
}