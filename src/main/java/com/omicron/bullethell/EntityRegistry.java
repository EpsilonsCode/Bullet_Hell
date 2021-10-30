package com.omicron.bullethell;

import com.sun.org.apache.xpath.internal.operations.Or;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {

    public static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BulletHell.MODID);

    public static void register(IEventBus bus)
    {
        ENTITIES.register(bus);
    }

    public static RegistryObject<EntityType<OrbEntity>> ORB_ENTITY = ENTITIES.register("orb", () -> EntityType.Builder.of(OrbEntity::new, EntityClassification.MISC)
            .sized(0.25F, 0.25F)
            .build("orb"));

}
