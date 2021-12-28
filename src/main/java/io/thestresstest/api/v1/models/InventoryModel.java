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

        int location = -1;

        for(ItemStack item : inventory.getContents()) {
            location++;
            if(item != null) {
                slots.add(new SlotModel(item, location));
            }
        }
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

    @SerializedName("index")
    public int index;

    public SlotModel(ItemStack slot, int inventoryLocation) {
        amount = slot.getAmount();
        item = new ItemModel(slot);
        index = inventoryLocation;
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
        if(item.getItemMeta().hasLore()) {
            lore = item.getItemMeta().getLore();
        }

        item.getItemMeta().getEnchants().forEach((enchant, level) -> {
            enchants.add(new EnchantmentModel(enchant, level));
        });
    }
}