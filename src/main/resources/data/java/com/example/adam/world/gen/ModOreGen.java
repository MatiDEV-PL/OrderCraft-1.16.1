package jp.koteko.example_mod.world;

import jp.koteko.example_mod.lists.BlockList;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenOres {
    public static void setup() {
        addOreToOverworld(
                BlockList.ExampleOre,
                17,
                new CountRangeConfig(20, 0, 0, 128)
        );
    }

    private static void addOreToOverworld(Block blockIn, int size, CountRangeConfig countRangeConfigIn) {
        for(Biome biome : ForgeRegistries.BIOMES) {
            if(!biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(
                                Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        blockIn.getDefaultState(),
                                        size
                                ),
                                Placement.COUNT_RANGE,
                                countRangeConfigIn
                        )
                );
            }
        }
    }
}