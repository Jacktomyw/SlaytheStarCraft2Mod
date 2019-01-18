package slaythestarcraft2mod.cards.protoss;

import java.util.Iterator;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.MultipleBasicValueAndShieldCustomCard;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.powers.PsionicPower;
import slaythestarcraft2mod.initializers.ImgInitializer;

public class TwilightDescends extends MultipleBasicValueAndShieldCustomCard{

	
	public static final String ID = SlaytheStarCraft2Mod.makeID("TwilightDescends");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.TWILIGHTDESCENDS);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	
	private static final CardRarity RARITY = CardRarity.UNCOMMON;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 2;
	private static final int MAGIC_NUMBER = 5;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER = 3;
	private static final int MAGIC_NUMBER2 = 3;
	private static final int UPGRADE_PLUS_MAGIC_NUMBER2 = 1;
	
	public TwilightDescends() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseMagicNumber = this.magicNumber = MAGIC_NUMBER;
		this.baseMagicNumber2 = this.magicNumber2 = MAGIC_NUMBER2;
		this.exhaust = true;
	}
	
	@Override
	public void use(AbstractPlayer p,AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new PsionicPower(p, this.magicNumber), this.magicNumber));
		if(p.hasPower(SlaytheStarCraft2Mod.makeID("ConcentratedPower"))) {
			p.getPower(SlaytheStarCraft2Mod.makeID("ConcentratedPower")).flash();
			Iterator<AbstractMonster> var1 = AbstractDungeon.getMonsters().monsters.iterator();
			while (var1.hasNext()) {
				AbstractMonster mo = (AbstractMonster) var1.next();
				if (!mo.isDead && !mo.isDying) {
					AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, p,
							new WeakPower(mo, this.magicNumber2, false), this.magicNumber2));
				}
			}
		}
		else {
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p,
					new WeakPower(m, this.magicNumber2, false), this.magicNumber2));
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new TwilightDescends();
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
