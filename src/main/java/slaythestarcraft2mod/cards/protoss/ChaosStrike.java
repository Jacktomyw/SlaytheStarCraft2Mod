package slaythestarcraft2mod.cards.protoss;

import java.util.ArrayList;
import java.util.Iterator;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.OverLoadCustomCard;
import slaythestarcraft2mod.patches.*;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class ChaosStrike extends OverLoadCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("ChaosStrike");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.CHAOSSTRIKE);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	private static final int DMG = 12;
	private static final int OVERLOAD = 2;
	
	public ChaosStrike() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.overLoad = OVERLOAD;
		this.baseDamage = DMG;
		this.tags.add(CardTags.STRIKE);
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AttackEffect.SLASH_DIAGONAL));
		Iterator<AbstractCard> i = CardLibrary.getCardList(LibraryTypeEnum.PROTOSS_BLUE).iterator();
		ArrayList<AbstractCard> overLoadCards = new ArrayList<AbstractCard>();
		while(i.hasNext()) {
			AbstractCard c = i.next();
			if(c.hasTag(CardTagsEnum.OVERLOAD)) {
				overLoadCards.add(c);
			}
		}
		AbstractCard c = overLoadCards.get(AbstractDungeon.cardRandomRng.random(overLoadCards.size()-1));
		if(upgraded) {
			c.setCostForTurn(0);
		}
		AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c, true));
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new ChaosStrike();
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
