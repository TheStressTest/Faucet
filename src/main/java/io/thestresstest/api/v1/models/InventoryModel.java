package io.thestresstest.api.v1.models;

import com.google.gson.annotations.SerializedName;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryModel {

    @SerializedName("slots")
    public List<SlotModel> slots = new ArrayList<>();

    public InventoryModel(PlayerInventory inventory) {

        inventory.forEach((n) -> {
            slots.add(new SlotModel(n));
        });
    }

}

class EnchantmentModel {

    @SerializedName("name")
    public String name;

    @SerializedName("level")
    public int level;

    @SerializedName("maximum_level")
    public int maximumLevel;

    public EnchantmentModel(Enchantment enchant, int enchantLevel) {
        name = enchant.getKey().getKey();
        level = enchantLevel;
        maximumLevel = enchant.getMaxLevel();
    }
}

class SlotModel {

    @SerializedName("amount")
    public int amount;

    @SerializedName("item")
    public ItemModel item;

    public SlotModel(ItemStack slot) {
        amount = slot.getAmount();
        item = new ItemModel(slot);
    }
}

class ItemModel {

    @SerializedName("name")
    public String name;

    @SerializedName("lore")
    public List<String> lore;

    @SerializedName("enchants")
    public ArrayList<EnchantmentModel> enchants;

    public ItemModel(ItemStack item) {
        name = item.getType().name();
        if(item.getItemMeta().hasLore()) { lore = item.getItemMeta().getLore(); }

        item.getItemMeta().getEnchants().forEach((enchant, level) -> {
            enchants.add(new EnchantmentModel(enchant, level));
        });
    }
}