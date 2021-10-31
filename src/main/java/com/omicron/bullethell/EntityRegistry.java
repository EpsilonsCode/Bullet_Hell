package com.omicron.bullethell;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {

    public static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BulletHell.MODID);

    public static void register(IEventBus bus)
    {
        ENTITIES.register(bus);
    }

    public static RegistryObject<EntityType<OrbEntity>> ORB_ENTITY = ENTITIES.register("orb", () -> EntityType.Builder.of(OrbEntity::new, EntityClassification.MISC)
            .sized(1.0F, 1.0F)
            .build("orb"));

}
