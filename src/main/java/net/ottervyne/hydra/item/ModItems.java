package net.ottervyne.hydra.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ottervyne.hydra.Hydra;
import net.ottervyne.hydra.item.custom.ChiselItem;

public class ModItems {
public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Hydra.MOD_ID);

public static final DeferredItem<Item> TITANIUM = ITEMS.register("titanium",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));



public static void register(IEventBus eventBus){
    ITEMS.register(eventBus);
}
}
