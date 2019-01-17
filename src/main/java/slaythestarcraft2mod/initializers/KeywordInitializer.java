package slaythestarcraft2mod.initializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeywordInitializer {

	public static final Logger logger = LogManager.getLogger(KeywordInitializer.class.getName());
	
	public static void addKeywords() {
		logger.info("Begin editting keywords");
		//TODO add keywords here
//		final String[] placeholder = { "keyword", "keywords", "Keyword", "Keywords" };
//        BaseMod.addKeyword(placeholder, "Whenever you play a card, gain 1 dexterity this turn only.");

		logger.info("Done editting keywords");
	}
}
