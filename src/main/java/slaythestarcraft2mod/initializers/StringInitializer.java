package slaythestarcraft2mod.initializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;

import basemod.BaseMod;

public class StringInitializer {

	public static final Logger logger = LogManager.getLogger(StringInitializer.class.getName());

	public static void addStrings() {

		logger.info("Begin editting strings");

        // CardStrings
        BaseMod.loadCustomStringsFile(CardStrings.class,
                "SlaytheStarCraft2ModResources/localization/SlaytheStarCraft2Mod-Card-Strings.json");

        // PowerStrings
        BaseMod.loadCustomStringsFile(PowerStrings.class,
                "SlaytheStarCraft2ModResources/localization/SlaytheStarCraft2Mod-Power-Strings.json");

        // RelicStrings
        BaseMod.loadCustomStringsFile(RelicStrings.class,
                "SlaytheStarCraft2ModResources/localization/SlaytheStarCraft2Mod-Relic-Strings.json");

        // PotionStrings
        BaseMod.loadCustomStringsFile(PotionStrings.class,
                "SlaytheStarCraft2ModResources/localization/SlaytheStarCraft2Mod-Potion-Strings.json");
        
        // EventStrings
        BaseMod.loadCustomStringsFile(EventStrings.class, 
        		"SlaytheStarCraft2ModResources/localization/SlaytheStarCraft2Mod-Event-Strings.json");
        logger.info("Done edittting strings");
	}
}
