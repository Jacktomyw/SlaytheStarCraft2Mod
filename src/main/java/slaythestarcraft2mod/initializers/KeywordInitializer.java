package slaythestarcraft2mod.initializers;

import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.Keyword;

import basemod.BaseMod;

public class KeywordInitializer {

	public static final Logger logger = LogManager.getLogger(KeywordInitializer.class.getName());

	private static String localizationPath = "SlaytheStarCraft2ModResources/localization/";
	
	public static void addKeywords() {
		logger.info("Begin editting keywords");
		//TODO add keywords here
//		final String[] placeholder = { "keyword", "keywords", "Keyword", "Keywords" };
//        BaseMod.addKeyword(placeholder, "Whenever you play a card, gain 1 dexterity this turn only.");
		Gson gson = new Gson();
	    Keywords keywords;
	    switch(Settings.language) {
		case ZHS:{
			localizationPath += "zhs/";
			break;
		}
		case ENG:{
			localizationPath += "eng/";
			break;
		}
		default:{
			localizationPath += "eng/";
			break;
		}
		}
	    keywords = gson.fromJson(loadJson(localizationPath + "SlaytheStarCraft2Mod-Keyword-Strings.json"), Keywords.class);
	    for (Keyword key : keywords.keywords) {
	      logger.info("Loading keyword : " + key.NAMES[0]);
	      BaseMod.addKeyword(key.NAMES, key.DESCRIPTION);
	    }
		logger.info("Done editting keywords");
	}
	
	class Keywords {

	    Keyword[] keywords;
	  }
	
	private static String loadJson(String jsonPath) {
	    return Gdx.files.internal(jsonPath).readString(String.valueOf(StandardCharsets.UTF_8));
	  }
}

