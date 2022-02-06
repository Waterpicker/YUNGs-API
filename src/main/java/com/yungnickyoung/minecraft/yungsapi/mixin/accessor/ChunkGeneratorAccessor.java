package com.yungnickyoung.minecraft.yungsapi.mixin.accessor;

import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.StructureSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ChunkGenerator.class)
public interface ChunkGeneratorAccessor {
    @Mutable
    @Accessor("settings")
    void setSettings(StructureSettings settings);
}
