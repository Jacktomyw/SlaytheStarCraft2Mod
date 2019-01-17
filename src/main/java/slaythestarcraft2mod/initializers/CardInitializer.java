package slaythestarcraft2mod.initializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.BaseMod;
import slaythestarcraft2mod.cards.protoss.Basic_Defend_Protoss;
import slaythestarcraft2mod.cards.protoss.Basic_Strike_Protoss;
import slaythestarcraft2mod.cards.protoss.BatterSlash;
import slaythestarcraft2mod.cards.protoss.BladeCharge;
import slaythestarcraft2mod.cards.protoss.BladeofSpace;
import slaythestarcraft2mod.cards.protoss.Blink;
import slaythestarcraft2mod.cards.protoss.DarknessApproach;
import slaythestarcraft2mod.cards.protoss.TearSlash;
import slaythestarcraft2mod.cards.protoss.VoidStrike;

public class CardInitializer {

	public static final Logger logger = LogManager.getLogger(CardInitializer.class.getName());
	public static void addDynamicVariables() {
        // TODO Add the Custom Dynamic Variables here
//        BaseMod.addDynamicVariable(new DefaultCustomVariable());
      
	}
	public static void addCards() {
		logger.info("Add Cards");
		// TODO add cards here;
        BaseMod.addCard(new Basic_Strike_Protoss());
        BaseMod.addCard(new Basic_Defend_Protoss());
        BaseMod.addCard(new BatterSlash());
        BaseMod.addCard(new BladeCharge());
        BaseMod.addCard(new BladeofSpace());
        BaseMod.addCard(new Blink());
        BaseMod.addCard(new DarknessApproach());
        BaseMod.addCard(new TearSlash());
        BaseMod.addCard(new VoidStrike());

	}
	
	public static void unlockCards() {
		logger.info("Making sure the cards are unlocked.");
        // TODO Unlock the cards here
        UnlockTracker.unlockCard(Basic_Strike_Protoss.ID);
        UnlockTracker.unlockCard(Basic_Defend_Protoss.ID);
        UnlockTracker.unlockCard(BatterSlash.ID);
        UnlockTracker.unlockCard(BladeCharge.ID);
        UnlockTracker.unlockCard(BladeofSpace.ID);
        UnlockTracker.unlockCard(Blink.ID);
        UnlockTracker.unlockCard(DarknessApproach.ID);
        UnlockTracker.unlockCard(TearSlash.ID);
        UnlockTracker.unlockCard(VoidStrike.ID);
        
	}
	
}
