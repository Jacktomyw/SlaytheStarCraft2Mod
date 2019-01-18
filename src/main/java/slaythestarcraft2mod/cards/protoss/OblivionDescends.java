package slaythestarcraft2mod.cards.protoss;

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
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class OblivionDescends extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("OblivionDescends");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.OBLIVIONDESCENDS);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String[] EXTENDED_DESCRIPTION = cardStrings.EXTENDED_DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.ATTACK;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	private static final int DAMAGE = 0;
	private static final int MAGIC_NUMBER = 2;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER = 1;
	

	public OblivionDescends() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseDamage = DAMAGE;
		this.baseMagicNumber = this.magicNumber = MAGIC_NUMBER;
	}

	@Override
	public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
		if(!player.hasPower(SlaytheStarCraft2Mod.makeID("PsionicPower"))) {
			return tmp;
		}
		if(this.upgraded) {
			tmp += player.getPower(SlaytheStarCraft2Mod.makeID("PsionicPower")).amount;
		}
		tmp += player.getPower(SlaytheStarCraft2Mod.makeID("PsionicPower")).amount;
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
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(m, this.damage, this.damageTypeForTurn), AttackEffect.FIRE));
	}
	
	public void applyPowers() {
		super.applyPowers();
		this.rawDescription = DESCRIPTION;
		this.rawDescription = this.rawDescription + EXTENDED_DESCRIPTION[0];
		this.initializeDescription();
	}

	public void onMoveToDiscard() {
		this.rawDescription = DESCRIPTION;
		this.initializeDescription();
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new OblivionDescends();
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
