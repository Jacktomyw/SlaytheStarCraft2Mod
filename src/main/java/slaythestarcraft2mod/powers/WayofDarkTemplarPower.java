package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class WayofDarkTemplarPower extends AbstractPower {
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("WayofDarkTemplarPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.WAYOFDARKTEMPLAR_POWER);

	private boolean notDealDamageLastTurn = true;
	private boolean notReceiveDamageLastTurn = true;
	

	public WayofDarkTemplarPower(AbstractCreature owner, int amount){
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
		sb.append(3*this.amount);
		sb.append(DESCRIPTIONS[1]);
		for(int i=0;i<this.amount;i++) {
			sb.append(" [E] ");
		}
		sb.append(DESCRIPTIONS[2]);
		this.description = sb.toString();
}

	
	@Override
	public int onAttacked(DamageInfo info, int damageAmount) {
		if (info.type != DamageType.HP_LOSS && info.owner != null && damageAmount > 0 && !AbstractDungeon.player.hasPower("Buffer")) {
    		if(AbstractDungeon.player.hasPower(SlaytheStarCraft2Mod.makeID("ShieldPower"))) {
    			if(AbstractDungeon.player.getPower(SlaytheStarCraft2Mod.makeID("ShieldPower")).amount>=damageAmount)
    				return damageAmount;
    		}
			notReceiveDamageLastTurn = false;
		}
		return damageAmount;
	}
	
	@Override
	public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
		if (damageAmount > 0 && info.type != DamageType.THORNS) {
			notDealDamageLastTurn = false;
		}
	}

	@Override
	public void atStartOfTurn() {
		if(notReceiveDamageLastTurn || notDealDamageLastTurn) {
			this.flash();
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(this.owner, this.owner, new ShieldPower(this.owner, 3*this.amount),3*this.amount));
			AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(this.amount));
		}
		notReceiveDamageLastTurn=true;
		notDealDamageLastTurn=true;
	}
	

}
