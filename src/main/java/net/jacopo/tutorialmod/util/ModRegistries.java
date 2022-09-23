package net.jacopo.tutorialmod.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.jacopo.tutorialmod.TutorialMod;
import net.jacopo.tutorialmod.item.ModItems;

public class ModRegistries {

    public static void registerModStuffs() {

        registerFuels();
    }

    private static void registerFuels() {

        System.out.println("Registering Fuels for " + TutorialMod.MOD_ID);

        FuelRegistry registry = FuelRegistry.INSTANCE;

        //value / 20
        registry.add(ModItems.COAL_SLIVER, 400);
    }
}
