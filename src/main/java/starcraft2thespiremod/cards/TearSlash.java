package starcraft2thespiremod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import starcraft2thespiremod.StarCraft2theSpireMod;
import starcraft2thespiremod.actions.TearingAction;
import starcraft2thespiremod.patches.AbstractCardEnum;
import starcraft2thespiremod.powers.TearingPower;

public class TearSlash extends CustomCard{

	public static final String ID = starcraft2thespiremod.StarCraft2theSpireMod.makeID("TearSlash");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = StarCraft2theSpireMod.makePath(StarCraft2theSpireMod.TEARSLASH);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.UNCOMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 2;
	private static final int DAMAGE = 14;
	private static final int UPGRADE_PLUS_DMG = 3;
	private static final int MAGIC_NUMBER = 2;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER = 1;
	
	public TearSlash() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DAMAGE;
		this.baseMagicNumber = this.magicNumber = MAGIC_NUMBER;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new TearingAction(m, new DamageInfo(p, this.baseDamage),
				this.magicNumber));
	}

	@Override
	public AbstractCard makeCopy() {
		return new TearSlash();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeDamage(UPGRADE_PLUS_DMG);
			this.upgradeMagicNumber(UPGRADE_PLUS_MAGIC_NUMBER);
			this.initializeDescription();
		}
	}
	
}
