package com.oyosite.ticon.primordium.block;

import com.oyosite.ticon.primordium.Primordium;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BlockRegistry {
    public static final Map<Block, Pair<Identifier, FabricItemSettings>> BLOCK_STUFF = new HashMap<>();









    public static Block r(String id, Block block, FabricItemSettings settings){
        BLOCK_STUFF.put(block, new Pair<>(new Identifier(Primordium.MODID), settings));
        return block;
    }
    public static void r(Block... blocks){
        Arrays.stream(blocks).forEach(b-> {
            Pair<Identifier, FabricItemSettings> p = BLOCK_STUFF.get(b);
            Registry.register(Registry.BLOCK, p.getLeft(), b);
            Registry.register(Registry.ITEM, p.getLeft(), new BlockItem(b, p.getRight()));
        });
    }
    public static void register(){
        r(BLOCK_STUFF.keySet().toArray(new Block[]{}));
    }

}
