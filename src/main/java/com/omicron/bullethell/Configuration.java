package com.omicron.bullethell;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Configuration {

    public static final String CATEGORY_ORB = "orb";

    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.IntValue ORB_LIFE_TIME;

    static
    {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

        SERVER_BUILDER.comment("Orb entity config").push(CATEGORY_ORB);

        ORB_LIFE_TIME = SERVER_BUILDER.comment("Number of blocks away from nearest player to despawn")
                .defineInRange("lifetime", 60, 0, Integer.MAX_VALUE);

        SERVER_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent)
    {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Reloading configEvent)
    {

    }

}
