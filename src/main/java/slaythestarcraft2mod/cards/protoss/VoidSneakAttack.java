package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.MultipleBasicValueAndShieldCustomCard;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.powers.PsionicPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class VoidSneakAttack extends MultipleBasicValueAndShieldCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("VoidSneakAttack");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.VOIDSNEAKATTACK);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.COMMON;
	private static final CardTarget TARGET = CardTarget.SELF;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	private static final int MAGIC_NUMBER = 3;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER = 2;
	private static final int MAGIC_NUMBER2 = 6;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER2 = 3;
	
	public VoidSneakAttack() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseMagicNumber = this.magicNumber = MAGIC_NUMBER;
		this.baseMagicNumber2 = this.magicNumber2 = MAGIC_NUMBER2;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		if(p.hasPower(SlaytheStarCraft2Mod.makeID("Concentrated"))) {
			p.getPower(SlaytheStarCraft2Mod.makeID("ConcentratedPower")).flash();
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new PsionicPower(p, this.magicNumber2), this.magicNumber2));
		}else {

			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new PsionicPower(p, this.magicNumber), this.magicNumber));
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new VoidSneakAttack();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeMagicNumber(UPGRADE_PLUS_MAGIC_NUMBER);
			this.upgradeMagicNumber2(UPGRADE_PLUS_MAGIC_NUMBER2);
			this.initializeDescription();
		}
	}
	
}
