package dev.creoii.rainthroughleaves;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;

public class RainThroughLeaves implements ModInitializer {
    public static final Heightmap.Types WEATHER = Heightmap.Types.valueOf("WEATHER");
    public static final TagKey<Block> PERFORATED = TagKey.create(Registries.BLOCK, ResourceLocation.tryBuild("rainthroughleaves", "perforated"));

    @Override
    public void onInitialize() {
    }
}
