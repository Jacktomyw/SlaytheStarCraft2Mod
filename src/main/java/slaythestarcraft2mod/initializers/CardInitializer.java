package slaythestarcraft2mod.initializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.BaseMod;
import slaythestarcraft2mod.cards.protoss.*;
import slaythestarcraft2mod.variables.*;

public class CardInitializer {

	public static final Logger logger = LogManager.getLogger(CardInitializer.class.getName());
	public static void addDynamicVariables() {
        // TODO Add the Custom Dynamic Variables here
        BaseMod.addDynamicVariable(new Damage2Variable());
        BaseMod.addDynamicVariable(new Block2Variable());
        BaseMod.addDynamicVariable(new MagicNumber2Variable());
        BaseMod.addDynamicVariable(new ShieldVariable());
      
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
        BaseMod.addCard(new GiftsfromXelNaga());
        BaseMod.addCard(new IntotheShadow());
        BaseMod.addCard(new MasterGradeWarppingBlade());
        BaseMod.addCard(new Meditation());
        BaseMod.addCard(new OblivionDescends());
        BaseMod.addCard(new PowerofNerazim());
        BaseMod.addCard(new PsionicLightBlade());
        BaseMod.addCard(new ShadowBarrier());
        BaseMod.addCard(new ShadowRush());
        BaseMod.addCard(new ShadowStrike());
        BaseMod.addCard(new SingularityStub());
        BaseMod.addCard(new TearSlash());
        BaseMod.addCard(new TwilightDescends());
        BaseMod.addCard(new VoidImprison());
        BaseMod.addCard(new VoidPowerCannon());
        BaseMod.addCard(new VoidSneakAttack());
        BaseMod.addCard(new VoidSpiralBall());
        BaseMod.addCard(new VoidStrike());
        BaseMod.addCard(new WayofDarkTemplar());
        BaseMod.addCard(new Wormhole());
        BaseMod.addCard(new XelNagaProphecy());
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
        UnlockTracker.unlockCard(GiftsfromXelNaga.ID);
        UnlockTracker.unlockCard(IntotheShadow.ID);
        UnlockTracker.unlockCard(MasterGradeWarppingBlade.ID);
        UnlockTracker.unlockCard(Meditation.ID);
        UnlockTracker.unlockCard(OblivionDescends.ID);
        UnlockTracker.unlockCard(PowerofNerazim.ID);
        UnlockTracker.unlockCard(PsionicLightBlade.ID);
        UnlockTracker.unlockCard(ShadowBarrier.ID);
        UnlockTracker.unlockCard(ShadowRush.ID);
        UnlockTracker.unlockCard(ShadowStrike.ID);
        UnlockTracker.unlockCard(SingularityStub.ID);
        UnlockTracker.unlockCard(TearSlash.ID);
        UnlockTracker.unlockCard(TwilightDescends.ID);
        UnlockTracker.unlockCard(VoidImprison.ID);
        UnlockTracker.unlockCard(VoidPowerCannon.ID);
        UnlockTracker.unlockCard(VoidSneakAttack.ID);
        UnlockTracker.unlockCard(VoidSpiralBall.ID);
        UnlockTracker.unlockCard(VoidStrike.ID);
        UnlockTracker.unlockCard(WayofDarkTemplar.ID);
        UnlockTracker.unlockCard(Wormhole.ID);
        UnlockTracker.unlockCard(XelNagaProphecy.ID);
        
	}
	
}
