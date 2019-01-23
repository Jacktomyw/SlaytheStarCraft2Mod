package slaythestarcraft2mod.cards.protoss;

import java.util.Iterator;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
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

public class PowerShow extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("PowerShow");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.POWERSHOW);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String[] EXTENDED_DESCRIPTION = cardStrings.EXTENDED_DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;

	private static final int COST = 1;
	private static final int MAGIC_NUMBER = 4;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER = 3;
	
	public PowerShow() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage=MAGIC_NUMBER;
		this.baseMagicNumber=this.magicNumber=MAGIC_NUMBER;
	}
	
	@Override
	public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
		Iterator<AbstractCard> i = AbstractDungeon.player.hand.group.iterator();
		while(i.hasNext()) {
			AbstractCard c = i.next();
			if(c.hasTag(CardTagsEnum.OVERLOAD)) {
				tmp += ((OverLoadCustomCard) c).overLoad;
			}
		}
		return tmp;
	}
	
	@Override
	public void calculateCardDamage(AbstractMonster mo) {
		super.calculateCardDamage(mo);
		this.rawDescription = DESCRIPTION;
		this.rawDescription = this.rawDescription + EXTENDED_DESCRIPTION[0];
		this.initializeDescription();
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(m, this.damage, this.damageTypeForTurn), AttackEffect.BLUNT_HEAVY));
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new PowerShow();
	}
	
	public void applyPowers() {
		super.applyPowers();
		this.rawDescription = DESCRIPTION;
		this.rawDescription = this.rawDescription + EXTENDED_DESCRIPTION[0];
		this.initializeDescription();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeMagicNumber(UPGRADE_PLUS_MAGIC_NUMBER);
			this.upgradeDamage(UPGRADE_PLUS_MAGIC_NUMBER);
			this.initializeDescription();
		}
	}
	
}
