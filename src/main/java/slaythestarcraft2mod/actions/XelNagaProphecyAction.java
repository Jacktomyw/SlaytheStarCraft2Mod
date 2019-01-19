package slaythestarcraft2mod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.EnergizedPower;

public class XelNagaProphecyAction extends AbstractGameAction {
	
	public XelNagaProphecyAction() {
		this.duration = 0.0F;
		this.actionType = ActionType.WAIT;
	}
	
	@Override
	public void update() {
		if (AbstractDungeon.player.drawPile.isEmpty()) {
			this.isDone = true;
		} else {
			AbstractCard card = AbstractDungeon.player.drawPile.getTopCard();
			int cost = card.cost;
			if(card.cost<0) {
				cost = 0;
			}
			if(!card.isEthereal)
				card.retain = true;
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new EnergizedPower(AbstractDungeon.player, cost), cost));
			this.isDone = true;
		}

	}

}
