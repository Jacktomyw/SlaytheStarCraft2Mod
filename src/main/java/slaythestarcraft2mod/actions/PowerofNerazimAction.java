package slaythestarcraft2mod.actions;

import java.util.ArrayList;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;

public class PowerofNerazimAction extends AbstractGameAction {

	private int amount;
	private AbstractCard card = null;
	private AbstractPlayer p = AbstractDungeon.player;

	public PowerofNerazimAction(int amount) {
		this.amount = amount;
		this.duration = Settings.ACTION_DUR_XFAST;
		this.actionType = ActionType.SPECIAL;
		ArrayList<AbstractCard> arr = AbstractDungeon.actionManager.cardsPlayedThisTurn;
		int i = arr.size()-1;
		if(i>=0) {
			while(arr.get(i).cardID.equals(SlaytheStarCraft2Mod.makeID("PowerofNerazim"))) {
				i--;
				if(i < 0) {
					break;
				}
			}
			if(i>=0) {
				card = arr.get(i);
			}
		}
	}
	
	
	@Override
	public void update() {{

		if (amount > 0) {
			AbstractMonster mo = AbstractDungeon.getMonsters().getRandomMonster(true);
			if(mo==null) {
				this.isDone = true;
				return;
			}
			AbstractCard c = card.makeSameInstanceOf();
			AbstractDungeon.player.limbo.addToBottom(c);
			c.current_x =c.current_x;
			c.current_y = c.current_y;
			c.target_x = (float) Settings.WIDTH / 2.0F - 300.0F * Settings.scale;
			c.target_y = (float) Settings.HEIGHT / 2.0F;
			c.freeToPlayOnce = true;
			c.purgeOnUse = true;
			AbstractDungeon.actionManager.cardsPlayedThisCombat.add(c);
			c.calculateCardDamage(mo);
			AbstractDungeon.actionManager.currentAction = null;
			c.use(p, mo);
			if (!c.dontTriggerOnUseCard) {
				p.hand.triggerOnOtherCardPlayed(c);
			}
			p.cardInUse = c;
			AbstractDungeon.actionManager.addToBottom(new UseCardAction(c, mo));
			AbstractDungeon.actionManager.addToBottom(this);
//			AbstractDungeon.actionManager.cardQueue.add(
//					new CardQueueItem(c, mo));
//			AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(c, mo, c.energyOnUse));
			if (!Settings.FAST_MODE) {
		        AbstractDungeon.actionManager.addToTop(new WaitAction(Settings.ACTION_DUR_MED));
			} else {
				AbstractDungeon.actionManager.addToTop(new WaitAction(Settings.ACTION_DUR_FASTER));
			}
			amount--;
				
//				AbstractDungeon.actionManager.addToBottom(new PlayCardRepeatlyAction(card, effect));
		}else {	
			this.isDone = true;
		}
	}}
}
