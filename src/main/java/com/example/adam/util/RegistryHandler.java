package com.example.adam.util;

import com.example.adam.ToolMod;
import com.example.adam.blocks.*;
import com.example.adam.items.ItemBase;
import com.example.adam.armor.ModArmorMaterial;
import com.example.adam.util.enums.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ToolMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ToolMod.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> Copper_Ingot = ITEMS.register("copper_ingot", ItemBase::new);
    public static final RegistryObject<Item> Aurora_Fragment = ITEMS.register("aurora_fragment", ItemBase::new);
    public static final RegistryObject<Item> Tin_Ingot = ITEMS.register("tin_ingot", ItemBase::new);

    //Tools
    public static final RegistryObject<AxeItem> Copper_Axe = ITEMS.register("copper_axe",
            () -> new AxeItem(ModItemTier.Copper_Ingot, 2, -3.2F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<SwordItem> Copper_Sword = ITEMS.register("copper_sword",
            () -> new SwordItem(ModItemTier.Copper_Ingot, 2, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<PickaxeItem> Copper_Pickaxe = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModItemTier.Copper_Ingot, 0, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<ShovelItem> Copper_Shovel = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModItemTier.Copper_Ingot, 1, -3F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<HoeItem> Copper_hoe = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModItemTier.Copper_Ingot, -1, -3F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<SwordItem> Aurora_Sword = ITEMS.register("aurora_sword",
            () -> new SwordItem(ModItemTier.Aurora_Fragment, 8, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<AxeItem> Aurora_Axe = ITEMS.register("aurora_axe",
            () -> new AxeItem(ModItemTier.Aurora_Fragment, 3, -3.2F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<PickaxeItem> Aurora_Pickaxe = ITEMS.register("aurora_pickaxe",
            () -> new PickaxeItem(ModItemTier.Aurora_Fragment, 0, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<ShovelItem> Aurora_Shovel = ITEMS.register("aurora_shovel",
            () -> new ShovelItem(ModItemTier.Aurora_Fragment, 1, -3F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<HoeItem> Aurora_hoe = ITEMS.register("aurora_hoe",
            () -> new HoeItem(ModItemTier.Aurora_Fragment, -1, -3F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<AxeItem> Emerald_Axe = ITEMS.register("emerald_axe",
            () -> new AxeItem(ModItemTier.Emerald, 3, -3.2F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<SwordItem> Emerald_Sword = ITEMS.register("emerald_sword",
            () -> new SwordItem(ModItemTier.Emerald, 2, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<PickaxeItem> Emerald_Pickaxe = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(ModItemTier.Emerald, 0, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<ShovelItem> Emerald_Shovel = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(ModItemTier.Emerald, 1, -3F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<HoeItem> Emerald_hoe = ITEMS.register("emerald_hoe",
            () -> new HoeItem(ModItemTier.Emerald, -1, -3F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<AxeItem> Tin_Axe = ITEMS.register("tin_axe",
            () -> new AxeItem(ModItemTier.Tin, 3, -3.2F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<SwordItem> Tin_Sword = ITEMS.register("tin_sword",
            () -> new SwordItem(ModItemTier.Tin, 2, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<PickaxeItem> Tin_Pickaxe = ITEMS.register("tin_pickaxe",
            () -> new PickaxeItem(ModItemTier.Tin, 0, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<ShovelItem> Tin_Shovel = ITEMS.register("tin_shovel",
            () -> new ShovelItem(ModItemTier.Tin, 1, -3F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<HoeItem> Tin_hoe = ITEMS.register("tin_hoe",
            () -> new HoeItem(ModItemTier.Tin, -1, -3F, new Item.Properties().group(ItemGroup.TOOLS)));

    // Armor
    public static final RegistryObject<ArmorItem> Copper_Chelmet = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Copper_Chestplate = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Copper_Leggings = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Copper_Boots = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> Emerald_Chelmet = ITEMS.register("emerald_helmet",
            () -> new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Emerald_Chestplate = ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Emerald_Leggings = ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Emerald_Boots = ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> Tin_Chelmet = ITEMS.register("tin_helmet",
            () -> new ArmorItem(ModArmorMaterial.TIN, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Tin_Chestplate = ITEMS.register("tin_chestplate",
            () -> new ArmorItem(ModArmorMaterial.TIN, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Tin_Leggings = ITEMS.register("tin_leggings",
            () -> new ArmorItem(ModArmorMaterial.TIN, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> Tin_Boots = ITEMS.register("tin_boots",
            () -> new ArmorItem(ModArmorMaterial.TIN, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));


    // Blocks
    public static final RegistryObject<Block> Copper_Block = BLOCKS.register("copper_block", CopperBlock::new);
    public static final RegistryObject<Block> Copper_Ore = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> Paper_Block = BLOCKS.register("paper_block", PaperBlock::new);
    public static final RegistryObject<Block> Tin_Block = BLOCKS.register("tin_block", TinBlock::new);
    public static final RegistryObject<Block> Tin_Ore = BLOCKS.register("tin_ore", TinOre::new);

    // Blocks Items
    public static final RegistryObject<Item> Copper_Block_Item = ITEMS.register("copper_block", () -> new BlockItemBase(Copper_Block.get()));
    public static final RegistryObject<Item> Copper_Ore_Item = ITEMS.register("copper_ore", () -> new BlockItemBase(Copper_Ore.get()));
    public static final RegistryObject<Item> Paper_Block_Item = ITEMS.register("paper_block", () -> new BlockItemBase(Paper_Block.get()));
    public static final RegistryObject<Item> Tin_Block_Item = ITEMS.register("tin_block", () -> new BlockItemBase(Tin_Block.get()));
    public static final RegistryObject<Item> Tin_Ore_Item = ITEMS.register("tin_ore", () -> new BlockItemBase(Tin_Ore.get()));
}
