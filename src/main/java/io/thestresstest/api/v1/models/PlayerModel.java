package io.thestresstest.api.v1.models;

import com.google.gson.annotations.SerializedName;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PlayerModel {

    @SerializedName("uuid")
    public String UUID;

    @SerializedName("name")
    public String userName;

    @SerializedName("op")
    public boolean isOp;

    @SerializedName("address")
    public String ipAddress;

    @SerializedName("dimension")
    public String dimension;

    @SerializedName("health")
    public double health;

    @SerializedName("hunger")
    public int hunger;

    @SerializedName("saturation")
    public float saturation;

    @SerializedName("experience")
    public ExperienceModel experience;

    @SerializedName("gamemode")
    public String gamemode;

    @SerializedName("position")
    public PositionModel position;

    @SerializedName("inventory")
    public InventoryModel inventory;

    public PlayerModel(Player player) {
        UUID = player.getUniqueId().toString();
        userName = player.getDisplayName();
        isOp = player.isOp();
        ipAddress = Objects.requireNonNull(player.getAddress()).toString();
        dimension = Objects.requireNonNull(player.getLocation().getWorld()).getName();
        health = player.getHealth();
        hunger = player.getFoodLevel();
        saturation = player.getSaturation();
        experience = new ExperienceModel(
                player.getTotalExperience(),
                player.getExp(),
                player.getLevel()
        );
        gamemode = player.getGameMode().toString();
        position = new PositionModel(
                player.getLocation().getX(),
                player.getLocation().getY(),
                player.getLocation().getZ()
        );

        inventory = new InventoryModel(player.getInventory());

    }
}
