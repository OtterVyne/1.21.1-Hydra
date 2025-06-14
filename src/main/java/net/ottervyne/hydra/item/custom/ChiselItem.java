package net.ottervyne.hydra.item.custom;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.ottervyne.hydra.block.ModBlocks;

import java.util.Map;

public class ChiselItem extends Item {


    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.STONE_SLAB, Blocks.STONE_BRICK_SLAB,
                    Blocks.STONE_STAIRS, Blocks.STONE_BRICK_STAIRS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    ModBlocks.TITANIUM_ORE.get(), ModBlocks.TITANIUM_DEEPSLATE_ORE.get(),
                    ModBlocks.TITANIUM_BLOCK.get(), ModBlocks.TITANIUM_DEEPSLATE_ORE.get()
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
    if (CHISEL_MAP.containsKey(clickedBlock)) {
        if (!level.isClientSide()) {
            level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
            
            context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                    item ->  context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            level.playSound(
                    null,
                    context.getClickedPos(),
                    SoundEvents.GRINDSTONE_USE,
                    SoundSource.BLOCKS,
                    1.0F,
                    0.5F
            );
        }
    }
        return super.useOn(context);
    }
}
