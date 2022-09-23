package net.jacopo.tutorialmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.jacopo.tutorialmod.TutorialMod;
import net.jacopo.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.lwjgl.system.CallbackI;

public class ModTabs {

    //In this tab will be contained all materials of the mod
    public static final ItemGroup TUTORIAL_MOD_MATERIALS = FabricItemGroupBuilder.build(new Identifier(TutorialMod.MOD_ID, "tutorial_mod_materials"),
            () -> new ItemStack(ModItems.ORICHALCUM_INGOT));

    public static final ItemGroup TUTORIAL_MOD_TOOLS = FabricItemGroupBuilder.build(new Identifier(TutorialMod.MOD_ID, "tutorial_mod_tools"),
            () -> new ItemStack(ModItems.DOWSING_ROD));

    public static final ItemGroup TUTORIAL_MOD_USEFUL_BLOCKS = FabricItemGroupBuilder.build(new Identifier(TutorialMod.MOD_ID, "tutorial_mod_useful_blocks"),
            () -> new ItemStack(ModBlocks.SPEEDY_BLOCK));

    public static final ItemGroup TUTORIAL_MOD_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(TutorialMod.MOD_ID, "tutorial_mod_building_blocks"),
            () -> new ItemStack(ModBlocks.ORICHALCUM_STAIRS));
}
