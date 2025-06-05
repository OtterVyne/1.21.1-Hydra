package net.ottervyne.hydra.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ottervyne.hydra.Hydra;
import net.ottervyne.hydra.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Hydra.MOD_ID);

    public static final Supplier<CreativeModeTab> HYDRA_ITEM_TAB = CREATIVE_MODE_TAB.register("hydra_items_tab",         () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TITANIUM.get()))
                    .title(Component.translatable("creativetab.hydra.hydra_item_tab"))
                    .displayItems((parameters, output) -> {
                        //ITEMS
            output.accept(ModItems.TITANIUM);
            output.accept(ModItems.RAW_TITANIUM);
            output.accept(ModItems.CHISEL);

            //BLOCKS
            output.accept(ModBlocks.TITANIUM_BLOCK);
            output.accept(ModBlocks.TITANIUM_ORE);
            output.accept(ModBlocks.TITANIUM_DEEPSLATE_ORE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
