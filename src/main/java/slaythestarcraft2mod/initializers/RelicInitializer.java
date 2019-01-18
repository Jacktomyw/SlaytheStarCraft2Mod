package slaythestarcraft2mod.initializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import basemod.BaseMod;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.relics.HeartofProtoss;
import slaythestarcraft2mod.relics.MiniVoidSeeker;

public class RelicInitializer {

	public static final Logger logger = LogManager.getLogger(RelicInitializer.class.getName());
	
	public static void addRelics() {
		
		//TODO add relics here
        // This adds a character specific relic. Only when you play with the mentioned color, will you get this relic.
        BaseMod.addRelicToCustomPool(new HeartofProtoss(), AbstractCardEnum.PROTOSS_BLUE);
        BaseMod.addRelicToCustomPool(new MiniVoidSeeker(), AbstractCardEnum.PROTOSS_BLUE);
        // This adds a relic to the Shared pool. Every character can find this relic.
        //BaseMod.addRelic(new PlaceholderRelic2(), RelicType.SHARED);

	}
}
