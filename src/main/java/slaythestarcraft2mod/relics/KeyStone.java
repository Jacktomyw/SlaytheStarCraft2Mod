package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import basemod.abstracts.CustomRelic;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class KeyStone extends CustomRelic{

	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("KeyStone");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.KeyStone);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.KeyStone_OUTLINE);
    
    public boolean isFirstCard = true;
    
    public KeyStone() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.BOSS, LandingSound.HEAVY);
    }

	public String getUpdatedDescription() {
		return this.DESCRIPTIONS[0];
	}

	@Override
	public void atTurnStart() {
		this.beginPulse();
		isFirstCard = true;
	}

	public void protectPsionic() {
		this.stopPulse();
		isFirstCard = false;
		this.flash();
	}
}
