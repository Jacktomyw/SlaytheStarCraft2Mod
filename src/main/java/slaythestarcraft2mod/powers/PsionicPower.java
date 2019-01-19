package slaythestarcraft2mod.powers;

import slaythestarcraft2mod.patches.*;
import slaythestarcraft2mod.relics.KeyStone;

import com.badlogic.gdx.graphics.Texture;
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

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class PsionicPower extends AbstractPower {
	
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("PsionicPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.PSIONIC_POWER);

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
//		boolean isUsed = false;
//		if(card.type == CardType.ATTACK && !card.hasTag(CardTagsEnum.NOPSIONIC)){
//			isUsed = true;
//		}
//		if(card.hasTag(CardTagsEnum.SHIELD)) {
//			isUsed = true;
//		}
		
		if(!card.hasTag(CardTagsEnum.NOPSIONIC)) {
			if(card.type == CardType.ATTACK || card.hasTag(CardTagsEnum.SHIELD)) {
				if(AbstractDungeon.player.hasRelic(SlaytheStarCraft2Mod.makeID("KeyStone"))) {
					if(((KeyStone)AbstractDungeon.player.getRelic(SlaytheStarCraft2Mod.makeID("KeyStone"))).isFirstCard) {
						SlaytheStarCraft2Mod.logger.info("KeyStone activated");
						((KeyStone)AbstractDungeon.player.getRelic(SlaytheStarCraft2Mod.makeID("KeyStone"))).protectPsionic();
						SlaytheStarCraft2Mod.logger.info("KeyStone used this turn");
						return;
					}
				}
				this.flash();
				AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(owner, owner, this.ID));
			}
		}
//		if(isUsed) {
//			this.flash();
//			AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(owner, owner, this.ID));
//		}
		
	}

	@Override
	public float atDamageGive(float damage, DamageType type) {
		return type==DamageType.NORMAL?	damage += (float)this.amount : damage;
	}

	public float modifyShield(float shieldAmount) {
		SlaytheStarCraft2Mod.logger.info("Shield up by psionic");
		return shieldAmount+=(float)this.amount;
	}
//
//	@Override
//	public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
//		if(power.ID.equals(SlaytheStarCraft2Mod.makeID("ShieldPower"))) {
//			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(target, source, new ShieldPower(target, this.amount), this.amount));
//		}
//	}
//	
	
	
}
