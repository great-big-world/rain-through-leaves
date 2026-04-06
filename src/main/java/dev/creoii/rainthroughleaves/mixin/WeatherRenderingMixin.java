package dev.creoii.rainthroughleaves.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.creoii.rainthroughleaves.RainThroughLeaves;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LevelRenderer.class)
public class WeatherRenderingMixin {
    @WrapOperation(method = "renderSnowAndRain", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getHeight(Lnet/minecraft/world/level/levelgen/Heightmap$Types;II)I"))
    private int creo$applyWeatherRenderIgnores(Level instance, Heightmap.Types heightmap, int x, int z, Operation<Integer> original) {
        return original.call(instance, RainThroughLeaves.WEATHER, x, z);
    }

    @WrapOperation(method = "tickRain", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelReader;getHeightmapPos(Lnet/minecraft/world/level/levelgen/Heightmap$Types;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/core/BlockPos;"))
    private BlockPos creo$applyWeatherRenderIgnoresParticles(LevelReader instance, Heightmap.Types types, BlockPos blockPos, Operation<BlockPos> original) {
        return original.call(instance, RainThroughLeaves.WEATHER, blockPos);
    }
}
