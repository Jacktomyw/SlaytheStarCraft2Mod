package slaythestarcraft2mod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.PowerTip;

import basemod.abstracts.CustomRelic;
import basemod.abstracts.CustomSavable;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class HeartofProtoss extends CustomRelic implements CustomSavable<String>{
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("HeartofProtoss");
    public static final String IMG = ImgInitializer.makePath(ImgInitializer.HeartofProtoss);
    public static final String IMG_RED = ImgInitializer.makePath(ImgInitializer.HeartofProtoss_RED);
    public static final String IMG_BLUE = ImgInitializer.makePath(ImgInitializer.HeartofProtoss_BLUE);
    public static final String IMG_GREEN = ImgInitializer.makePath(ImgInitializer.HeartofProtoss_GREEN);
    public static final String OUTLINE = ImgInitializer.makePath(ImgInitializer.HeartofProtoss_OUTLINE);
    
    public String SELECTED_LEADER = "";
    
    public HeartofProtoss() {
		super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.STARTER, LandingSound.MAGICAL);
		this.counter=-1;
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
			switch(SELECTED_LEADER) {
			case "Artanis":
				this.img = ImageMaster.loadImage(IMG_BLUE);
				this.description = this.DESCRIPTIONS[1];break;
			case "Zeratul":
				this.img = ImageMaster.loadImage(IMG_GREEN);
				this.description = this.DESCRIPTIONS[2];break;
			case "Alarak":
				this.img = ImageMaster.loadImage(IMG_RED);
				this.description = this.DESCRIPTIONS[3];break;
				default:
					this.img = ImageMaster.loadImage(IMG);
					this.description = this.DESCRIPTIONS[4];break;
					
			}
			this.usedUp();
			this.counter = -2;
		}
	}
	@Override
	public void usedUp() {
		this.usedUp = true;
		this.tips.clear();
		this.tips.add(new PowerTip(this.name, this.description));
		this.initializeTips();
	}

	@Override
	public void onLoad(String leader) {
		SlaytheStarCraft2Mod.logger.info("SELECTED_LEADER "+leader+" loaded.");
		SELECTED_LEADER = leader;
		setCounter(this.counter);
	}

	@Override
	public String onSave() {
		SlaytheStarCraft2Mod.logger.info("SELECTED_LEADER "+SELECTED_LEADER+" saved.");
		return SELECTED_LEADER;
	}
}
