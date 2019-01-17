package slaythestarcraft2mod.initializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PotionInitializer {

    // Potion Colors in RGB
    //TODO these codes will be rewrite after potions have been designed
    //TODO add potions' colors here
    //    public static final Color PLACEHOLDER_POTION_LIQUID = CardHelper.getColor(209.0f, 53.0f, 18.0f); // Orange-ish Red 
    //    public static final Color PLACEHOLDER_POTION_HYBRID = CardHelper.getColor(255.0f, 230.0f, 230.0f); // Near White
    //    public static final Color PLACEHOLDER_POTION_SPOTS = CardHelper.getColor(100.0f, 25.0f, 10.0f); // Super Dark Red/Brown
    
	public static final Logger logger = LogManager.getLogger(PotionInitializer.class.getName());
	
	public static void addPotions() {
		//TODO add non-character-class potions here
        logger.info("begin editing non-character-class potions");
		//BaseMod.addPotion(PlaceholderPotion.class, PLACEHOLDER_POTION_LIQUID, PLACEHOLDER_POTION_HYBRID, PLACEHOLDER_POTION_SPOTS, PlaceholderPotion.POTION_ID);
        logger.info("end editing non-character-class potions");
	}
}
