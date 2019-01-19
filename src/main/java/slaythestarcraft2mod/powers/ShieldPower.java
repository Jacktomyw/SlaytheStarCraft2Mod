package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import slaythestarcraft2mod.initializers.ImgInitializer;

public class ShieldPower extends AbstractPower {

	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("ShieldPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.SHIELD_POWER);
	public ShieldPower(AbstractCreature owner, int amount){
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = owner;
		this.amount = amount;
		if (this.amount >= 999) {
			this.amount = 999;
		}
		this.updateDescription();
		this.type = PowerType.BUFF;
		this.isTurnBased = false;
		this.img = new Texture(IMG);
	}

	@Override
	public void updateDescription() {
		this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
	}

	@Override
	public int onLoseHp(int damageAmount) {
		this.flash();
		if (damageAmount < this.amount) {
			AbstractDungeon.actionManager.addToTop(new ReducePowerAction(this.owner, this.owner, this.ID, damageAmount));
			return 0;
		}else {
			damageAmount -= this.amount;
			AbstractDungeon.actionManager.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
			return damageAmount;
		}
	}
	
	
}
