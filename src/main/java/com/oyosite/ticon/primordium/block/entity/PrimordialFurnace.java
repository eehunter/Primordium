package com.oyosite.ticon.primordium.block.entity;

import com.oyosite.ticon.primordium.block.BlockRegistry;
import com.oyosite.ticon.primordium.component.PrimordiumComponent;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class PrimordialFurnace extends PrimordiumNode{
    public PrimordialFurnace(BlockPos pos, BlockState state) {
        super(BlockRegistry.PRIMORDIAL_FURNACE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void addValues(PrimordiumComponent comp) {
        comp.getValues().put(FIRE, comp.getValues().getOrDefault(FIRE, 0d)-getDrain());
    }

    public double getDrain(){
        return 1d;
    }
}
