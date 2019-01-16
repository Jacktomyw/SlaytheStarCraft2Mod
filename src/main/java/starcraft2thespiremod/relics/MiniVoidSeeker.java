package starcraft2thespiremod.relics;

import com.badlogic.gdx.graphics.Texture;
import basemod.abstracts.CustomRelic;
import starcraft2thespiremod.StarCraft2theSpireMod;;

public class MiniVoidSeeker extends CustomRelic {
	public static final String ID = starcraft2thespiremod.StarCraft2theSpireMod.makeID("MiniVoidSeeker");
    public static final String IMG = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.MiniVoidSeeker);
    public static final String OUTLINE = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.MiniVoidSeeker_OUTLINE);
    
    public MiniVoidSeeker() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.SPECIAL, LandingSound.MAGICAL);
    }
    
    public void onEquip() {
    	
    }
}
