package com.example.adam.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PaperBlock extends Block {

    public PaperBlock() {
        super(Properties.create(Material.WOOL)
                .hardnessAndResistance(1.0f, 1.0f)
                .harvestLevel(0));
    }
}
