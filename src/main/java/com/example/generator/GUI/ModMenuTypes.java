package com.example.generator.GUI;

import com.example.generator.Generator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, Generator.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<WaterGeneratorMenu>> WATER_GENERATOR_MENU =
            MENUS.register("water_generator", () -> new MenuType<>((containerId, inventory) -> new WaterGeneratorMenu(containerId, inventory, ContainerLevelAccess.NULL), FeatureFlagSet.of()));

    public static void register(IEventBus modEventBus) {
        MENUS.register(modEventBus);
    }
}