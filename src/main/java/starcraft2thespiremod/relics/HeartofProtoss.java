package starcraft2thespiremod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.PowerTip;

import basemod.abstracts.CustomRelic;
import starcraft2thespiremod.StarCraft2theSpireMod;

public class HeartofProtoss extends CustomRelic{
	public static final String ID = starcraft2thespiremod.StarCraft2theSpireMod.makeID("HeartofProtoss");
    public static final String IMG = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.HeartofProtoss);
    public static final String IMG_USED = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.HeartofProtoss_USED);
    public static final String OUTLINE = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.MiniVoidSeeker_OUTLINE);
    
    public HeartofProtoss() {
		super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.STARTER, LandingSound.MAGICAL);
		this.counter=1;
	}
    
    public String getUpdatedDescription() {
		return this.DESCRIPTIONS[0];
	}
    
    public void seeLeaders() {
		if (!this.usedUp) {
			this.flash();
			this.setCounter(-2);
		}

	}

	public void setCounter(int counter) {
		this.counter = counter;
		if (counter == -2) {
			this.img = ImageMaster.loadImage(IMG_USED);
			this.usedUp();
			this.counter = -2;
		}
	}
	@Override
	public void usedUp() {
		this.usedUp = true;
		this.description = this.DESCRIPTIONS[1];
		this.tips.clear();
		this.tips.add(new PowerTip(this.name, this.description));
		this.initializeTips();
	}
}
