package slaythestarcraft2mod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;

import slaythestarcraft2mod.initializers.ImgInitializer;

public class CounterAttackPower extends AbstractPower {
	public static final String POWER_ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("CounterAttackPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.COUNTERATTACK_POWER);

	public CounterAttackPower(AbstractCreature owner, int amount){
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
		this.description = sb.toString();
}

	@Override
	public int onAttacked(DamageInfo info, int damageAmount) {
		if(info.owner != null && damageAmount > 0 && info.type != DamageType.HP_LOSS) {
			this.flash();
			AbstractDungeon.actionManager.addToTop(new SFXAction("ATTACK_HEAVY"));
			if (Settings.FAST_MODE) {
				AbstractDungeon.actionManager.addToTop(new VFXAction(this.owner, new CleaveEffect(), 0.1F));
			} else {
				AbstractDungeon.actionManager.addToTop(new VFXAction(this.owner, new CleaveEffect(), 0.2F));
			}
			AbstractDungeon.actionManager.addToTop(new DamageAllEnemiesAction(owner,
					DamageInfo.createDamageMatrix(this.amount, true), DamageType.THORNS, AttackEffect.NONE));
		}
		return super.onAttacked(info, damageAmount);
		
	}

}
