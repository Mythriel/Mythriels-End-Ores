package org.mythriel81.umcm.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.mythriel81.umcm.Umcm;
import org.mythriel81.umcm.block.ModBlocks;

import static net.minecraft.registry.Registry.*;

public class ModItemGroups {
    public static final ItemGroup MYTHS_END_ORES_ITEM_GROUP = register(Registries.ITEM_GROUP,
            Identifier.of(Umcm.MOD_ID, "mythriels_end_ores_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MYTHRIL))
            .displayName(Text.translatable("itemgroup.mythriels_end_ores_items"))
            .entries((displayContext, entries) ->{
                entries.add(ModItems.MYTHRIL);
                entries.add(ModItems.ORICHALCUM);
                entries.add(ModItems.RAW_MYTHRIL);
                entries.add(ModItems.RAW_ORICHALCUM);
                entries.add(ModBlocks.MYTHRIL_ORE);
                entries.add(ModBlocks.ORICHALCUM_ORE);
            }).build());




    public static void registerItemGroups(){
        Umcm.LOGGER.info("Registering Item Groups.");
    }
}
