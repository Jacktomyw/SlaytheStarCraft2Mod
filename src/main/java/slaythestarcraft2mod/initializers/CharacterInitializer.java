package slaythestarcraft2mod.initializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import basemod.BaseMod;
import slaythestarcraft2mod.characters.*;
import slaythestarcraft2mod.patches.*;

public class CharacterInitializer {
	
	//buttons
    public static final String PROTOSS_BUTTON = ImgInitializer.makeExample("charSelect/ProtossButton");
    //backgrounds
    public static final String PROTOSS_BACKGROUND = ImgInitializer.makeExample("charSelect/ProtossBG");
    
	public static final Logger logger = LogManager.getLogger(CharacterInitializer.class.getName());

	public static void addCharacters() {
		//TODO add characters here
				logger.info("begin editing characters. " + "Add " + ProtossEnum.PROTOSS.toString());
				
			    BaseMod.addCharacter(new Protoss("Protoss", ProtossEnum.PROTOSS),
			    		ImgInitializer.makePath(PROTOSS_BUTTON), ImgInitializer.makePath(PROTOSS_BACKGROUND), ProtossEnum.PROTOSS);

				//TODO add character-class potions here
//				logger.info("begin editing potions");
//			       
//		      BaseMod.addPotion(PlaceholderPotion.class, PLACEHOLDER_POTION_lIQUID, PLACEHOLDER_POTION_HYBRID, PLACEHOLDER_POTION_SPOTS, PlaceholderPotion.POTION_ID, TheDefaultEnum.THE_DEFAULT);
//		      
//		      logger.info("end editing potions");
			    logger.info("done editing characters");
			
	}
}
