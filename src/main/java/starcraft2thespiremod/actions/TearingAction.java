package starcraft2thespiremod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

import starcraft2thespiremod.powers.TearingPower;

public class TearingAction extends AbstractGameAction{
	
	private DamageInfo info;
	private static final float DURATION = 0.1F;
	private int stack;
	
	public TearingAction(AbstractCreature target, DamageInfo info, int stack) {
		this.info = info;
		setValues(target, info);
		this.actionType = AbstractGameAction.ActionType.DAMAGE;
		this.duration = DURATION;
		this.stack = stack;
	}
	
	@Override
	public void update() {
		if ((this.duration == 0.1F) && (this.target != null)) {
			AbstractDungeon.effectList.add(
					new FlashAtkImgEffect(
							this.target.hb.cX,
							this.target.hb.cY,
							AbstractGameAction.AttackEffect.SLASH_HORIZONTAL
							)
					);
			AbstractMonster mon = (AbstractMonster) this.target;

			int tmp = mon.currentHealth;

			this.target.damage(this.info);


			if (!(((AbstractMonster) this.target).isDying) && mon.currentHealth < tmp) {
		        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mon, source, new TearingPower(mon, stack), stack));
			}

			if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
				AbstractDungeon.actionManager.clearPostCombatActions();
			}
		}
		tickDuration();
		
	}

}
