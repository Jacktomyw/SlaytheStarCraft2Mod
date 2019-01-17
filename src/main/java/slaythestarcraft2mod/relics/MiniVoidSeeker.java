package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import basemod.abstracts.CustomRelic;
import slaythestarcraft2mod.initializers.ImgInitializer;;

public class MiniVoidSeeker extends CustomRelic {
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("MiniVoidSeeker");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.MiniVoidSeeker);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.MiniVoidSeeker_OUTLINE);
    
    public MiniVoidSeeker() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.SPECIAL, LandingSound.MAGICAL);
    }
    
    public void onEquip() {
    	
    }
}
