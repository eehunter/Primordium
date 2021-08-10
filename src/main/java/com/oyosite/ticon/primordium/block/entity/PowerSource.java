package com.oyosite.ticon.primordium.block.entity;

import com.oyosite.ticon.primordium.block.BlockRegistry;
import com.oyosite.ticon.primordium.block.PrimordiumNodeBlock.PrimordiumNodeBlockEntityFactory;
import com.oyosite.ticon.primordium.component.PrimordiumComponent;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

import java.util.function.Supplier;

public class PowerSource extends PrimordiumNode{

    public PowerSource(BlockPos pos, BlockState state) {
        super(BlockRegistry.POWER_SOURCE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void addValues(PrimordiumComponent comp) {

    }
}
