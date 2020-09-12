package com.example.adam.armor;

import java.util.function.Supplier;

import com.example.adam.ToolMod;
import com.example.adam.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial {
    COPPER(ToolMod.MOD_ID + ":copper", 15, new int[] { 1, 3, 4, 1, }, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> { return Ingredient.fromItems(RegistryHandler.Copper_Ingot.get()); }, 0),
    EMERALD(ToolMod.MOD_ID + ":emerald", 30, new int[] { 3, 7, 10, 3, }, 15,
    SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F,  () -> { return Ingredient.fromItems(RegistryHandler.Copper_Ingot.get()); }, 0),
    TIN(ToolMod.MOD_ID + ":tin", 15, new int[] { 2, 4, 5, 2, }, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> { return Ingredient.fromItems(RegistryHandler.Tin_Ingot.get()); }, 0);

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return this.knockbackResistance;
    }
}