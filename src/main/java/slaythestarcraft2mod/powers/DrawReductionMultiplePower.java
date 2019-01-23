package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class DrawReductionMultiplePower extends AbstractPower {
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("DrawReductionMultiplePower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.DRAWREDUCTIONMULTIPLE_POWER);

	public DrawReductionMultiplePower(AbstractCreature owner, int amount){
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = owner;
		this.amount = amount;
		this.updateDescription();
		this.type = PowerType.DEBUFF;
		this.isTurnBased = false;
		this.img = new Texture(IMG);
		if(this.amount>AbstractDungeon.player.gameHandSize) {
			this.amount = AbstractDungeon.player.gameHandSize;
		}
	}

	public void atEndOfRound() {
		AbstractDungeon.player.gameHandSize -= this.amount;
	}

	public void atStartOfTurnPostDraw() {
		AbstractDungeon.actionManager.addToBottom(
				new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
	}

	public void onRemove() {
		AbstractDungeon.player.gameHandSize += this.amount;
	}

	public void updateDescription() {
		this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
	}
	
}
