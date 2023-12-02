package Engine.Core;

import Engine.Helper.DiscordNativeFilesDownload;

import java.io.IOException;

public class DiscordIntegration {
    public DiscordIntegration() throws IOException {
        DiscordNativeFilesDownload.downloadDiscordLibrary();
    }
}
