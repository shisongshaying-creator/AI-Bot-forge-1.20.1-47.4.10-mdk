package com.aibotforge.minibot.registry;

import com.aibotforge.minibot.MiniBotMod;
import com.aibotforge.minibot.entity.MiniBotEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MiniBotMod.MODID);

    public static final RegistryObject<EntityType<MiniBotEntity>> MINI_BOT = ENTITY_TYPES.register(
            "mini_bot",
            () -> EntityType.Builder.of(MiniBotEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.8f)
                    .build("mini_bot")
    );

    public static AttributeSupplier.Builder createAttributes() {
        return MiniBotEntity.createAttributes();
    }
}
