package io.thestresstest.mcapi;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private static final FileConfiguration config = McAPI.getPlugin(McAPI.class).getConfig();
    public static int port = config.getInt("port", 8080);
    public static final String API_HEADER = "X-API-Key";

    static final String API_KEY = config.getString("token", "change_me");
    static final boolean AUTH = config.getBoolean("auth", false);

    public static final String V1_PATH = "/v1";

    public static class SSL {
        public static final boolean SSL_ENABLED = Config.config.getBoolean("ssl.enabled", false);

    }
}

