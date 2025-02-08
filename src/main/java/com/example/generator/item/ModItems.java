package com.example.generator.item;

import com.example.generator.Generator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Generator.MODID);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}
