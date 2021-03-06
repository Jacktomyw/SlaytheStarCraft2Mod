package slaythestarcraft2mod.cards.protoss;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.powers.PylonPower;
import slaythestarcraft2mod.powers.GiftsfromXelNagaPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class GiftsfromXelNaga extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("GiftsfromXelNaga");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.GIFTSFROMXELNAGA);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.RARE;
	private static final CardTarget TARGET = CardTarget.SELF;
	private static final CardType TYPE = CardType.POWER;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	
	public GiftsfromXelNaga() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new GiftsfromXelNagaPower(p)));
		if(this.upgraded) {
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new PylonPower(p, 1),1));
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new GiftsfromXelNaga();
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
