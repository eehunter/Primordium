package com.oyosite.ticon.primordium.component;

import com.oyosite.ticon.primordium.block.entity.PrimordiumNode;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PrimordiumComponent extends AutoSyncedComponent {

    void addNode(BlockPos node);
    @SuppressWarnings("UnusedReturnValue")
    boolean removeNode(BlockPos node);

    void recalculateValues();
    Map<Identifier, Double> getValues();

    class Impl implements PrimordiumComponent {

        public List<BlockPos> nodes = new ArrayList<>();
        public Map<Identifier, Double> values = new HashMap<>();
        public final Chunk provider;

        public Impl(Chunk provider){
            this.provider = provider;
        }

        @Override
        public void readFromNbt(NbtCompound tag) {
            NbtCompound nbt = tag.getCompound("nodes");
            for(int i = 0; nbt.contains(i+"");i++)nodes.add(BlockPos.fromLong(nbt.getLong(i+"")));
        }

        @Override
        public void writeToNbt(NbtCompound tag) {
            NbtCompound nbt = new NbtCompound();
            for(int i = 0; i < nodes.size(); i++)nbt.putLong(i+"",nodes.get(i).asLong());
            tag.put("nodes", nbt);
        }

        @Override
        public void addNode(BlockPos node) {
            if(provider.getBlockEntity(node) instanceof PrimordiumNode && !nodes.contains(node)){
                nodes.add(node);
            }
        }

        @Override
        public boolean removeNode(BlockPos node) {
            return nodes.remove(node);
        }

        @Override
        public void recalculateValues() {
            values.clear();
            for(BlockPos node : nodes){
                BlockEntity be = provider.getBlockEntity(node);
                if(be instanceof PrimordiumNode){
                    ((PrimordiumNode)be).addValues(this);
                } else {
                    removeNode(node);
                }
            }
        }

        @Override
        public Map<Identifier, Double> getValues() {
            return values;
        }


    }
}
