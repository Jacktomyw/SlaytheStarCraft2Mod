package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;

import slaythestarcraft2mod.initializers.ImgInitializer;

public class TearingPower extends AbstractPower{
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("TearingPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.TEARING_POWER);
	
	public TearingPower(AbstractCreature owner, int amount) {
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = owner;
		this.amount = amount;
		if (this.amount >= 999) {
			this.amount = 999;
		}
		this.updateDescription();
		this.type = PowerType.DEBUFF;
		this.isTurnBased = false;
		this.img = new Texture(IMG);
	}

	public void updateDescription() {
			this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
	}

	@Override
	public void atEndOfTurn(boolean isPlayer) {
		if (!isPlayer && AbstractDungeon.getCurrRoom().phase == RoomPhase.COMBAT
				&& !AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
			this.flashWithoutSound();
			AbstractDungeon.actionManager
					.addToBottom(new DamageAction(owner,
							new DamageInfo(owner, amount, DamageType.THORNS), AttackEffect.SLASH_VERTICAL));
		}
	}
}
