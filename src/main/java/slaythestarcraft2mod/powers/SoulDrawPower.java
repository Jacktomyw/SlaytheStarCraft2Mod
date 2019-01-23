package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class SoulDrawPower extends AbstractPower{
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("SoulDrawPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.SOULDRAW_POWER);

	public SoulDrawPower(AbstractCreature owner, int amount){
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = owner;
		this.amount = amount;
		this.updateDescription();
		this.type = PowerType.DEBUFF;
		this.isTurnBased = false;
		this.img = new Texture(IMG);
	}
	
	public void updateDescription() {
		this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
}

	@Override
	public int onAttacked(DamageInfo info, int damageAmount) {
		if(damageAmount>0&&info.owner!=null&&info.type!=DamageType.HP_LOSS) {
			AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(owner, owner, new DrawReductionMultiplePower(owner, 1), 1));
		}
		return super.onAttacked(info, damageAmount);
	}

	@Override
	public void atEndOfRound() {
		AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(owner, owner, this.ID));
	}
	
}
