package net.jacopo.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jacopo.tutorialmod.TutorialMod;
import net.jacopo.tutorialmod.item.custom.DowsingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Items
    public static final Item ORICHALCUM_INGOT = registerItem("orichalcum_ingot",  /*properties*/ new Item(new FabricItemSettings().group(ModTabs.TUTORIAL_MOD_MATERIALS)));
    public static final Item ORICHALCUM_NUGGET = registerItem("orichalcum_nugget",  /*properties*/ new Item(new FabricItemSettings().group(ModTabs.TUTORIAL_MOD_MATERIALS)));
    public static final Item RAW_ORICHALCUM = registerItem("raw_orichalcum",  /*properties*/ new Item(new FabricItemSettings().group(ModTabs.TUTORIAL_MOD_MATERIALS)));

    //Foods
    public static final Item TURNIP = registerItem("turnip", /*properties*/ new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.TURNIP)));

    //Advanced Items
    public static final Item DOWSING_ROD = registerItem("dowsing_rod", /*properties*/ new DowsingRodItem(new FabricItemSettings().group(ModTabs.TUTORIAL_MOD_TOOLS).maxDamage(32)));

    //Fuels
    public static final Item COAL_SLIVER = registerItem("coal_sliver", /*properties*/ new Item(new FabricItemSettings().group(ModTabs.TUTORIAL_MOD_MATERIALS)));

    //This method will register the item that we want to add to the game
    private static Item registerItem(String unlocalizedName, Item properties) {

        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, unlocalizedName), properties);
    }

    //This method is for declaring the modded things
    public static void registerModItems() {

        System.out.println("Registering ITEM for: " + TutorialMod.MOD_ID);
    }
}
