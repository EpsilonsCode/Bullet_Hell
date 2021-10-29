package com.omicron.bullethell;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("bullethell")
public class BulletHell
{
    public static final DifficultyReloadManager difficultyReloadManager = new DifficultyReloadManager();

    public static final String MODID = "bullethell";

    public BulletHell() {
        register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(BulletHell::initClient);
        MinecraftForge.EVENT_BUS.addListener(this::addReloadListeners);
        MinecraftForge.EVENT_BUS.addListener(DifficultyReloadManager::tick);
    }

    private static void register(IEventBus bus)
    {
        EntityRegistry.register(bus);
    }

    private void addReloadListeners(AddReloadListenerEvent event)
    {
        event.addListener(difficultyReloadManager);
    }

    private static void initClient(final FMLCommonSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.ORB_ENTITY.get(), manager -> new SpriteRenderer(manager, Minecraft.getInstance().getItemRenderer(), 1.5F, true));
    }
}
