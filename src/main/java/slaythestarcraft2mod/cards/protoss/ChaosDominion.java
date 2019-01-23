package slaythestarcraft2mod.cards.protoss;

import java.util.Iterator;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.OverLoadCustomCard;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.patches.CardTagsEnum;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class ChaosDominion extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("ChaosDominion");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.CHAOSDOMINION);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
	public static final String[] EXTENDED_DESCRIPTION = cardStrings.EXTENDED_DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.SELF;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	private static final int BLOCK = 0;
	
	public ChaosDominion() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseBlock = BLOCK;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		Iterator<AbstractCard> i = p.hand.group.iterator();
		while(i.hasNext()) {
			AbstractCard c = i.next();
			c.retain = true;
		}
		AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
		if (!this.upgraded) {
			this.rawDescription = DESCRIPTION;
		} else {
			this.rawDescription = UPGRADE_DESCRIPTION;
		}

		this.initializeDescription();
	}
	
	public void applyPowers() {
		int count = 0;
		Iterator<AbstractCard> i = AbstractDungeon.player.hand.group.iterator();
		while(i.hasNext()) {
			AbstractCard c = i.next();
			if(c.hasTag(CardTagsEnum.OVERLOAD)) {
				count += ((OverLoadCustomCard) c).overLoad;
			}
		}
		this.baseBlock = count;
		if (this.upgraded) {
			this.baseBlock += 3;
		}

		super.applyPowers();
		if (!this.upgraded) {
			this.rawDescription = DESCRIPTION;
		} else {
			this.rawDescription = UPGRADE_DESCRIPTION;
		}

		this.rawDescription = this.rawDescription + EXTENDED_DESCRIPTION[0];
		this.initializeDescription();
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new ChaosDominion();
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
