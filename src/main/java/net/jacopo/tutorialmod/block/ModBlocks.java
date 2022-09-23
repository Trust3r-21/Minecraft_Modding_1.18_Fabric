package net.jacopo.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jacopo.tutorialmod.TutorialMod;
import net.jacopo.tutorialmod.block.custom.SpeedyBlock;
import net.jacopo.tutorialmod.item.ModTabs;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.jacopo.tutorialmod.item.ModTabs.TUTORIAL_MOD_BUILDING_BLOCKS;

public class ModBlocks {

    //Blocks
    public static final Block ORICHALCUM_BLOCK =  registerBlock("orichalcum_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModTabs.TUTORIAL_MOD_MATERIALS);

    public static final Block ORICHALCUM_ORE =  registerBlock("orichalcum_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5.5f).requiresTool()), ModTabs.TUTORIAL_MOD_MATERIALS);

    public static final Block DEEPSLATE_ORICHALCUM_ORE =  registerBlock("deepslate_orichalcum_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6.5f).requiresTool()), ModTabs.TUTORIAL_MOD_MATERIALS);

    public static final Block RAW_ORICHALCUM_BLOCK =  registerBlock("raw_orichalcum_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(7f).requiresTool()), ModTabs.TUTORIAL_MOD_MATERIALS);


    //Non-Blocks
    public static final Block ORICHALCUM_STAIRS =  registerBlock("orichalcum_stairs",
            new StairsBlock(ModBlocks.ORICHALCUM_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), TUTORIAL_MOD_BUILDING_BLOCKS);

    public static final Block ORICHALCUM_SLAB =  registerBlock("orichalcum_slab",
            new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), TUTORIAL_MOD_BUILDING_BLOCKS);

    public static final Block ORICHALCUM_BUTTON =  registerBlock("orichalcum_button",
            new StoneButtonBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), TUTORIAL_MOD_BUILDING_BLOCKS);

    public static final Block ORICHALCUM_PRESSURE_PLATE =  registerBlock("orichalcum_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), TUTORIAL_MOD_BUILDING_BLOCKS);

    public static final Block ORICHALCUM_FENCE =  registerBlock("orichalcum_fence",
            new FenceBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), TUTORIAL_MOD_BUILDING_BLOCKS);

    public static final Block ORICHALCUM_FENCE_GATE =  registerBlock("orichalcum_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), TUTORIAL_MOD_BUILDING_BLOCKS);

    public static final Block ORICHALCUM_WALL =  registerBlock("orichalcum_wall",
            new WallBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), TUTORIAL_MOD_BUILDING_BLOCKS);


    //Advanced Blocks
    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block", new SpeedyBlock(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModTabs.TUTORIAL_MOD_USEFUL_BLOCKS);

    //This method will register the block that we want to add to the game
    private static Block registerBlock(String unlocalizedName, Block properties, ItemGroup tab) {

        registerBlockItem(unlocalizedName, properties, tab);
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, unlocalizedName), properties);
    }

    //This method register the item block that we see in inventories
    private static Item registerBlockItem(String unlocalizedName, Block properties, ItemGroup tab) {

        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, unlocalizedName), new BlockItem(properties, new FabricItemSettings().group(tab)));
    }

    //This method is for declaring the modded things
    public static void registerModBlocks() {

        System.out.println("Registering BLOCK for: " + TutorialMod.MOD_ID);
    }
}
