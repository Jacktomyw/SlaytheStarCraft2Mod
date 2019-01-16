package starcraft2thespiremod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import starcraft2thespiremod.StarCraft2theSpireMod;

import static starcraft2thespiremod.patches.CardTagsEnum.*;

public class PsionicPower extends AbstractPower {
	public static final String POWER_ID = starcraft2thespiremod.StarCraft2theSpireMod.makeID("PsionicPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.PSIONIC_POWER);

	public PsionicPower(AbstractCreature owner, int amount){
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
	
	public void updateDescription() {
		this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
}
	
	@Override
	public void onUseCard(AbstractCard card, UseCardAction action) {
		boolean isUsed = false;
		if(card.type == CardType.ATTACK && !card.hasTag(NOPSIONIC)){
			isUsed = true;
		}
		if(card.hasTag(SHIELD)) {
			isUsed = true;
		}
		if(isUsed) {
			AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(owner, owner, this.ID));
		}
	}

	@Override
	public float atDamageGive(float damage, DamageType type) {
		return type == starcraft2thespiremod.patches.DamageTypeEnum.NOPSIONIC ? damage : damage + (float) this.amount;
	}

	@Override
	public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
		if(power.ID.equals(StarCraft2theSpireMod.makeID("ShieldPower"))) {
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(target, source, new ShieldPower(target, this.amount), this.amount));
		}
	}
	
	
	
}
