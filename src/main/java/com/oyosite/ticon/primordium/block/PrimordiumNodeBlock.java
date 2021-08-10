package com.oyosite.ticon.primordium.block;

import com.oyosite.ticon.primordium.block.entity.PrimordiumNode;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public class PrimordiumNodeBlock<N extends PrimordiumNode> extends BlockWithEntity {
    private final PrimordiumNodeBlockEntityFactory<N> PNBEFactory;
    protected PrimordiumNodeBlock(Settings settings, PrimordiumNodeBlockEntityFactory<N> PNBEFactory) {
        super(settings);
        this.PNBEFactory = PNBEFactory;
    }

    @Nullable @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return PNBEFactory.apply(pos, state);
    }

    public interface PrimordiumNodeBlockEntityFactory<N extends PrimordiumNode> extends BiFunction<BlockPos, BlockState, N>{}
}
