package org.mythriel81.umcm;

import net.fabricmc.api.ModInitializer;
import org.mythriel81.umcm.block.ModBlocks;
import org.mythriel81.umcm.item.ModItemGroups;
import org.mythriel81.umcm.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Umcm implements ModInitializer {

    public static final String MOD_ID = "mythriels-end-ores";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Trans rights.");
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
    }
}
