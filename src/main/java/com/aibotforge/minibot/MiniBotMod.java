package com.aibotforge.minibot;

import com.aibotforge.minibot.registry.ModEntities;
import com.aibotforge.minibot.registry.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MiniBotMod.MODID)
public class MiniBotMod {
    public static final String MODID = "minibot";

    public MiniBotMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::onAttributeCreate);
        modEventBus.addListener(this::addCreativeTabs);
    }

    private void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MINI_BOT.get(), ModEntities.createAttributes().build());
    }

    private void addCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.MINI_BOT_SPAWN_EGG.get());
        }
    }
}
