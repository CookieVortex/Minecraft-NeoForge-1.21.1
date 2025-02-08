package com.example.generator.GUI;

import com.example.generator.block.entity.WaterGeneratorBlockEntity;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class WaterGeneratorMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess levelAccess;

    public WaterGeneratorMenu(int id, Inventory playerInventory, ContainerLevelAccess levelAccess) {
        super(ModMenuTypes.WATER_GENERATOR_MENU.get(), id);
        this.levelAccess = levelAccess;

        // Добавляем слот для блока
        levelAccess.evaluate((level, pos) -> {
            if (level.getBlockEntity(pos) instanceof WaterGeneratorBlockEntity blockEntity) {
                this.addSlot(new Slot((Container) blockEntity, 0, 80, 35));
            }
            return null;
        });

        // Добавляем слоты инвентаря игрока
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Быстрые слоты
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true; // Убедитесь, что проверка валидности работает
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}
