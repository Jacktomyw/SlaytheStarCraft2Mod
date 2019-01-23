package slaythestarcraft2mod.cards.protoss;

import java.util.Iterator;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import slaythestarcraft2mod.SlaytheStarCraft2Mod;
import slaythestarcraft2mod.abstracts.OverLoadCustomCard;
import slaythestarcraft2mod.initializers.ImgInitializer;
import slaythestarcraft2mod.patches.AbstractCardEnum;
import slaythestarcraft2mod.powers.TornPower;

public class PsionicOppression extends OverLoadCustomCard {


	public static final String ID = SlaytheStarCraft2Mod.makeID("PsionicOppression");
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	
	public static final String IMG = ImgInitializer.makePath(ImgInitializer.PSIONICOPPRESSION);
	
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
	
	
	private static final CardRarity RARITY = CardRarity.SPECIAL;
	private static final CardTarget TARGET = CardTarget.ENEMY;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = AbstractCardEnum.PROTOSS_BLUE;
	
	private static final int COST = 1;
	private static final int MAGIC_NUMBER = 2;
	private static final int OVERLOAD = 2;
	
	public PsionicOppression() {
		super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
		this.baseMagicNumber = this.magicNumber = MAGIC_NUMBER;
		this.overLoad = OVERLOAD;
	}
	
	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		if(upgraded) {
			Iterator<AbstractMonster> var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

			while (var3.hasNext()) {
				AbstractMonster mo = (AbstractMonster) var3.next();
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, p,
						new WeakPower(mo, this.magicNumber, false), this.magicNumber, true));
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, p,
						new VulnerablePower(mo, this.magicNumber, false), this.magicNumber, true));
				AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, p,
						new TornPower(mo, this.magicNumber), this.magicNumber, true));
			}
		}else {
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p,
					new WeakPower(m, this.magicNumber, false), this.magicNumber, true));
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p,
					new VulnerablePower(m, this.magicNumber, false), this.magicNumber, true));
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p,
					new TornPower(m, this.magicNumber), this.magicNumber, true));
		}
	}
	
	@Override
	public void upgrade() {
		if(!this.upgraded) {
			this.upgradeName();
			this.overLoad=3;
			this.target=CardTarget.ALL_ENEMY;
			this.rawDescription=UPGRADE_DESCRIPTION;
			this.initializeDescription();
		}
	}

}
