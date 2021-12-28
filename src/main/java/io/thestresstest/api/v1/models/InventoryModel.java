package io.thestresstest.api.v1.models;

import com.google.gson.annotations.SerializedName;

public class InventoryModel {

}

class EnchantmentModel {
    public String name;

}

class SlotModel {

    @SerializedName("amount")
    public int amount;

    @SerializedName("name")
    public int name;

    @SerializedName("maximum_stack_size")
    public int maximumStackSize;

//    public

}
