package org.mythriel81.umcm.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.mythriel81.umcm.Umcm;

public class ModItems {

    public static final Item MYTHRIL = registerItem("mythril");
    public static final Item RAW_MYTHRIL = registerItem("raw_mythril");
    public static final Item ORICHALCUM = registerItem("orichalcum");
    public static final Item RAW_ORICHALCUM = registerItem("raw_orichalcum");

    private static Item registerItem(String name) {
        Identifier id = Identifier.of(Umcm.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().registryKey(key);
        return Registry.register(Registries.ITEM, key , new Item(settings));
    }

    public static void registerIngredients() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_MYTHRIL);
            entries.add(RAW_ORICHALCUM);
            entries.add(MYTHRIL);
            entries.add(ORICHALCUM);
        });
    }


    public static void registerModItems() {
        Umcm.LOGGER.info("Registering Mod Items for " + Umcm.MOD_ID);

        registerIngredients();

    }

}
