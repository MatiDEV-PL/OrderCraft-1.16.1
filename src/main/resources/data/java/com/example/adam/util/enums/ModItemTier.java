package com.example.adam.util.enums;

import com.example.adam.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

  Copper_Ingot(1, 100, 4.0F, 1.0F, 4, () -> {
        return Ingredient.fromItems(RegistryHandler.Copper_Ingot.get());
    }),

    Aurora_Fragment(2, 800, 6.0F, 3.0F, 8, () -> {
        return Ingredient.fromItems(RegistryHandler.Aurora_Fragment.get());
    }),
    Emerald(3, 800, 9.5F, 4.0F, 10, () -> {
        return Ingredient.fromItems(new IItemProvider[]{Items.EMERALD});
    }),
    Tin(1, 200, 4.5F, 2.0F, 10, () -> {
        return Ingredient.fromItems(RegistryHandler.Tin_Ingot.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
