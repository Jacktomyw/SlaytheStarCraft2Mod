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
    
// Power images
    //TODO add power imgs here
    public static final String CONCENTRATED_POWER = makeExample("powers/Concentrated_power");
    public static final String DOUBLE_BLADE_POWER = makeExample("powers/DoubleBlade_power");
    public static final String PSIONIC_POWER = makeExample("powers/Psionic_power");
    public static final String SHIELD_POWER = makeExample("powers/Shield_power");
    public static final String TORN_POWER = makeExample("powers/Torn_power");
    public static final String DARKNESSAPPROACH_POWER = makeExample("powers/DarknessApproach_power");
	public static final String GIFTSFROMXELNAGA_POWER = makeExample("powers/GiftsfromXelNaga_power");
	public static final String PYLON_POWER = makeExample("powers/Pylon_power");
	public static final String WAYOFDARKTEMPLAR_POWER = makeExample("powers/WayofDarkTemplar_power");
	
// Relic images
    //TODO add relic imgs here
    public static final String HeartofProtoss = "relics/HeartofProtoss.png";
    public static final String HeartofProtoss_USED = "relics/HeartofProtoss_used.png";
    public static final String HeartofProtoss_OUTLINE = "relics/outline/HeartofProtoss.png";
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
    
    //shoulders
    public static final String PROTOSS_SHOULDER = makeExample("char/protoss/shoulder");
    public static final String PROTOSS_SHOULDER_AFTER = makeExample("char/protoss/shoulder_after");
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
    	return SLAY_THE_STARCRAFTII_MOD_ASSETS_FOLDER + "/" + resource;
    }

}
