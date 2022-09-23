package net.jacopo.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.jacopo.tutorialmod.block.ModBlocks;
import net.jacopo.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {

	//This is the MOD ID
	public static final String MOD_ID =  "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {

		//Declaring modded things
		//The order of the code means that the game will load ModItems first
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
