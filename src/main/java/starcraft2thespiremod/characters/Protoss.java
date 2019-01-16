package starcraft2thespiremod.characters;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
import starcraft2thespiremod.patches.AbstractCardEnum;
import starcraft2thespiremod.relics.HeartofProtoss;
import starcraft2thespiremod.StarCraft2theSpireMod;
import starcraft2thespiremod.cards.Basic_Defend_Protoss;
import starcraft2thespiremod.cards.Basic_Strike_Protoss;

public class Protoss extends CustomPlayer{
	public static final Logger logger = LogManager.getLogger(StarCraft2theSpireMod.class.getName());
	
	public static final int ENERGY_PER_TURN = 3;
    public static final int STARTING_HP = 75;
    public static final int MAX_HP = 75;
    public static final int STARTING_GOLD = 99;
    public static final int CARD_DRAW = 5;
    public static final int ORB_SLOTS = 0;
    
    public static final String[] orbTextures = {
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer1.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer2.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer3.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer4.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer5.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer6.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer1d.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer2d.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer3d.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer4d.png",
            "StarCraft2theSpireModResources/images/char/protoss/orb/layer5d.png", };
    
    public Protoss(String name, PlayerClass setClass) {
    	super(name,setClass,orbTextures,"StarCraft2theSpireModResources/images/char/protoss/orb/vfx.png",null,
    			new SpriterAnimation("StarCraft2theSpireModResources/images/char/protoss/Spriter/theDefaultAnimation.scml"));
    	
    	
    	initializeClass(null,
    			starcraft2thespiremod.StarCraft2theSpireMod.makePath(starcraft2thespiremod.StarCraft2theSpireMod.PROTOSS_SHOULDER),
    			starcraft2thespiremod.StarCraft2theSpireMod.makePath(starcraft2thespiremod.StarCraft2theSpireMod.PROTOSS_SHOULDER_AFTER),
    			starcraft2thespiremod.StarCraft2theSpireMod.makePath(starcraft2thespiremod.StarCraft2theSpireMod.PROTOSS_CORPSE),
    			getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));
    	
    	
    	this.loadAnimation(starcraft2thespiremod.StarCraft2theSpireMod.makePath(starcraft2thespiremod.StarCraft2theSpireMod.PROTOSS_SKELETON_ATLAS), 
    			starcraft2thespiremod.StarCraft2theSpireMod.makePath(starcraft2thespiremod.StarCraft2theSpireMod.PROTOSS_SKELETON_JSON),1.0f);
    	AnimationState.TrackEntry e = this.state.setAnimation(0, "animation", true);
    	e.setTime(e.getEndTime() * MathUtils.random());
    	
    	
    	
    	 this.dialogX = (this.drawX + 0.0F * Settings.scale); // set location for text bubbles
         this.dialogY = (this.drawY + 220.0F * Settings.scale); // you can just copy these values

    }
    
    @Override
    public CharSelectInfo getLoadout() {
    	return new CharSelectInfo("Protoss",
                "神族 NL " + "神之长子 ",
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
        return 0;
    }
    
 // Should return the card color enum to be associated with your character.
    @Override
    public AbstractCard.CardColor getCardColor() {
        return AbstractCardEnum.PROTOSS_BLUE;
    }
    
 // Should return a color object to be used to color the trail of moving cards
    @Override
    public Color getCardTrailColor() {
        return starcraft2thespiremod.StarCraft2theSpireMod.PROTOSS_BLUE;
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
        return "Protoss";
    }

    //Which starting card should specific events give you?
    @Override
    public AbstractCard getStartCardForEvent() {
    //    return new DefaultCommonAttack();
    	return null;
    }
    
 // The class name as it appears next to your player name in game	
    @Override
    public String getTitle(AbstractPlayer.PlayerClass playerClass) {
        return "Protoss";
    }

    // Should return a new instance of your character, sending this.name as its name parameter.
    @Override
    public AbstractPlayer newInstance() {
        return new Protoss(this.name, this.chosenClass);
    }
    
 // Should return a Color object to be used to color the miniature card images in run history.
    @Override
    public Color getCardRenderColor() {
        return starcraft2thespiremod.StarCraft2theSpireMod.PROTOSS_BLUE;
    }

    // Should return a Color object to be used as screen tint effect when your
    // character attacks the heart.
    @Override
    public Color getSlashAttackColor() {
        return starcraft2thespiremod.StarCraft2theSpireMod.PROTOSS_BLUE;
    }
    
 // Should return an AttackEffect array of any size greater than 0. These effects
    // will be played in sequence as your character's finishing combo on the heart.
    // Attack effects are the same as used in damage action and the like.
    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[] {
                AbstractGameAction.AttackEffect.BLUNT_HEAVY };
    }

    // Should return a string containing what text is shown when your character is
    // about to attack the heart. For example, the defect is "NL You charge your
    // core to its maximum..."
    @Override
    public String getSpireHeartText() {
        return "You touch the heart.";
    }

    // The vampire events refer to the base game characters as "brother", "sister",
    // and "broken one" respectively.This method should return a String containing
    // the full text that will be displayed as the first screen of the vampires event.
    @Override
    public String getVampireText() {
        return "Navigating an unlit street, you come across several hooded figures in the midst of some dark ritual. As you approach, they turn to you in eerie unison. The tallest among them bares fanged teeth and extends a long, pale hand towards you. NL ~\"Join~ ~us~ ~basic~ ~one,~ ~and~ ~feel~ ~the~ ~warmth~ ~of~ ~the~ ~Spire.\"~";
    }

}
