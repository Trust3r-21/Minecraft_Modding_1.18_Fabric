package net.jacopo.tutorialmod.block.custom;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gl.EffectProgram;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.EffectCommand;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpeedyBlock extends Block {

    public SpeedyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        if(world.isClient) {

            PlayerEntity player;
            player =  (PlayerEntity) entity;

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200));
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if(world.isClient) {

            if(hand == Hand.MAIN_HAND) {

                player.sendMessage(new LiteralText( "From: CLIENT. " + Hand.MAIN_HAND + " used Speedy Block"), false);
            }
            else {

                player.sendMessage(new LiteralText( "From: CLIENT. " + Hand.OFF_HAND + " used Speedy Block"), false);
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
