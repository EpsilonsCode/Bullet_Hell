package com.omicron.bullethell;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.command.FunctionObject;
import net.minecraft.loot.LootSerializers;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.FunctionReloader;
import net.minecraft.resources.IResourceManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DifficultyReloadManager extends JsonReloadListener {

    private static final Gson GSON = LootSerializers.createLootTableSerializer().create();

    private static final ResourceLocation PEACEFUL_FUNCTION_TAG = new ResourceLocation("peaceful");
    private static final ResourceLocation EASY_FUNCTION_TAG = new ResourceLocation("easy");
    private static final ResourceLocation NORMAL_FUNCTION_TAG = new ResourceLocation("normal");
    private static final ResourceLocation HARD_FUNCTION_TAG = new ResourceLocation("hard");

    private static final List<FunctionObject> tickingPeaceful = Lists.newArrayList();
    private static final List<FunctionObject> tickingEasy = Lists.newArrayList();
    private static final List<FunctionObject> tickingNormal = Lists.newArrayList();
    private static final List<FunctionObject> tickingHard = Lists.newArrayList();
    private static boolean isReloaded = false;

    public DifficultyReloadManager() {
        super(GSON, "tags/functions");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> pObject, IResourceManager pResourceManager, IProfiler pProfiler) {
        isReloaded = true;
    }

    public static void tick(TickEvent.ServerTickEvent event)
    {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        FunctionReloader library = server.getFunctions().library;
        if(isReloaded)
        {
            System.out.println("reload");
            isReloaded = false;
            tickingPeaceful.clear();
            tickingPeaceful.addAll(library.getTags().getTagOrEmpty(PEACEFUL_FUNCTION_TAG).getValues());

            tickingEasy.clear();
            tickingEasy.addAll(library.getTags().getTagOrEmpty(EASY_FUNCTION_TAG).getValues());

            tickingNormal.clear();
            tickingNormal.addAll(library.getTags().getTagOrEmpty(NORMAL_FUNCTION_TAG).getValues());

            tickingHard.clear();
            tickingHard.addAll(library.getTags().getTagOrEmpty(HARD_FUNCTION_TAG).getValues());
        }
        net.minecraft.world.Difficulty difficulty = server.getWorldData().getDifficulty();
        switch(difficulty)
        {
            case PEACEFUL:
            {
                executeTagFunctions(tickingPeaceful, PEACEFUL_FUNCTION_TAG);
                break;
            }
            case EASY:
            {
                executeTagFunctions(tickingEasy, EASY_FUNCTION_TAG);
                break;
            }
            case NORMAL:
            {
                executeTagFunctions(tickingNormal, NORMAL_FUNCTION_TAG);
                break;
            }
            case HARD:
            {
                executeTagFunctions(tickingHard, HARD_FUNCTION_TAG);
                break;
            }
        }

    }

    private static void executeTagFunctions(Collection<FunctionObject> pFunctionObjects, ResourceLocation pIdentifier) {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        server.getProfiler().push(pIdentifier::toString);

        for(FunctionObject functionobject : pFunctionObjects) {
            server.getFunctions().execute(functionobject, server.getFunctions().getGameLoopSender());
        }

        server.getProfiler().pop();
    }
}
