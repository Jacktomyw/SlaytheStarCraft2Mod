package slaythestarcraft2mod.initializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImgInitializer {

	public static final Logger logger = LogManager.getLogger(ImgInitializer.class.getName());
	// Image folder name
    private static final String SLAY_THE_STARCRAFTII_MOD_ASSETS_FOLDER = "SlaytheStarCraft2ModResources/images";
    //TODO rewrite this method after complete imgs
    public static String makeExample(String fileNameWithoutSuffix) {
    	return fileNameWithoutSuffix+"_example.png";
    }
// Card backgrounds
    //TODO add character card background and orb background here
    public static final String ATTACK_PROTOSS_BLUE = "512/bg_attack_protoss_blue.png";
    public static final String POWER_PROTOSS_BLUE ="512/bg_power_protoss_blue.png";
    public static final String SKILL_PROTOSS_BLUE = "512/bg_skill_protoss_blue.png";
    public static final String ENERGY_ORB_PROTOSS_BLUE = "512/card_protoss_blue_orb.png";
    public static final String CARD_PROTOSS_BLUE_ENERGY_ORB = "512/card_protoss_blue_small_orb.png";

    public static final String ATTACK_PROTOSS_BLUE_PORTRAIT = "1024/bg_attack_protoss_blue.png";
    public static final String POWER_PROTOSS_BLUE_PORTRAIT = "1024/bg_power_protoss_blue.png";
    public static final String SKILL_PROTOSS_BLUE_PORTRAIT = "1024/bg_skill_protoss_blue.png";
    public static final String ENERGY_ORB_PROTOSS_BLUE_PORTRAIT = "1024/card_protoss_blue_orb.png";

// Card images
    //TODO add card imgs here
    public static final String BASIC_STRIKE_PROTOSS = makeExample("cards/attack");//should be cards/basic_strike.png
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
    public static final String VOIDIMPRISON = makeExample("cards/skill");//should be...
    public static final String VOIDPOWERCANNON = makeExample("cards/attack");//should be...
    public static final String VOIDSNEAKATTACK = makeExample("cards/skill");//should be...
    public static final String VOIDSPIRALBALL = makeExample("cards/attack");//should be...
    public static final String VOIDSTRIKE = makeExample("cards/attack");//should be...
    public static final String WAYOFDARKTEMPLAR = makeExample("cards/power");//should be...
    public static final String WORMHOLE = makeExample("cards/skill");//should be...
    public static final String XELNAGAPROPHECY = makeExample("cards/skill");//should be...
	public static final String HIGHKINGBLADE = makeExample("cards/attack");
    public static final String OBLIVIONWAVE = makeExample("cards/attack");
    public static final String PSIONICOPPRESSION = makeExample("cards/skill");
    public static final String AGILITYCONTRACT = makeExample("cards/skill");
    public static final String CHAOSDOMINION = makeExample("cards/skill");
    public static final String CHAOSSTRIKE = makeExample("cards/attack");
    public static final String CONSECRATEME = makeExample("cards/power");
    public static final String COUNTERATTACK = makeExample("cards/power");
    public static final String DEFINITEHATRED = makeExample("cards/power");
    public static final String LAUGHTOTHEEND = makeExample("cards/skill");
    public static final String LIGHTNINGTURBULENCE = makeExample("cards/attack");
    public static final String POWERSHOW = makeExample("cards/attack");
    public static final String RAGEOFHIGHKING = makeExample("cards/skill");
    public static final String SOULDRAW = makeExample("cards/skill");
    public static final String SPIRITTHREAT = makeExample("cards/power");
    public static final String STRETCHLIGHTNING = makeExample("cards/attack");
    public static final String TAUGHTSTRIKE = makeExample("cards/attack");
    public static final String LIGHTNINGFLUSH = makeExample("cards/attack");

// Power images
    //TODO add power imgs here
    public static final String CONCENTRATED_POWER = "powers/Concentrated_power.png";
    public static final String DOUBLE_BLADE_POWER = makeExample("powers/DoubleBlade_power");
    public static final String PSIONIC_POWER = "powers/Psionic_power.png";
    public static final String SHIELD_POWER = "powers/Shield_power.png";
    public static final String TORN_POWER = "powers/Torn_power.png";
    public static final String DARKNESSAPPROACH_POWER = "powers/DarknessApproach_power.png";
	public static final String GIFTSFROMXELNAGA_POWER = "powers/GiftsfromXelNaga_power.png";
	public static final String PYLON_POWER = "powers/Pylon_power.png";
	public static final String WAYOFDARKTEMPLAR_POWER = "powers/WayofDarkTemplar_power.png";
	public static final String CONSECRATEME_POWER = "powers/CONSECRATEME_POWER.png";
	public static final String COUNTERATTACK_POWER = "powers/CounterAttack_power.png";
	public static final String DEFINITEHATRED_POWER = "powers/DefiniteHatred_power.png";
	public static final String LAUGHING_POWER = "powers/Laughing_power.png";
	public static final String BEINGLAUGHED_POWER = "powers/BeingLaughed_power.png";
	public static final String SOULDRAW_POWER = "powers/SoulDraw_power.png";
	public static final String SPIRITTHREAT_POWER = "powers/SpiritThreat_power.png";
	public static final String DRAWREDUCTIONMULTIPLE_POWER = "powers/DrawReductionMultiple_power.png";
	
// Relic images
    //TODO add relic imgs here
    public static final String HeartofProtoss = "relics/HeartofProtoss.png";
    public static final String HeartofProtoss_RED = "relics/HeartofProtoss_red.png";
    public static final String HeartofProtoss_BLUE = "relics/HeartofProtoss_blue.png";
    public static final String HeartofProtoss_GREEN = "relics/HeartofProtoss_green.png";
    public static final String HeartofProtoss_OUTLINE = "relics/outline/HeartofProtoss.png";
    public static final String IanCrystal = "relics/IanCrystal.png";
    public static final String IanCrystal_OUTLINE = "relics/outline/IanCrystal.png";
    public static final String KeyStone = "relics/KeyStone.png";
    public static final String KeyStone_OUTLINE = "relics/outline/KeyStone.png";
    public static final String Khala = "relics/Khala.png";
    public static final String Khala_OUTLINE = "relics/outline/Khala.png";
    public static final String KhaydarinAmulet = "relics/KhaydarinAmulet.png";
    public static final String KhaydarinAmulet_OUTLINE = "relics/outline/KhaydarinAmulet.png";
    public static final String MiniVoidSeeker = "relics/MiniVoidSeeker.png";
    public static final String MiniVoidSeeker_OUTLINE = "relics/outline/MiniVoidSeeker.png";
    public static final String UpgradingChain = "relics/UpgradingChain.png";
    public static final String UpgradingChain_OUTLINE = "relics/outline/UpgradingChain.png";
    public static final String SolarBattleaxe = "relics/SolarBattleaxe.png";
    public static final String SolarBattleaxe_OUTLINE = "relics/outline/SolarBattleaxe.png";

    
// Event images
    //TODO add event imgs here
    public static final String ProtossLeaders_IMG = "events/ProtossLeaders.png";
    
// Character assets
    //TODO add character assets here
    
    //shoulders
    public static final String PROTOSS_SHOULDER = makeExample("char/protoss/shoulder");
    public static final String PROTOSS_SHOULDER_AFTER = makeExample("char/protoss/shoulder_after");
    //corpses
    public static final String PROTOSS_CORPSE = makeExample("char/protoss/corpse");
    
// Mod Badge
    public static final String BADGE_IMAGE = "Badge.png";
    
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
    	return SLAY_THE_STARCRAFTII_MOD_ASSETS_FOLDER + "/" + resource;
    }

}
