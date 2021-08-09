package com.oyosite.ticon.primordium.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public class PrimordiumNodeBlock extends BlockWithEntity {
    private final PrimordiumNodeBlockEntityFactory PNBEFactory;
    protected PrimordiumNodeBlock(Settings settings, PrimordiumNodeBlockEntityFactory PNBEFactory) {
        super(settings);
        this.PNBEFactory = PNBEFactory;
    }

    @Nullable @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return PNBEFactory.apply(pos, state);
    }

    public interface PrimordiumNodeBlockEntityFactory extends BiFunction<BlockPos, BlockState, BlockEntity>{}
}
