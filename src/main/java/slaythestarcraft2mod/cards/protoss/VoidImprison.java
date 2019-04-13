package slaythestarcraft2mod.cards.protoss;

import java.util.Iterator;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomCard;
import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class VoidImprison extends CustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("VoidImprison");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.VOIDIMPRISON);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.RARE;
	private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 4;
	
	public VoidImprison() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.isEthereal = true;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		if(p.hasPower(SlaytheStarCraft2Mod.makeID("ConcentratedPower"))) {
			p.getPower(SlaytheStarCraft2Mod.makeID("ConcentratedPower")).flash();
			this.exhaust = false;
		}
		else {
			this.exhaust = true;
		}
		Iterator<AbstractMonster> var1 = AbstractDungeon.getMonsters().monsters.iterator();
		while (var1.hasNext()) {
			AbstractMonster mo = (AbstractMonster) var1.next();
			if (!mo.isDead && !mo.isDying) {
				AbstractDungeon.actionManager.addToBottom(new StunMonsterAction(mo, p));
			}
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new VoidImprison();
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.upgradeBaseCost(3);
			this.initializeDescription();
		}
	}
	
}
