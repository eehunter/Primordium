package com.oyosite.ticon.primordium;

import com.oyosite.ticon.primordium.block.BlockRegistry;
import com.oyosite.ticon.primordium.item.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class Primordium implements ModInitializer {
    public static final String MODID = "primordium";
    @Override
    public void onInitialize() {
        BlockRegistry.register();
        ItemRegistry.register();
    }
}
