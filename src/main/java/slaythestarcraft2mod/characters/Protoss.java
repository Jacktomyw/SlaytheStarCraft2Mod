package slaythestarcraft2mod.characters;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.core.Settings.GameLanguage;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.cards.protoss.*;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.relics.HeartofProtoss;

public class Protoss extends CustomPlayer{
	
	public static final int ENERGY_PER_TURN = 3;
    public static final int STARTING_HP = 75;
    public static final int MAX_HP = 75;
    public static final int STARTING_GOLD = 99;
    public static final int CARD_DRAW = 5;
    public static final int ORB_SLOTS = 0;
    
    public static final String[] orbTextures = {
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer1.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer2.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer3.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer4.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer5.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer6.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer1d.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer2d.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer3d.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer4d.png",
            "SlaytheStarCraft2ModResources/images/char/protoss/orb/layer5d.png", };
    
    public Protoss(String name, PlayerClass setClass) {
    	super(name,setClass,orbTextures,"SlaytheStarCraft2ModResources/images/char/protoss/orb/vfx.png",null,null,null);
    	
    	
    	initializeClass(ImgInitializer.makePath(ImgInitializer.PORTOSS_MAIN),
    			ImgInitializer.makePath(ImgInitializer.PROTOSS_SHOULDER_AFTER),
    			ImgInitializer.makePath(ImgInitializer.PROTOSS_SHOULDER),
    			ImgInitializer.makePath(ImgInitializer.PROTOSS_CORPSE),
    			getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));
    	 
    	 this.dialogX = (this.drawX + 0.0F * Settings.scale); 
         this.dialogY = (this.drawY + 220.0F * Settings.scale); 

    }
    
    @Override
    public CharSelectInfo getLoadout() {
    	return new CharSelectInfo("Protoss",
                "神之长子，纯粹的本质。 NL 为了艾尔！En Taro Adun！ ",
                STARTING_HP, MAX_HP, ORB_SLOTS, STARTING_GOLD, CARD_DRAW, this, getStartingRelics(),
                getStartingDeck(), false);
    }
    
    @Override
    public ArrayList<String> getStartingDeck(){
    	ArrayList<String> retVal = new ArrayList<>();
    	
    	retVal.add(Basic_Strike_Protoss.ID);
    	retVal.add(Basic_Strike_Protoss.ID);
    	retVal.add(Basic_Strike_Protoss.ID);
    	retVal.add(Basic_Strike_Protoss.ID);
    	retVal.add(Basic_Defend_Protoss.ID);
    	retVal.add(Basic_Defend_Protoss.ID);
    	retVal.add(Basic_Defend_Protoss.ID);
    	retVal.add(Basic_Defend_Protoss.ID);
    	
    	return retVal;
    }
    
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();

        retVal.add(HeartofProtoss.ID);
        UnlockTracker.markRelicAsSeen(HeartofProtoss.ID);
        
        return retVal;
    }
    
 // Character select screen effect
    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("ATTACK_DAGGER_1", 1.25f); // Sound Effect
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT,
                false); // Screen Effect
    }
    
 // Character select on-button-press sound effect
    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "ATTACK_DAGGER_1";
    }
    
 // Should return how much HP your maximum HP reduces by when starting a run at
    // ascension 14 or higher. (ironclad loses 5, defect and silent lose 4 hp respectively)
    @Override
    public int getAscensionMaxHPLoss() {
        return 4;
    }
    
 // Should return the card color enum to be associated with your character.
    @Override
    public AbstractCard.CardColor getCardColor() {
        return AbstractCardEnum.PROTOSS_BLUE;
    }
    
 // Should return a color object to be used to color the trail of moving cards
    @Override
    public Color getCardTrailColor() {
        return slaythestarcraft2mod.SlaytheStarCraft2Mod.PROTOSS_BLUE;
    }

    // Should return a BitmapFont object that you can use to customize how your
    // energy is displayed from within the energy orb.
    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontBlue;
    }
    
 // Should return class name as it appears in run history screen.
    @Override
    public String getLocalizedCharacterName() {
    	if (Settings.language == GameLanguage.ZHS) {
			return "神族";
		}else {
			return "Protoss";
		}
    }

    //Which starting card should specific events give you?
    @Override
    public AbstractCard getStartCardForEvent() {
    	HeartofProtoss r = (HeartofProtoss) this.getRelic(SlaytheStarCraft2Mod.makeID("HeartofProtoss"));
    	
    	switch(r.SELECTED_LEADER) {
    	
    	case "Zeratul": return new ShadowStrike();
    	case "Alarak": return new OblivionWave();
    	default: return new Basic_Strike_Protoss();
    	}
    }
    
 // The class name as it appears next to your player name in game	
    @Override
    public String getTitle(AbstractPlayer.PlayerClass playerClass) {
    	if (Settings.language == GameLanguage.ZHS) {
			return "神族";
		}else {
			return "Protoss";
		}
    }

    // Should return a new instance of your character, sending this.name as its name parameter.
    @Override
    public AbstractPlayer newInstance() {
        return new Protoss(this.name, this.chosenClass);
    }
    
 // Should return a Color object to be used to color the miniature card images in run history.
    @Override
    public Color getCardRenderColor() {
        return slaythestarcraft2mod.SlaytheStarCraft2Mod.PROTOSS_BLUE;
    }

    // Should return a Color object to be used as screen tint effect when your
    // character attacks the heart.
    @Override
    public Color getSlashAttackColor() {
        return slaythestarcraft2mod.SlaytheStarCraft2Mod.PROTOSS_BLUE;
    }
    
 // Should return an AttackEffect array of any size greater than 0. These effects
    // will be played in sequence as your character's finishing combo on the heart.
    // Attack effects are the same as used in damage action and the like.
    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[] {
                AbstractGameAction.AttackEffect.SLASH_DIAGONAL };
    }

    // Should return a string containing what text is shown when your character is
    // about to attack the heart. For example, the defect is "NL You charge your
    // core to its maximum..."
    @Override
    public String getSpireHeartText() {
    	if (Settings.language == GameLanguage.ZHS) {
			return "你将你的灵刃充能到极限……";
		}else {
			return "You charge your psionic blade to its maximum...";
		}
    }

    // The vampire events refer to the base game characters as "brother", "sister",
    // and "broken one" respectively.This method should return a String containing
    // the full text that will be displayed as the first screen of the vampires event.
    @Override
    public String getVampireText() {
    	if (Settings.language == GameLanguage.ZHS) {
			return "在一条昏暗的街上，你遇见几个戴着兜帽的人在进行某种黑暗的仪式。当你靠近时，他们全都同时转身面对你，让你觉得十分诡异。 其中个子最高的一个微微一笑，露出了长长的尖牙，向你伸出了一只苍白而瘦长的手： NL ~“加入我们，神之长子。一起来感受高塔的温暖吧。”~";
		}else {
			return "Navigating an unlit street, you come across several hooded figures in the midst of some dark ritual. As you approach, they turn to you in eerie unison. The tallest among them bares fanged teeth and extends a long, pale hand towards you. NL ~\"Join~ ~us~ ~son~ ~of~ ~gods,~ ~and~ ~feel~ ~the~ ~warmth~ ~of~ ~the~ ~Spire.\"~";
		}
    }

}
