package com.oyosite.ticon.primordium.block.entity;

import com.oyosite.ticon.primordium.Primordium;
import com.oyosite.ticon.primordium.component.PrimordiumComponent;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public abstract class PrimordiumNode extends BlockEntity {
    public static final Identifier FIRE = new Identifier(Primordium.MODID, "fire");
    public PrimordiumNode(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public abstract void addValues(PrimordiumComponent comp);
}
