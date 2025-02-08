package com.example.generator.block;

import com.example.generator.GUI.WaterGeneratorMenu;
import com.example.generator.block.entity.WaterGeneratorBlockEntity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.ContainerLevelAccess;
import org.jetbrains.annotations.NotNull;

public class WaterGeneratorMenuProvider implements MenuProvider {
    private final WaterGeneratorBlockEntity blockEntity;

    public WaterGeneratorMenuProvider(WaterGeneratorBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.literal("Water Generator");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, @NotNull Inventory inventory, @NotNull Player player) {
        return new WaterGeneratorMenu(containerId, inventory, ContainerLevelAccess.NULL);
    }
}
