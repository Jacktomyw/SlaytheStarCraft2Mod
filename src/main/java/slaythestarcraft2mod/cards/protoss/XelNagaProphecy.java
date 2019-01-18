package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.actions.XelNagaProphecyAction;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class XelNagaProphecy extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("XelNagaProphecy");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.XELNAGAPROPHECY);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.RARE;
	private static final CardTarget TARGET = CardTarget.NONE;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	
	public XelNagaProphecy() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		if (AbstractDungeon.player.drawPile.isEmpty()) {
			AbstractDungeon.actionManager.addToBottom(new EmptyDeckShuffleAction());
		}

		AbstractDungeon.actionManager.addToBottom(new XelNagaProphecyAction());
		AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, 1));
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new XelNagaProphecy();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeBaseCost(0);
			this.initializeDescription();
		}
	}
	
}
