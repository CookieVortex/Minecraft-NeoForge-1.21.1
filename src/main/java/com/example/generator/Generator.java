package com.example.generator;

import com.example.generator.GUI.ModMenuTypes;
import com.example.generator.GUI.WaterGeneratorScreen;
import com.example.generator.block.ModBlocks;
import com.example.generator.block.entity.ModBlockEntities;
import com.example.generator.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.jetbrains.annotations.NotNull;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Generator.MODID)
public class Generator {
    public static final String MODID = "examplemod";

    public Generator(IEventBus modEventBus) {
        ModBlocks.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModMenuTypes.MENUS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    @EventBusSubscriber(modid = Generator.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onRegisterMenuScreens(@NotNull RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.WATER_GENERATOR_MENU.get(), WaterGeneratorScreen::new);
        }
    }

    private void addCreative(@NotNull BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS) ||
                event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            event.accept(new ItemStack(ModBlocks.WATER_GENERATOR_BLOCK.get()));
        }

    }
}
