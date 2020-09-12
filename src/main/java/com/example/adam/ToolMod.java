
package com.example.adam;


import com.example.adam.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod("toolmod")
public class ToolMod {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "toolmod";

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("toolmod", "toolmod"),
            () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public TransparentBlock elements;
    public ToolMod() {
        elements = new TransparentBlock();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
        FMLJavaModLoadingContext.get().getModEventBus().register(this);

        RegistryHandler.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
       RegistryHandler.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void init(FMLCommonSetupEvent event) {
        elements.getElements().forEach(element -> element.init(event));
    }
    public void serverLoad(FMLServerStartingEvent event) {
        elements.getElements().forEach(element -> element.serverLoad(event));
    }
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void clientLoad(FMLClientSetupEvent event) {
        elements.getElements().forEach(element -> element.clientLoad(event));
    }
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(elements.getBlocks().stream().map(Supplier::get).toArray(Block[]::new));
    }
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(elements.getItems().stream().map(Supplier::get).toArray(Item[]::new));
    }
    @SubscribeEvent
    public void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().registerAll(elements.getBiomes().stream().map(Supplier::get).toArray(Biome[]::new));
    }
    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(elements.getEntities().stream().map(Supplier::get).toArray(EntityType[]::new));
    }
    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(elements.getEnchantments().stream().map(Supplier::get).toArray(Enchantment[]::new));
    }
    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
        elements.registerSounds(event);
    }
}
