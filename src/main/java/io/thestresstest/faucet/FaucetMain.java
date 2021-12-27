package io.thestresstest.faucet;

import io.thestresstest.api.v1.*;
import io.javalin.Javalin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class FaucetMain extends JavaPlugin {

    private static Javalin app;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Plugin whatever has started. SSL is " + Config.SSL.SSL_ENABLED);
        saveDefaultConfig();

        setupWebServer();
    }

    @Override
    public void onDisable() {
        app.stop();
    }

    private void setupWebServer()
    {
        // Get the current class loader.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(FaucetMain.class.getClassLoader());

        // Instantiate the web server (which will now load using the plugin's class loader).
        app = Javalin.create(config -> {

            config.showJavalinBanner = false;
            config.defaultContentType = "application/json";
            config.jsonMapper(new GsonMapper());
            config.accessManager((handler, ctx, permittedRoles) -> {
                String key = ctx.header(Config.API_HEADER);

                if(!Config.AUTH) {
                    handler.handle(ctx);
                    return;
                }

                if(key != null && key.equals(Config.API_KEY)) {
                    handler.handle(ctx);
                    return;
                }

                // If all else fails, send an authentication error.
                ctx.status(401);
            });


        }).start(Config.port);

        app.routes(() -> {
            path(Config.V1_PATH, () -> {
                get("/version", StatusPath::version);
                get("/status", StatusPath::status);
                get("/player/players", PlayerPath::list);
                get("/player/player/{uuid}", PlayerPath::player);
                delete("/player/player/{uuid}", PlayerPath::kick_player);
            });
        });

        // Put the original class loader back where it was.
        Thread.currentThread().setContextClassLoader(classLoader);

    }

}
