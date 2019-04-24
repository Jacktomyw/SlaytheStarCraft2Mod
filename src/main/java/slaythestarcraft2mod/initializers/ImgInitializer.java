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
    public static final String BASIC_STRIKE_PROTOSS = "cards/Basic_Strike_Protoss.png";
    public static final String BASIC_DEFEND_PROTOSS = "cards/Basic_Defend_Protoss.png";
    public static final String BATTERSLASH = "cards/BatterSlash.png";
    public static final String BLADECHARGE = makeExample("cards/skill");//should be cards/BladeCharge.png
    public static final String BLADEOFSPACE = "cards/BladeofSpace.png";
	public static final String BLINK = "cards/Blink.png";
    public static final String DARKNESSAPPROACH = "cards/DarknessApproach.png";
    public static final String GIFTSFROMXELNAGA = "cards/GiftsfromXelNaga.png";
    public static final String INTOTHESHADOW = "cards/IntotheShadow.png";
    public static final String MASTERGRADEWARPPINGBLADE = "cards/MasterGradeWarppingBlade.png";
    public static final String MEDITATION = "cards/Meditation.png";
    public static final String OBLIVIONDESCENDS = "cards/OblivionDescends.png";
    public static final String POWEROFNERAZIM = "cards/PowerofNerazim.png";
    public static final String PSIONICLIGHTBLADE = "cards/PsionicLightBlade.png";
    public static final String SHADOWBARRIER = "cards/ShadowBarrier.png";
    public static final String SHADOWRUSH = "cards/ShadowRush.png";
    public static final String SHADOWSTRIKE = makeExample("cards/attack");//should be...
    public static final String SINGULARITYSTUB = "cards/SingularityStub.png";
    public static final String TEARSLASH = "cards/TearSlash.png";
    public static final String TWILIGHTDESCENDS = "cards/TwilightDescends.png";
    public static final String VOIDIMPRISON = "cards/VoidImprison.png";
    public static final String VOIDPOWERCANNON = "cards/VoidPowerCannon.png";
    public static final String VOIDSNEAKATTACK = "cards/VoidSneakAttack.png";
    public static final String VOIDSPIRALBALL = "cards/VoidSpiralBall.png";
    public static final String VOIDSTRIKE = "cards/VoidStrike.png";
    public static final String WAYOFDARKTEMPLAR = "cards/WayofDarkTemplar.png";
    public static final String WORMHOLE = "cards/Wormhole.png";
    public static final String XELNAGAPROPHECY = "cards/XelNagaProphecy.png";
    
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
    //main
    public static final String PORTOSS_MAIN = "char/protoss/main.png";
    //shoulders
    public static final String PROTOSS_SHOULDER = "char/protoss/shoulder.png";
    public static final String PROTOSS_SHOULDER_AFTER = "char/protoss/shoulder_after.png";
    //corpses
    public static final String PROTOSS_CORPSE = "char/protoss/corpse.png";
    
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
