package slaythestarcraft2mod.actions;

import java.util.ArrayList;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;

public class PowerofNerazimAction extends AbstractGameAction {

	private AbstractPlayer p;
	private boolean upgraded;
	private boolean freeToPlayOnce;
	private int energyOnUse;


	public PowerofNerazimAction(AbstractPlayer p, boolean upgraded, boolean freeToPlayOnce, int energyOnUse) {
		this.p = p;
		this.upgraded = upgraded;
		this.freeToPlayOnce = freeToPlayOnce;
		this.duration = Settings.ACTION_DUR_XFAST;
		this.actionType = ActionType.SPECIAL;
		this.energyOnUse = energyOnUse;
	}
	
	
	@Override
	public void update() {
		int effect = EnergyPanel.totalCount;
		if (this.energyOnUse != -1) {
			effect = this.energyOnUse;
		}

		if (this.p.hasRelic("Chemical X")) {
			effect += 2;
			this.p.getRelic("Chemical X").flash();
		}

		if (this.upgraded) {
			++effect;
		}

		if (effect > 0) {
			ArrayList<AbstractCard> arr = AbstractDungeon.actionManager.cardsPlayedThisTurn;
			int i = arr.size()-1;
			while(arr.get(i).cardID.equals(SlaytheStarCraft2Mod.makeID("PowerofNerazim"))) {
				i--;
				if(i < 0) {
					break;
				}
			}
			if(i >= 0) {
				while(effect>0) {
					AbstractCard card = arr.get(i).makeStatEquivalentCopy();
					AbstractDungeon.player.limbo.addToBottom(card);
					card.current_x = card.current_x;
					card.current_y = card.current_y;
					card.target_x = (float) Settings.WIDTH / 2.0F - 300.0F * Settings.scale;
					card.target_y = (float) Settings.HEIGHT / 2.0F;
					card.freeToPlayOnce = true;
					AbstractMonster mo = AbstractDungeon.getRandomMonster();
					card.calculateCardDamage(mo);
					card.purgeOnUse = true;
					AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(card, mo, card.energyOnUse));
					effect--;
				}
			}
			if (!this.freeToPlayOnce) {
				this.p.energy.use(EnergyPanel.totalCount);
			}
			
		}
		this.isDone = true;
	}

}
