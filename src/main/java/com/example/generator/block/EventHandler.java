package com.example.generator.block;

import com.example.generator.block.entity.WaterGeneratorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.bus.api.IEventBus;

public class EventHandler {
    public EventHandler(IEventBus eventBus) {
        eventBus.addListener(this::onBlockRightClick);
    }

    @SubscribeEvent
    public void onBlockRightClick(PlayerInteractEvent event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();

        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof WaterGeneratorBlockEntity waterGeneratorBlockEntity) {
                MenuProvider menuProvider = new WaterGeneratorMenuProvider(waterGeneratorBlockEntity);
                player.openMenu(menuProvider);
            }
        }
    }
}
