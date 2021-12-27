package io.thestresstest.api.v1;

import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import io.thestresstest.api.v1.models.PlayerModel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerPath {
    public static void list(Context ctx) {

    }

    public static void list_all(Context ctx) {

    }

    public static void player(Context ctx) {
        String uuid = ctx.pathParam("uuid");
        if(uuid.isEmpty()) {
            throw new BadRequestResponse("Missing parameter uuid in path.");
        }

        Player player = Bukkit.getPlayer(UUID.fromString(uuid));

        ctx.json(new PlayerModel(player));
    }

    public static void kick_player(Context ctx) {
        String uuid = ctx.pathParam("uuid");
        Player player = Bukkit.getPlayer(UUID.fromString(uuid));

        player.kickPlayer((ctx.queryParam("message") == null) ? "You have been kicked from the game." : ctx.queryParam("message"));
    }

}
