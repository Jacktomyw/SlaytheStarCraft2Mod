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
import slaythestarcraft2mod.patches.CardTagsEnum;
import slaythestarcraft2mod.powers.ShieldPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class ShadowBarrier extends MultipleBasicValueAndShieldCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("ShadowBarrier");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.SHADOWBARRIER);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.UNCOMMON;
	private static final CardTarget TARGET = CardTarget.SELF;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 2;
	private static final int SHIELD = 4;
	private static final int UPGRADE_PLUS_SHIELD = 1;
	
	public ShadowBarrier() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseShield = this.shield = SHIELD;
		this.tags.add(CardTagsEnum.SHIELD);
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		for(int i=0;i<2;i++)
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new ShieldPower(p, this.shield), this.shield));
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new ShadowBarrier();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeShield(UPGRADE_PLUS_SHIELD);
			this.initializeDescription();
		}
	}
	
}
