package starcraft2thespiremod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClass;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.BaseMod;
import basemod.ModLabel;
import basemod.ModPanel;
import basemod.helpers.RelicType;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import starcraft2thespiremod.patches.AbstractCardEnum;
import starcraft2thespiremod.patches.ProtossEnum;

public class StarCraft2theSpireMod implements EditCharactersSubscriber, EditCardsSubscriber, EditStringsSubscriber,
		EditRelicsSubscriber, EditKeywordsSubscriber, PostInitializeSubscriber {
	
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
    private static final String ATTACK_PROTOSS_BLUE = makeExample("512/bg_attack_protoss_blue");
    private static final String POWER_PROTOSS_BLUE = makeExample("512/bg_power_protoss_blue");
    private static final String SKILL_PROTOSS_BLUE = makeExample("512/bg_skill_protoss_blue");
    private static final String ENERGY_ORB_PROTOSS_BLUE = makeExample("512/card_protoss_blue_orb");
    private static final String CARD_PROTOSS_BLUE_ENERGY_ORB = makeExample("512/card_protoss_blue_small_orb");

    private static final String ATTACK_PROTOSS_BLUE_PORTRAIT = makeExample("1024/bg_attack_protoss_blue");
    private static final String POWER_PROTOSS_BLUE_PORTRAIT = makeExample("1024/bg_power_protoss_blue");
    private static final String SKILL_PROTOSS_BLUE_PORTRAIT = makeExample("1024/bg_skill_protoss_blue");
    private static final String ENERGY_ORB_PROTOSS_BLUE_PORTRAIT = makeExample("1024/card_protoss_blue_orb.png");

// Card images
    //TODO add card imgs here
    public static final String BASIC_STRIKE_P = makeExample("cards/attack");//should be cards/basic_strike_p.png

// Power images
    //TODO add power imgs here
    public static final String DOUBLE_BLADE_POWER = makeExample("powers/DoubleBlade_power");

// Relic images
    //TODO add relic imgs here
    public static final String A_RELIC = makeExample("relics/ARelic");
    public static final String A_RELIC_OUTLINE = makeExample("relics/outline/ARelic");
    
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
    //public static final String PROTOSS_SKELETON_ATLAS = "char/protoss/skeleton.atlas";
    //public static final String PROTOSS_SKELETON_JSON = "char/protoss/skeleton.json";
    
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
		
//	    BaseMod.addCharacter(new TheDefault("the Default", TheDefaultEnum.THE_DEFAULT),
//	            makePath(THE_DEFAULT_BUTTON), makePath(THE_DEFAULT_PORTRAIT), TheDefaultEnum.THE_DEFAULT);

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
        //BaseMod.addRelicToCustomPool(new PlaceholderRelic(), AbstractCardEnum.DEFAULT_GRAY);

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
//        BaseMod.addCard(new DefaultCommonAttack());

        logger.info("Making sure the cards are unlocked.");
        // TODO Unlock the cards here
//        UnlockTracker.unlockCard(DefaultCommonAttack.ID);
        
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
}
