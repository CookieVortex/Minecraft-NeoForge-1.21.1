package com.example.generator.block.entity;

import com.example.generator.Generator;
import com.example.generator.block.ModBlocks;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.registries.Registries;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Generator.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WaterGeneratorBlockEntity>> WATER_GENERATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("water_generator_block",
                    () -> BlockEntityType.Builder.of(WaterGeneratorBlockEntity::new, ModBlocks.WATER_GENERATOR_BLOCK.get()).build(null));
}