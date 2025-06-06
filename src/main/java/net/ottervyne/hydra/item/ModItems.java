package net.ottervyne.hydra.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ottervyne.hydra.Hydra;
import net.ottervyne.hydra.item.custom.ChiselItem;
import net.ottervyne.hydra.item.custom.FuelItem;


public class ModItems {
public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Hydra.MOD_ID);

public static final DeferredItem<Item> TITANIUM = ITEMS.register("titanium",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_TITANIUM = ITEMS.register("impure_titanium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
            () -> new Item(new Item.Properties()));

    //ITEMS WITH CUSTOM DATA
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> TITANIUM_DUST = ITEMS.register("titanium_dust",
            () -> new FuelItem(new Item.Properties(), 720));
    public static final DeferredItem<Item> TITANIUM_APPLE = ITEMS.register("titanium_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TITANIUM_APPLE)));


public static void register(IEventBus eventBus){
    ITEMS.register(eventBus);
}
}
