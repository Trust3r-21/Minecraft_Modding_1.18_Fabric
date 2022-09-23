package net.jacopo.tutorialmod.item.custom;

import net.jacopo.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//Is an item that scan all block under the clicked block and find the valuable
public class DowsingRodItem extends Item {

    //Super constructor
    public DowsingRodItem(Settings settings) {
        super(settings);
    }

    //This method will act when player click on a block
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        //The code will act only when we are on client
        if (context.getWorld().isClient()) {

            //some useful variables
            BlockPos posBlockClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            //It will scan all of the block from posY 0 to PosY of block clicked
            for (int i = 0; i <= posBlockClicked.getY(); i++) {

                BlockState stateDetected = context.getWorld().getBlockState(posBlockClicked.down(i));
                Block blockDetected = stateDetected.getBlock();

                //This if will act only when the valuable block was found
                if (isValuableBlock(stateDetected)) {

                    foundBlockMessage(posBlockClicked, player, blockDetected, i);
                    foundBlock = true;
                    break;
                }
            }

            //If wasn't found a block
            if (!foundBlock) {

                player.sendMessage(new TranslatableText("item.tutorialmod.dowsing_rod.message.no_block_found"), false);
            }
        }

        //This command damage the item for each click on block
        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()) {

            tooltip.add(new TranslatableText("item.tutorialmod.dowsing_rod.tooltip.shift"));
        }
        else {

            tooltip.add(new TranslatableText("item.tutorialmod.dowsing_rod.tooltip"));
        }
    }

    //This method send a message when valuable block is found
    private void foundBlockMessage(BlockPos blockPosClicked, PlayerEntity player, Block block, int i) {

        player.sendMessage(new TranslatableText("Found block: " + block.asItem().getName().getString() + " at (" +
                blockPosClicked.getX() + ", " + i + ", " + blockPosClicked.getZ() + ")"), false);
    }

    //This method check if the block in paremeter is valuable
    private boolean isValuableBlock(BlockState block) {

        return block.isIn(ModTags.Blocks.DOWSING_ROD_DETECTABLE_BLOCKS);
    }
}
