package org.mythriel81.umcm.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.mythriel81.umcm.Umcm;
import org.spongepowered.include.com.google.common.base.Function;

public class ModBlocks {

    public static final Block MYTHRIL_ORE = registerBlockItem("mythril_ore",
            settings -> settings != null ? new Block(settings) : null,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(4.5f,9f),
            true);
    public static final Block ORICHALCUM_ORE = registerBlockItem("orichalcum_ore",
            settings -> settings != null ? new Block(settings) : null,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(4.5f,9f),
            true);

    private static Block registerBlockItem(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }
    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Umcm.MOD_ID, name));
    }
    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Umcm.MOD_ID, name));
    }

    public static void registerBuildingBlock() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->{
           entries.add(MYTHRIL_ORE);
           entries.add(ORICHALCUM_ORE);
        });
    }

    public static void registerModBlocks() {
        Umcm.LOGGER.info("Registering blocks for " + Umcm.MOD_ID);

        registerBuildingBlock();

    }
}