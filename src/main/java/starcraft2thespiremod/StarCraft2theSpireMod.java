package starcraft2thespiremod;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.EventHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.map.MapRoomNode;
import com.megacrit.cardcrawl.map.RoomTypeAssigner;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;
import com.megacrit.cardcrawl.rooms.EventRoom;
import com.megacrit.cardcrawl.rooms.MonsterRoom;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.BaseMod;
import basemod.ModLabel;
import basemod.ModPanel;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import starcraft2thespiremod.cards.*;
import starcraft2thespiremod.characters.*;
import starcraft2thespiremod.events.ProtossLeaders;
import starcraft2thespiremod.patches.*;
import starcraft2thespiremod.relics.*;
import starcraft2thespiremod.rooms.ProtossLeadersRoom;

@SpireInitializer
public class StarCraft2theSpireMod implements EditCharactersSubscriber, EditCardsSubscriber, EditStringsSubscriber,
		EditRelicsSubscriber, EditKeywordsSubscriber, PostInitializeSubscriber{
	
	public static final Logger logger = LogManager.getLogger(StarCraft2theSpireMod.class.getName());

//This is for the in-game mod settings pannel.
    private static final String MODNAME = "StarCraft II the Spire Mod";
    private static final String AUTHOR = "Jacktomyw";
    private static final String DESCRIPTION = "This is a mod for Slay the Spire in a STARCRAFT II theme.";
    
//=======================INPUT TEXTURE LOCATION========================
// Colors (RGB)
    // Character Color
    
    public static final Color PROTOSS_BLUE = CardHelper.getColor(0.0f, 162.0f, 232.0f);
    
    // Potion Colors in RGB
    //TODO these codes will be rewrite after potions have been designed
    //TODO add potions' colors here
    //    public static final Color PLACEHOLDER_POTION_lIQUID = CardHelper.getColor(209.0f, 53.0f, 18.0f); // Orange-ish Red 
    //    public static final Color PLACEHOLDER_POTION_HYBRID = CardHelper.getColor(255.0f, 230.0f, 230.0f); // Near White
    //    public static final Color PLACEHOLDER_POTION_SPOTS = CardHelper.getColor(100.0f, 25.0f, 10.0f); // Super Dark Red/Brown    

// Image folder name
    private static final String STARCRAFTII_THE_SPIRE_MOD_ASSETS_FOLDER = "StarCraft2theSpireModResources/images";
    //TODO rewrite this method after complete imgs
    private static String makeExample(String fileNameWithoutSuffix) {
    	return fileNameWithoutSuffix+"_example.png";
    }
// Card backgrounds
    //TODO add character card background and orb background here
    private static final String ATTACK_PROTOSS_BLUE = "512/bg_attack_protoss_blue.png";
    private static final String POWER_PROTOSS_BLUE ="512/bg_power_protoss_blue.png";
    private static final String SKILL_PROTOSS_BLUE = "512/bg_skill_protoss_blue.png";
    private static final String ENERGY_ORB_PROTOSS_BLUE = "512/card_protoss_blue_orb.png";
    private static final String CARD_PROTOSS_BLUE_ENERGY_ORB = "512/card_protoss_blue_small_orb.png";

    private static final String ATTACK_PROTOSS_BLUE_PORTRAIT = "1024/bg_attack_protoss_blue.png";
    private static final String POWER_PROTOSS_BLUE_PORTRAIT = "1024/bg_power_protoss_blue.png";
    private static final String SKILL_PROTOSS_BLUE_PORTRAIT = "1024/bg_skill_protoss_blue.png";
    private static final String ENERGY_ORB_PROTOSS_BLUE_PORTRAIT = "1024/card_protoss_blue_orb.png";

// Card images
    //TODO add card imgs here
    public static final String BASIC_STRIKE_PROTOSS = makeExample("cards/attack");//should be cards/basic_strike_p.png
    public static final String BASIC_DEFEND_PROTOSS = makeExample("cards/skill");//should be...
    public static final String BATTERSLASH = makeExample("cards/attack");//should be...
    public static final String BLADECHARGE = makeExample("cards/skill");//should be...
    public static final String BLADEOFSPACE = makeExample("cards/attack");//should be...
	public static final String BLINK = makeExample("cards/skill");//should be...
    public static final String DARKNESSAPPROACH = makeExample("cards/power");//should be...
    public static final String GIFTSFROMXELNAGA = makeExample("cards/power");//should be...
    public static final String INTOTHESHADOW = makeExample("cards/skill");//should be...
    public static final String MASTERGRADEWARPPINGBLADE = makeExample("cards/attack");//should be...
    public static final String MEDITATION = makeExample("cards/skill");//should be...
    public static final String OBLIVIONDESCENDS = makeExample("cards/attack");//should be...
    public static final String POWEROFNERAZIM = makeExample("cards/skill");//should be...
    public static final String PSIONICLIGHTBLADE = makeExample("cards/attack");//should be...
    public static final String SHADOWBARRIER = makeExample("cards/skill");//should be...
    public static final String SHADOWRUSH = makeExample("cards/skill");//should be...
    public static final String SHADOWSTRIKE = makeExample("cards/attack");//should be...
    public static final String SINGULARITYSTUB = makeExample("cards/attack");//should be...
    public static final String TEARSLASH = makeExample("cards/attack");//should be...
    public static final String TWILIGHTDESCENDS = makeExample("cards/skill");//should be...
    public static final String VOIDIMPRISON = makeExample("cards/attack");//should be...
    public static final String VOIDPOWERCANNON = makeExample("cards/attack");//should be...
    public static final String VOIDSNEAKATTACK = makeExample("cards/skill");//should be...
    public static final String VOIDSPIRALBALL = makeExample("cards/attack");//should be...
    public static final String VOIDSTRIKE = makeExample("cards/attack");//should be...
    public static final String WAYOFDARKTEMPLAR = makeExample("cards/power");//should be...
    public static final String WORMHOLE = makeExample("cards/skill");//should be...
    public static final String XELNAGAPROPHECY = makeExample("cards/skill");//should be...
    
// Power images
    //TODO add power imgs here
    public static final String CONCENTRATED_POWER = makeExample("powers/Concentrated_power");
    public static final String DOUBLE_BLADE_POWER = makeExample("powers/DoubleBlade_power");
    public static final String PSIONIC_POWER = makeExample("powers/Psionic_power");
    public static final String SHIELD_POWER = makeExample("powers/Shield_power");
    public static final String TEARING_POWER = makeExample("powers/Tearing_power");
    public static final String DARKNESSAPPROACH_POWER = makeExample("powers/DarknessApproach_power");
// Relic images
    //TODO add relic imgs here
    public static final String HeartofProtoss = makeExample("relics/HeartofProtoss");
    public static final String HeartofProtoss_USED = makeExample("relics/HeartofProtoss");		//need to change
    public static final String HeartofProtoss_OUTLINE = makeExample("relics/outline/ARelic");
    public static final String IanCrystal = makeExample("relics/IanCrystal");
    public static final String IanCrystal_OUTLINE = makeExample("relics/outline/ARelic");
    public static final String KeyStone = makeExample("relics/KeyStone");
    public static final String KeyStone_OUTLINE = makeExample("relics/outline/ARelic");
    public static final String Khala = makeExample("relics/Khala");
    public static final String Khala_OUTLINE = makeExample("relics/outline/ARelic");
    public static final String KhaydarinAmulet = makeExample("relics/KhaydarinAmulet");
    public static final String KhaydarinAmulet_OUTLINE = makeExample("relics/outline/ARelic");
    public static final String MiniVoidSeeker = makeExample("relics/MiniVoidSeeker");
    public static final String MiniVoidSeeker_OUTLINE = makeExample("relics/outline/ARelic");
    
// Event images
    //TODO add event imgs here
    public static final String ProtossLeaders_IMG = makeExample("relics/ARelic");	//need to change
    
// Character assets
    //TODO add character assets here
    
    //buttons
    public static final String PROTOSS_BUTTON = makeExample("charSelect/ProtossButton");
    //backgrounds
    public static final String PROTOSS_BACKGROUND = makeExample("charSelect/ProtossBG");
    //shoulders
    public static final String PROTOSS_SHOULDER = makeExample("char/protoss/shoulder");
    public static final String PROTOSS_SHOULDER_AFTER = makeExample("char/protoss/shoulder_aftrer");
    //corpses
    public static final String PROTOSS_CORPSE = makeExample("char/protoss/corpse");
    
// Mod Badge
    public static final String BADGE_IMAGE = makeExample("Badge");
    
//Animations atlas and JSON files
    //TODO this part will be written after animation part complete
    public static final String PROTOSS_SKELETON_ATLAS = "char/protoss/skeleton.atlas";
    public static final String PROTOSS_SKELETON_JSON = "char/protoss/skeleton.json";

    
//=============================IMAGE PATHS========================
    /**
     * @param resource the resource, must *NOT* have a leading "/"
     * @return the full path
     */
    public static final String makePath(String resource) {
    	return STARCRAFTII_THE_SPIRE_MOD_ASSETS_FOLDER + "/" + resource;
    }

//================================SUBSCRIBE, CREATE THE COLOR, INITIALIZE =========================
    
	public StarCraft2theSpireMod() {
		
		logger.info("Subscribe to basemod hooks");
		
		BaseMod.subscribe(this);
		
		logger.info("Done subscribing");
		//TODO add colors here
        logger.info("Creating the color " + AbstractCardEnum.PROTOSS_BLUE.toString());

		BaseMod.addColor(AbstractCardEnum.PROTOSS_BLUE, PROTOSS_BLUE, PROTOSS_BLUE, PROTOSS_BLUE,
				PROTOSS_BLUE, PROTOSS_BLUE, PROTOSS_BLUE, PROTOSS_BLUE,
				makePath(ATTACK_PROTOSS_BLUE), makePath(SKILL_PROTOSS_BLUE), makePath(POWER_PROTOSS_BLUE),
				makePath(ENERGY_ORB_PROTOSS_BLUE),
				makePath(ATTACK_PROTOSS_BLUE_PORTRAIT), makePath(SKILL_PROTOSS_BLUE_PORTRAIT), makePath(POWER_PROTOSS_BLUE_PORTRAIT),
				makePath(ENERGY_ORB_PROTOSS_BLUE_PORTRAIT), makePath(CARD_PROTOSS_BLUE_ENERGY_ORB));
		
		logger.info("Done Creating the color");
		
	}
	
	public static void initialize() {
		logger.info("===================== Initializing StarCraft II the Spire Mod =========================== ");
		StarCraft2theSpireMod starCraft2theSpireMod = new StarCraft2theSpireMod();
		logger.info("===================== StarCraft II the Spire Mod Initialized ============================ ");
	}

	//=================== LOAD THE CHARACTER ==================
	
	@Override
	public void receiveEditCharacters() {
		//TODO add characters here
		logger.info("begin editing characters. " + "Add " + ProtossEnum.PROTOSS.toString());
		
	    BaseMod.addCharacter(new Protoss("Protoss", ProtossEnum.PROTOSS),
	            makePath(PROTOSS_BUTTON), makePath(PROTOSS_BACKGROUND), ProtossEnum.PROTOSS);

		//TODO add character-class potions here
//		logger.info("begin editing potions");
//	       
//      BaseMod.addPotion(PlaceholderPotion.class, PLACEHOLDER_POTION_lIQUID, PLACEHOLDER_POTION_HYBRID, PLACEHOLDER_POTION_SPOTS, PlaceholderPotion.POTION_ID, TheDefaultEnum.THE_DEFAULT);
//      
//      logger.info("end editing potions");
	    logger.info("done editing characters");
	
	}
	
	//=================== POST-INITIALIZE, ADD NON-CHARACTER-CLASS POTIONS ==================
	
	@Override
	public void receivePostInitialize() {
		logger.info("Load Badge Image and mod options");
        // Load the Mod Badge
        Texture badgeTexture = new Texture(makePath(BADGE_IMAGE));
        
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
		//TODO add non-character-class potions here
        logger.info("begin editing non-character-class potions");
       
        //BaseMod.addPotion(PlaceholderPotion.class, PLACEHOLDER_POTION_lIQUID, PLACEHOLDER_POTION_HYBRID, PLACEHOLDER_POTION_SPOTS, PlaceholderPotion.POTION_ID);
      
        logger.info("end editing non-character-class potions");
    }

    // ================ ADD RELICS ===================

	@Override
	public void receiveEditRelics() {
		logger.info("Add relics");
		//TODO add relics here
        // This adds a character specific relic. Only when you play with the mentioned color, will you get this relic.
        BaseMod.addRelicToCustomPool(new HeartofProtoss(), AbstractCardEnum.PROTOSS_BLUE);

        // This adds a relic to the Shared pool. Every character can find this relic.
        //BaseMod.addRelic(new PlaceholderRelic2(), RelicType.SHARED);

        logger.info("Done adding relics!");
	
	}

	 // ================ ADD CARDS ===================
	
	@Override
	public void receiveEditCards() {
		logger.info("Add Variables");
        // TODO Add the Custom Dynamic Variables here
//        BaseMod.addDynamicVariable(new DefaultCustomVariable());
//      
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
        
        
        logger.info("Cards - added!");
	}

    // ================ LOAD THE TEXT ===================
	
	@Override
	public void receiveEditStrings() {
		logger.info("Begin editting strings");

        // CardStrings
        BaseMod.loadCustomStringsFile(CardStrings.class,
                "StarCraft2theSpireModResources/localization/StarCraft2theSpireMod-Card-Strings.json");

        // PowerStrings
        BaseMod.loadCustomStringsFile(PowerStrings.class,
                "StarCraft2theSpireModResources/localization/StarCraft2theSpireMod-Power-Strings.json");

        // RelicStrings
        BaseMod.loadCustomStringsFile(RelicStrings.class,
                "StarCraft2theSpireModResources/localization/StarCraft2theSpireMod-Relic-Strings.json");

        // PotionStrings
        BaseMod.loadCustomStringsFile(PotionStrings.class,
                "StarCraft2theSpireModResources/localization/StarCraft2theSpireMod-Potion-Strings.json");
        
        // EventStrings
        BaseMod.loadCustomStringsFile(EventStrings.class, 
        		"StarCraft2theSpireModResources/localization/StarCraft2theSpireMod-Event-Strings.json");
        logger.info("Done edittting strings");
	}

    // ================ LOAD THE KEYWORDS ===================
	
	@Override
	public void receiveEditKeywords() {
//		final String[] placeholder = { "keyword", "keywords", "Keyword", "Keywords" };
//        BaseMod.addKeyword(placeholder, "Whenever you play a card, gain 1 dexterity this turn only.");

	}

	// this adds "ModName: " before the ID of any card/relic/power etc.
    // in order to avoid conflics if any other mod uses the same ID.
	public static String makeID(String idText) {
	    return "StarCraft2theSpireMod:" + idText;
	}

	public static void receivePostGenerateMap() {
		if(AbstractDungeon.id.equals("Exordium")) {
			if(AbstractDungeon.player.hasRelic(StarCraft2theSpireMod.makeID("HeartofProtoss"))) {
			
			Iterator var2 = ((ArrayList<MapRoomNode>) AbstractDungeon.map.get(0)).iterator();

			while (var2.hasNext()) {
				MapRoomNode n = (MapRoomNode) var2.next();
						n.setRoom(new ProtossLeadersRoom());
				
			}
			logger.info("room changed");
			}
		}
	}
}
