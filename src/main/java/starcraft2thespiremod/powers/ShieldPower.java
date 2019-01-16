package starcraft2thespiremod.powers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import starcraft2thespiremod.StarCraft2theSpireMod;

public class ShieldPower extends AbstractPower {

	public static final String POWER_ID = starcraft2thespiremod.StarCraft2theSpireMod.makeID("ShieldPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.SHIELD_POWER);
	public static final Logger logger = LogManager.getLogger(StarCraft2theSpireMod.class.getName());
	public ShieldPower(AbstractCreature owner, int amount){
		this.name = NAME;
		this.ID = POWER_ID;
		logger.info(this.ID);
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
		if (damageAmount < this.amount) {
			AbstractDungeon.actionManager.addToBottom(new ReducePowerAction(this.owner, this.owner, this.ID, damageAmount));
			return 0;
		}else {
			damageAmount -= this.amount;
			AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
			return damageAmount;
		}
	}
	
	
}
