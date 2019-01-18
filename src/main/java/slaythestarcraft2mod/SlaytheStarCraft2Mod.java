package slaythestarcraft2mod;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.map.MapRoomNode;
import com.megacrit.cardcrawl.rooms.EventRoom;
import basemod.BaseMod;
import basemod.ModLabel;
import basemod.ModPanel;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import slaythestarcraft2mod.initializers.*;
import slaythestarcraft2mod.patches.*;

@SpireInitializer
public class SlaytheStarCraft2Mod implements EditCharactersSubscriber, EditCardsSubscriber, EditStringsSubscriber,
		EditRelicsSubscriber, EditKeywordsSubscriber, PostInitializeSubscriber {
	
	public static final Logger logger = LogManager.getLogger(SlaytheStarCraft2Mod.class.getName());

//This is for the in-game mod settings pannel.
    private static final String MODNAME = "Slay the StarCraft II Mod";
    private static final String AUTHOR = "Jacktomyw";
    private static final String DESCRIPTION = "This is a mod for Slay the Spire in a STARCRAFT II theme.";
    
//=======================INPUT TEXTURE LOCATION========================
// Colors (RGB)
    // Character Color
    
    public static final Color PROTOSS_BLUE = CardHelper.getColor(0.0f, 162.0f, 232.0f);
    
//see others in ImgInitializer.java

//================================SUBSCRIBE, CREATE THE COLOR, INITIALIZE =========================
    
	public SlaytheStarCraft2Mod() {
		
		logger.info("Subscribe to basemod hooks");
		
		BaseMod.subscribe(this);
		
		logger.info("Done subscribing");
		//TODO add colors here
        logger.info("Creating the color " + AbstractCardEnum.PROTOSS_BLUE.toString());

		BaseMod.addColor(AbstractCardEnum.PROTOSS_BLUE, PROTOSS_BLUE, PROTOSS_BLUE, PROTOSS_BLUE,
				PROTOSS_BLUE, PROTOSS_BLUE, PROTOSS_BLUE, PROTOSS_BLUE,
				ImgInitializer.makePath(ImgInitializer.ATTACK_PROTOSS_BLUE), ImgInitializer.makePath(ImgInitializer.SKILL_PROTOSS_BLUE),
				ImgInitializer.makePath(ImgInitializer.POWER_PROTOSS_BLUE),	ImgInitializer.makePath(ImgInitializer.ENERGY_ORB_PROTOSS_BLUE),
				ImgInitializer.makePath(ImgInitializer.ATTACK_PROTOSS_BLUE_PORTRAIT), ImgInitializer.makePath(ImgInitializer.SKILL_PROTOSS_BLUE_PORTRAIT), 
				ImgInitializer.makePath(ImgInitializer.POWER_PROTOSS_BLUE_PORTRAIT), ImgInitializer.makePath(ImgInitializer.ENERGY_ORB_PROTOSS_BLUE_PORTRAIT), 
				ImgInitializer.makePath(ImgInitializer.CARD_PROTOSS_BLUE_ENERGY_ORB));
		
		logger.info("Done Creating the color");
		
	}
	
	public static void initialize() {
		logger.info("===================== Initializing Slay the StarCraft2 Mod =========================== ");
		new SlaytheStarCraft2Mod();
		logger.info("===================== Slay the StarCraft2 Mod Initialized ============================ ");
	}

	//=================== LOAD THE CHARACTER ==================
	
	@Override
	public void receiveEditCharacters() {
		CharacterInitializer.addCharacters();
	}
	
	//=================== POST-INITIALIZE, ADD NON-CHARACTER-CLASS POTIONS ==================
	
	@Override
	public void receivePostInitialize() {
		logger.info("Load Badge Image and mod options");
        // Load the Mod Badge
        Texture badgeTexture = new Texture(ImgInitializer.makePath(ImgInitializer.BADGE_IMAGE));
        
        // Create the Mod Menu
        ModPanel settingsPanel = new ModPanel();
        //TODO change mod badge settings here
        settingsPanel.addUIElement(new ModLabel("This mod doesn't have any settings yet!", 400.0f, 700.0f,
                settingsPanel, (me) -> {
                }));
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);

        logger.info("Done loading badge Image and mod options");

        logger.info("Add events");
//        BaseMod.addEvent(ProtossLeaders.ID, ProtossLeaders.class);
        
		receiveEditPotions();

	}
	
	//=================== ADD NON-CHARACTER-CLASS POTIONS ==================
	public void receiveEditPotions() {
		
        logger.info("begin editing non-character-class potions");
        PotionInitializer.addPotions();
        logger.info("end editing non-character-class potions");
    }

    // ================ ADD RELICS ===================

	@Override
	public void receiveEditRelics() {
		logger.info("Add relics");
		RelicInitializer.addRelics();
        logger.info("Done adding relics!");
	
	}

	 // ================ ADD CARDS ===================
	
	@Override
	public void receiveEditCards() {
		logger.info("Add Variables");
		CardInitializer.addDynamicVariables();
		
		logger.info("Add Cards");
		CardInitializer.addCards();

        logger.info("Making sure the cards are unlocked.");
        CardInitializer.unlockCards();
        
        logger.info("Cards - added!");
	}

    // ================ LOAD THE TEXT ===================
	
	@Override
	public void receiveEditStrings() {
		logger.info("Begin editting strings");
		StringInitializer.addStrings();
        logger.info("Done edittting strings");
	}

    // ================ LOAD THE KEYWORDS ===================
	
	@Override
	public void receiveEditKeywords() {
		logger.info("Begin editting keywords");
		KeywordInitializer.addKeywords();
		logger.info("Done editting keywords");
	}

	// this adds "ModName: " before the ID of any card/relic/power etc.
    // in order to avoid conflics if any other mod uses the same ID.
	public static String makeID(String idText) {
	    return "SlaytheStarCraft2Mod:" + idText;
	}

	// this is my own hook subscriber
	// this changes each room in the first row in exordium to event room(?)
	public static void receivePostGenerateMap() {
		if(AbstractDungeon.id.equals("Exordium")) {
			if(AbstractDungeon.player.hasRelic(SlaytheStarCraft2Mod.makeID("HeartofProtoss"))) {
			
			Iterator<MapRoomNode> var2 = ((ArrayList<MapRoomNode>) AbstractDungeon.map.get(0)).iterator();

			while (var2.hasNext()) {
				MapRoomNode n = (MapRoomNode) var2.next();
						n.setRoom(new EventRoom());
				
			}
			logger.info("room changed");
			}
		}
	}
}
