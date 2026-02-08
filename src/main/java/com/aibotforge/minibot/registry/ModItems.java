package com.aibotforge.minibot.registry;

import com.aibotforge.minibot.MiniBotMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.common.ForgeSpawnEggItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MiniBotMod.MODID);

    public static final RegistryObject<Item> MINI_BOT_SPAWN_EGG = ITEMS.register(
            "mini_bot_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MINI_BOT, 0x3b5ba9, 0x9fb6e0, new Item.Properties())
    );
}
