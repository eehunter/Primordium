package com.oyosite.ticon.primordium.block;

import com.google.common.collect.ImmutableList;
import com.oyosite.ticon.primordium.Primordium;
import com.oyosite.ticon.primordium.block.entity.PowerSource;
import com.oyosite.ticon.primordium.block.entity.PrimordialFurnace;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.*;

public class BlockRegistry {
    public static final Map<Block, Pair<Identifier, FabricItemSettings>> BLOCK_STUFF = new HashMap<>();
    public static final List<PrimordiumNodeBlock<PowerSource>> POWER_SOURCES = new ArrayList<>();

    public static BlockEntityType<PrimordialFurnace> PRIMORDIAL_FURNACE_BLOCK_ENTITY;
    public static BlockEntityType<PowerSource> POWER_SOURCE_BLOCK_ENTITY;

    public static PrimordiumNodeBlock<PrimordialFurnace> PRIMORDIAL_FURNACE = r("primordial_furnace", new PrimordiumNodeBlock<>(FabricBlockSettings.of(Material.METAL), PrimordialFurnace::new));
    public static PrimordiumNodeBlock<PowerSource> POWER_CRYSTAL = p(r("power_crystal", new PrimordiumNodeBlock<>(FabricBlockSettings.of(Material.GLASS), PowerSource::new)));




    public static <P extends PrimordiumNodeBlock<PowerSource>> P p(P powerSource){
        POWER_SOURCES.add(powerSource);
        return powerSource;
    }
    public static <B extends Block> B r(String id, B block){
        return r(id, block, new FabricItemSettings());
    }
    public static <B extends Block> B r(String id, B block, FabricItemSettings settings){
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
        PRIMORDIAL_FURNACE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Primordium.MODID, "primordial_furnace"), FabricBlockEntityTypeBuilder.create(PrimordialFurnace::new, PRIMORDIAL_FURNACE).build(null));
        POWER_SOURCE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Primordium.MODID, "power_source"), FabricBlockEntityTypeBuilder.create(PowerSource::new, POWER_SOURCES.toArray(new PrimordiumNodeBlock[]{})).build(null));
    }

}
