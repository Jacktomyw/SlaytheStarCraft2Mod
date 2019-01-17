package slaythestarcraft2mod.cards.protoss;

import static slaythestarcraft2mod.patches.CardTagsEnum.SHIELD;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.powers.ShieldPower;

public class Blink extends CustomCard{

	
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("Blink");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.BLINK);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.SELF;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 0;
	private static final int MAGIC_NUMBER = 5;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER = 3;
	
	public Blink() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseMagicNumber = this.magicNumber = MAGIC_NUMBER;
		this.tags.add(SHIELD);
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p, new ShieldPower(p, this.magicNumber), this.magicNumber));
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new Blink();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeMagicNumber(UPGRADE_PLUS_MAGIC_NUMBER);
			this.initializeDescription();
		}
	}
	
}