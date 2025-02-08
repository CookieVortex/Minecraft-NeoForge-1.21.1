package com.example.generator.block;

import com.example.generator.block.entity.WaterGeneratorBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import org.jetbrains.annotations.Nullable;

public class WaterGeneratorBlock extends BaseEntityBlock {
    private static final Logger LOGGER = LogUtils.getLogger();

    protected WaterGeneratorBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WaterGeneratorBlockEntity(pos, state);
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }


    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        LOGGER.info("Попытка открыть меню для блока на позиции: {}", pos);

        if (level.isClientSide) {
            LOGGER.info("Клиентская сторона: Блок на позиции {} был кликнут", pos);
        } else {
            LOGGER.info("Серверная сторона: Блок на позиции {} был кликнут", pos);
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity != null) {
            LOGGER.info("Найден BlockEntity на позиции {}", pos);
        } else {
            LOGGER.error("Не найден BlockEntity на позиции {}", pos);
        }

        if (blockEntity instanceof WaterGeneratorBlockEntity) {
            LOGGER.info("Открываем GUI WaterGeneratorBlock в позиции: {}", pos);
            player.openMenu(new WaterGeneratorMenuProvider((WaterGeneratorBlockEntity) blockEntity));
            return InteractionResult.CONSUME;
        } else {
            LOGGER.error("BlockEntity отсутствует или неправильного типа в позиции {}", pos);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}