package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.actions.PowerofNerazimAction;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class PowerofNerazim extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("PowerofNerazim");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.POWEROFNERAZIM);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.RARE;
	private static final CardTarget TARGET = CardTarget.NONE;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = -1;
	
	public PowerofNerazim() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.exhaust = true;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		int effect = EnergyPanel.totalCount;

		if (p.hasRelic("Chemical X")) {
			effect += 2;
			p.getRelic("Chemical X").flash();
		}

		if (this.upgraded) {
			++effect;
		}
		if(effect>0) {
			AbstractDungeon.actionManager.addToBottom(
					new PowerofNerazimAction(effect));
		}
		if (!this.freeToPlayOnce) {
		      p.energy.use(EnergyPanel.totalCount);
	    }
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new PowerofNerazim();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.rawDescription = UPGRADE_DESCRIPTION;
			this.initializeDescription();
		}
	}
	
}
