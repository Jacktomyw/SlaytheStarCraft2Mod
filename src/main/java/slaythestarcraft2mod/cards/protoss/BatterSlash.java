package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.patches.AbstractCardEnum;

public class BatterSlash extends CustomCard{

	
	public static final String ID = slaythestarcraft2mod.SlaytheStarCraft2Mod.makeID("BatterSlash");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.BATTERSLASH);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 2;
	private static final int DAMAGE = 3;
	private static final int TIMES = 4;
	private static final int UPGRADE_PLUS_TIMES = 1;
	
	public BatterSlash() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DAMAGE;
		this.baseMagicNumber = this.magicNumber = TIMES;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		for(int i=0;i<this.magicNumber;i++) {
			AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAction(m, new DamageInfo(p,this.damage,this.damageTypeForTurn),
					AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new BatterSlash();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeMagicNumber(UPGRADE_PLUS_TIMES);
			this.initializeDescription();
		}
	}
	
}
