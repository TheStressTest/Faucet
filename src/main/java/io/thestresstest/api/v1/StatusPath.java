package io.thestresstest.api.v1;

import io.javalin.http.Context;
import org.bukkit.Bukkit;

import java.util.HashMap;

public class StatusPath {

    public static void version(Context ctx) {
        HashMap<String, String> result = new HashMap<>();
        result.put("bukkit", Bukkit.getBukkitVersion());
        result.put("server", Bukkit.getVersion());
        ctx.json(result);
    }

    public static void status(Context ctx) {

    }
}
