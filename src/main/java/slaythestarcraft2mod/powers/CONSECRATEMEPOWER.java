package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class CONSECRATEMEPOWER extends AbstractPower {
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("CONSECRATEMEPOWER");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.CONSECRATEME_POWER);

	public CONSECRATEMEPOWER(AbstractCreature owner, int amount){
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = owner;
		this.amount = amount;
		this.updateDescription();
		this.type = PowerType.BUFF;
		this.isTurnBased = false;
		this.img = new Texture(IMG);
	}
	
	
	
	public void updateDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append(DESCRIPTIONS[0]);
		sb.append(this.amount);
		sb.append(DESCRIPTIONS[1]);
		this.description=sb.toString();
}

	@Override
	public int onAttacked(DamageInfo info, int damageAmount) {
		if(info.owner==this.owner && damageAmount>0) {
			this.owner.heal(damageAmount*this.amount, true);
		}
		return super.onAttacked(info, damageAmount);
	}

}
