package com.oyosite.ticon.primordium.component;

import com.oyosite.ticon.primordium.Primordium;
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentInitializer;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import net.minecraft.util.Identifier;

public class ChunkEntrypoint implements ChunkComponentInitializer {
    public static final ComponentKey<PrimordiumComponent> PRIMORDIUM = ComponentRegistry.getOrCreate(new Identifier(Primordium.MODID, "primordium"), PrimordiumComponent.class);
    @Override
    public void registerChunkComponentFactories(ChunkComponentFactoryRegistry registry) {
        registry.register(PRIMORDIUM, PrimordiumComponent.Impl::new);
    }
}
